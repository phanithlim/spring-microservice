package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductResponseDto(
    Long id,
    String name,
    String description,
    double availableQuantity,
    String price,
    CategoryResponseDto category
) {
}
