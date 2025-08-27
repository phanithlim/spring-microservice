package com.mlue.ecommerce.service;


import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.dto.*;
import com.mlue.ecommerce.expection.CustomerException;
import com.mlue.ecommerce.client.CustomerClient;
import com.mlue.ecommerce.client.ProductClient;
import com.mlue.ecommerce.mapper.OrderMapper;
import com.mlue.ecommerce.model.Order;
import com.mlue.ecommerce.repository.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderRepository orderRepository;
    private final OrderLineService orderLineService;

    @Override
    public Integer createOrder(OrderDto orderDto) {
        ApiResponse<CustomerResponseDto> customer = customerClient.getCustomer(orderDto.customerId());
        if (customer.getError() != 0) {
            throw new CustomerException("Cannot create order:: " + customer.getMessage());
        }

        ApiResponse<List<ProductPurchaseResponseDto>> productResponse = productClient.purchaseProducts(orderDto.products());
        if (productResponse.getError() != 0) {
            throw new CustomerException("Cannot create order:: " + productResponse.getMessage());
        }

        Order order = orderRepository.save(OrderMapper.INSTANCE.toEntity(orderDto));
        for (ProductPurchaseDto purchaseRequest : orderDto.products()) {
            orderLineService.createOrder(
                    new OrderLineDto(
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }



        return 0;
    }
}
