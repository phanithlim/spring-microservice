package com.mlue.ecommerce.controller;

import com.mlue.ecommerce.core.ApiResponse;
import com.mlue.ecommerce.core.BaseController;
import com.mlue.ecommerce.dto.PaymentDto;
import com.mlue.ecommerce.service.PaymentService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/payments")
@RequiredArgsConstructor
public class PaymentController extends BaseController {
    private final PaymentService paymentService;

    @PostMapping
    public ResponseEntity<ApiResponse<Long>> createPayment(@RequestBody @Valid PaymentDto paymentDto) {
        return getOkResponse(paymentService.createPayment(paymentDto));
    }
}
