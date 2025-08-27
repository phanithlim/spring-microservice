package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderLineDto;
import com.mlue.ecommerce.mapper.OrderLineMapper;
import com.mlue.ecommerce.model.OrderLine;
import com.mlue.ecommerce.repository.OrderLineRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderLineServiceImpl implements OrderLineService {
    private final OrderLineRepository orderLineRepository;

    @Override
    public Long createOrder(OrderLineDto orderLineDto) {
        OrderLine orderLine = OrderLineMapper.INSTANCE.toEntity(orderLineDto);
        return orderLineRepository.save(orderLine).getId();
    }
}
