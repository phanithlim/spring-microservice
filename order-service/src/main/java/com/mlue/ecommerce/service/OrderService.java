package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderDto;
import com.mlue.ecommerce.dto.OrderResponseDto;
import java.util.List;

public interface OrderService {
    Long createOrder(OrderDto orderDto);
    List<OrderResponseDto> getAllOrders();
    OrderResponseDto getOrderById(Long id);
}
