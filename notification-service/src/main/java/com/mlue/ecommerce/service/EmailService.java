package com.mlue.ecommerce.service;

import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;
import jakarta.mail.MessagingException;

public interface EmailService {
    void sendPaymentSuccessEmail(PaymentMessage paymentMessage) throws MessagingException;
    void sendOrderConfirmationEmail(OrderMessage orderMessage) throws MessagingException;
}
