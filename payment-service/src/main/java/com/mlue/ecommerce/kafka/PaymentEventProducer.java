package com.mlue.ecommerce.kafka;

import com.mlue.ecommerce.configuration.KafkaConfiguration;
import com.mlue.ecommerce.dto.PaymentNotificationDto;
import com.mlue.ecommerce.mapper.PaymentMapper;
import com.mlue.ecommerce.payment.PaymentMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class PaymentEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaConfiguration kafkaConfiguration;

    public void sendMessage(PaymentNotificationDto paymentNotificationDto) {
        PaymentMessage message = PaymentMapper.INSTANCE.mapToMessage(paymentNotificationDto);
        kafkaTemplate.send(kafkaConfiguration.getPaymentTopic(), message);
        log.info("Sending order confirmation message: {}", message);
    }
}
