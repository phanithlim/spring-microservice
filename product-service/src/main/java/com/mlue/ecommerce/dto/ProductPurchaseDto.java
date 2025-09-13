package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record ProductPurchaseDto(
        @NotNull(message = "Product ID must not be null")
        @JsonProperty("product_id")
        Long id,

        @NotNull(message = "Quantity must not be null")
        @Positive(message = "Quantity must be greater than zero")
        double quantity
) {
}
