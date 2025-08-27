package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderDto;

public interface OrderService {
    Integer createOrder(OrderDto orderDto);
}
