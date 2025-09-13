package com.mlue.ecommerce.listener;

import com.mlue.ecommerce.dto.OrderConfirmationDto;
import com.mlue.ecommerce.event.OrderConfirmationEvent;
import com.mlue.ecommerce.kafka.OrderEventProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderConfirmationListener {
    private final OrderEventProducer orderEventProducer;


    @TransactionalEventListener
    public void handleOrderConfirmationEvent(OrderConfirmationEvent orderConfirmationEvent) {
        OrderConfirmationDto event = orderConfirmationEvent.orderConfirmationDto();
        log.info("Received Order Confirmation Event: {}", event);
        orderEventProducer.sendMessage(event);
    }
}
