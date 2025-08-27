package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.OrderLineDto;

public interface OrderLineService {
    Long createOrder(OrderLineDto orderLineDto);
}
