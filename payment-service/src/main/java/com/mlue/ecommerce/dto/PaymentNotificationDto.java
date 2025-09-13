package com.mlue.ecommerce.dto;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mlue.ecommerce.constant.PaymentMethod;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record PaymentNotificationDto(

        @NotNull(message = "Order ID cannot be null")
        String orderReference,

        @Positive(message = "Total amount must be positive")
        double totalAmount,
        @NotNull(message = "Payment method cannot be null")
        PaymentMethod paymentMethod,

        @NotNull(message = "First name cannot be null")
        @NotBlank(message = "First name cannot be blank")
        String customerFirstName,

        @NotNull(message = "Customer cannot be null")
        @NotBlank(message = "Last name cannot be blank")
        String customerLastName,

        @NotNull(message = "Email cannot be null")
        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String customerEmail

) { }
