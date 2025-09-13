package com.mlue.ecommerce.client;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.dto.PaymentDto;
import jakarta.validation.Valid;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "payment-service",
        url = "${application.config.payment-url}"
)
public interface PaymentClient {

    @PostMapping
    ApiResponse<Long> createPayment(@RequestBody @Valid PaymentDto paymentDto);
}
