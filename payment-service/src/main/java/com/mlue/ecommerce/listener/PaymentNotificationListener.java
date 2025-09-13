package com.mlue.ecommerce.listener;

import com.mlue.ecommerce.dto.PaymentNotificationDto;
import com.mlue.ecommerce.event.PaymentNotificationEvent;
import com.mlue.ecommerce.kafka.PaymentEventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentNotificationListener {
    private final PaymentEventProducer paymentEventProducer;

    @TransactionalEventListener
    public void handleOrderConfirmationEvent(PaymentNotificationEvent paymentNotificationEvent) {
        PaymentNotificationDto event = paymentNotificationEvent.paymentNotificationDto();
        log.info("Received Order Confirmation Event: {}", event);
        paymentEventProducer.sendMessage(event);
    }
}
