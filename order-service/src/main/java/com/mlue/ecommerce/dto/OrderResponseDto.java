package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mlue.ecommerce.constant.PaymentMethod;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record OrderResponseDto(
    Long id,
    String reference,
    BigDecimal totalAmount,
    PaymentMethod paymentMethod,
    String customerId
) {}
