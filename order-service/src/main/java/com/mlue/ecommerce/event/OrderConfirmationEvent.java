package com.mlue.ecommerce.event;

import com.mlue.ecommerce.dto.OrderConfirmationDto;

public record OrderConfirmationEvent(OrderConfirmationDto orderConfirmationDto) { }
