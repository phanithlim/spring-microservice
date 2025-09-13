package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mlue.ecommerce.constant.PaymentMethod;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record OrderDto(
        String reference,

        @Positive(message = "Amount must be positive")
        BigDecimal totalAmount,

        @NotNull(message = "Payment method is required")
        PaymentMethod paymentMethod,

        @NotNull(message = "Customer ID is required")
        @NotEmpty(message = "Customer ID cannot be empty")
        @NotBlank(message = "Customer ID cannot be blank")
        String customerId,

        @NotEmpty(message = "Products cannot be empty")
        List<ProductPurchaseDto> products

) {
}
