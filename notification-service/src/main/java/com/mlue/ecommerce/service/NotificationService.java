package com.mlue.ecommerce.service;

import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;

public interface NotificationService {
    void handleRetrievePaymentConfirmation(PaymentMessage paymentMessage);
    void handleRetrieveOrderConfirmation(OrderMessage orderMessage);
}
