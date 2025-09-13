package com.mlue.ecommerce.listener;

import com.mlue.ecommerce.dto.OrderConfirmationDto;
import com.mlue.ecommerce.event.OrderConfirmationEvent;
import com.mlue.ecommerce.kafka.OrderEventProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.transaction.event.TransactionalEventListener;

@Component
@RequiredArgsConstructor
public class OrderConfirmationListener {
    private final OrderEventProducer orderEventProducer;


    @TransactionalEventListener
    public void handleOrderConfirmationEvent(OrderConfirmationEvent orderConfirmationEvent) {
        OrderConfirmationDto event = orderConfirmationEvent.orderConfirmationDto();
        orderEventProducer.sendMessage(event);
    }
}
