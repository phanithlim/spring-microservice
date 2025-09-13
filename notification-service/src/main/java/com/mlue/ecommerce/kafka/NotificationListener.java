package com.mlue.ecommerce.kafka;

import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;
import com.mlue.ecommerce.service.EmailService;
import com.mlue.ecommerce.service.NotificationService;
import jakarta.mail.MessagingException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class NotificationListener {
    private final NotificationService notificationService;
    private final EmailService emailService;

    @KafkaListener(topics = "${notification-service.payment-topic}", groupId = "notification-group")
    void handlePaymentNotification(@Payload @Valid PaymentMessage paymentMessage) throws MessagingException {
        notificationService.handleRetrievePaymentConfirmation(paymentMessage);
        emailService.sendPaymentSuccessEmail(paymentMessage);

    }

    @KafkaListener(topics = "${notification-service.order-topic}", groupId = "notification-group")
    void handleOrderNotification(@Payload @Valid OrderMessage orderMessage) throws MessagingException {
        notificationService.handleRetrieveOrderConfirmation(orderMessage);
        emailService.sendOrderConfirmationEmail(orderMessage);
    }
}
