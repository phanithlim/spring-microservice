package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductDto(
    @NotNull(message = "Name cannot be null")
    String name,
    @Nullable
    String description,
    @Positive(message = "Available quantity must be positive")
    double availableQuantity,
    @NotNull(message = "Price cannot be null")
    String price,
    @NotNull(message = "Category ID cannot be null")
    Long categoryId
) {
}
