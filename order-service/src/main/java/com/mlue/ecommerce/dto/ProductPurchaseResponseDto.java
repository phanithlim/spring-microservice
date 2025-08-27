package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import java.math.BigDecimal;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductPurchaseResponseDto(
        Long productId,
        String name,
        String description,
        BigDecimal prices,
        double quantity
) {
}
