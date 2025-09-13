package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderLineDto;
import com.mlue.ecommerce.dto.OrderLineResponseDto;
import com.mlue.ecommerce.mapper.OrderLineMapper;
import com.mlue.ecommerce.model.OrderLine;
import com.mlue.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;

    @Override
    public Long createOrder(OrderLineDto orderLineDto) {
        OrderLine orderLine = OrderLineMapper.INSTANCE.mapToEntity(orderLineDto);
        orderLineRepository.save(orderLine);
        return orderLine.getId();
    }

    @Override
    public List<OrderLineResponseDto> getOrderLinesByOrderId(Long orderId) {
        List<OrderLine> orderLines = orderLineRepository.findAllByOrderId(orderId);
        return OrderLineMapper.INSTANCE.mapToDtoList(orderLines);
    }
}
