package com.mlue.ecommerce.dto.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductPurchaseResponseDto(
        Long productId,
        String name,
        String description,
        double price,
        double quantity
) {
}
