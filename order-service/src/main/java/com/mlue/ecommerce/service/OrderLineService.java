package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderLineDto;
import com.mlue.ecommerce.dto.OrderLineResponseDto;

import java.util.List;

public interface OrderLineService {
    Long createOrder(OrderLineDto orderLineDto);
    List<OrderLineResponseDto> getOrderLinesByOrderId(Long orderId);
}
