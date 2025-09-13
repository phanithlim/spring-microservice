package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.PaymentDto;

public interface PaymentService {
    Long createPayment(PaymentDto paymentDto);
}
