package com.mlue.ecommerce.kafka;


import com.mlue.ecommerce.configuration.KafkaConfiguration;
import com.mlue.ecommerce.dto.OrderConfirmationDto;
import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
@Slf4j
public class OrderEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaConfiguration kafkaConfiguration;

    public void sendMessage(OrderConfirmationDto orderConfirmationDto) {
        OrderMessage message = OrderMapper.INSTANCE.mapToMessage(orderConfirmationDto);
        log.info("Sending order confirmation message: {}", message);
        kafkaTemplate.send(kafkaConfiguration.getOrderTopic(), message);
    }

}
