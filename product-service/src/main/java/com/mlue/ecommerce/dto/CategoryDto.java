package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record CategoryDto(
        @NotNull(message = "Name cannot be null")
        String name,
        @Nullable()
        String description
) {
}
