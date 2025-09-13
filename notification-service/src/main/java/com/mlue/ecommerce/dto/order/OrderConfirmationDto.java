package com.mlue.ecommerce.dto.order;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import com.mlue.ecommerce.constant.PaymentMethod;

import java.util.List;

@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class)
public record OrderConfirmationDto(
        String orderReference,
        double totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponseDto customer,
        List<ProductPurchaseResponseDto> products
) {
}
