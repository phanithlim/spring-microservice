package com.mlue.ecommerce.service;


import com.mlue.ecommerce.client.PaymentClient;
import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.dto.*;
import com.mlue.ecommerce.event.OrderConfirmationEvent;
import com.mlue.ecommerce.expection.CustomerException;
import com.mlue.ecommerce.client.CustomerClient;
import com.mlue.ecommerce.client.ProductClient;
import com.mlue.ecommerce.expection.NotFoundException;
import com.mlue.ecommerce.mapper.OrderMapper;
import com.mlue.ecommerce.model.Order;
import com.mlue.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;
    private final ApplicationEventPublisher applicationEventPublisher;
    private final PaymentClient paymentClient;

    @Override
    public Long createOrder(OrderDto orderDto) {
        ApiResponse<CustomerResponseDto> customer = customerClient.getCustomer(orderDto.customerId());
        if (customer.getError() != 0) {
            throw new CustomerException("Cannot create order:: " + customer.getMessage());
        }

        log.info("Purchasing products: {}", orderDto.products());
        ApiResponse<List<ProductPurchaseResponseDto>> productResponse = productClient.purchaseProducts(orderDto.products());
        if (productResponse.getError() != 0) {
            throw new CustomerException("Cannot create order:: " + productResponse.getMessage());
        }

        Order order = orderRepository.save(OrderMapper.INSTANCE.mapToEntity(orderDto));
        for (ProductPurchaseDto purchaseRequest : orderDto.products()) {
            orderLineService.createOrder(
                    new OrderLineDto(
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        PaymentDto paymentDto = new PaymentDto(
                orderDto.reference(),
                orderDto.totalAmount(),
                orderDto.paymentMethod(),
                order.getId(),
                customer.getData()
        );
        ApiResponse<Long> paymentResponse = paymentClient.createPayment(paymentDto);
        if (paymentResponse.getError() != 0) {
            throw new CustomerException("Cannot create order:: " + paymentResponse.getMessage());
        }
        log.info("Payment processed with id: {}", paymentResponse.getData());


        OrderConfirmationDto orderConfirmationDto = new OrderConfirmationDto(
                orderDto.reference(),
                orderDto.totalAmount(),
                orderDto.paymentMethod(),
                customer.getData(),
                productResponse.getData()
        );
        applicationEventPublisher.publishEvent(new OrderConfirmationEvent(orderConfirmationDto));
        return order.getId();
    }

    @Override
    public List<OrderResponseDto> getAllOrders() {
        List<Order> orders = orderRepository.findAll();
        return OrderMapper.INSTANCE.mapToListResponseDto(orders);
    }

    @Override
    public OrderResponseDto getOrderById(Long id) {
        return orderRepository.findById(id).map(OrderMapper.INSTANCE::mapToResponseDto)
                .orElseThrow(() -> new NotFoundException("Order not found with id: " + id));
    }


}
