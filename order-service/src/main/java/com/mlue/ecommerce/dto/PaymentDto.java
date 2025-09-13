package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mlue.ecommerce.constant.PaymentMethod;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PaymentDto(
        @NotNull(message = "Order reference cannot be null")
        String orderReference,

        double amount,
        @NotNull(message = "Payment method cannot be null")
        PaymentMethod paymentMethod,
        @NotNull(message = "Order ID cannot be null")
        Long orderId,
        @NotNull(message = "Customer cannot be null")
        CustomerResponseDto customer
) {}
