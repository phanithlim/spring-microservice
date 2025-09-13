package com.mlue.ecommerce.kafka;


import com.mlue.ecommerce.configuration.KafkaConfiguration;
import com.mlue.ecommerce.dto.OrderConfirmationDto;
import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.mapper.OrderMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OrderEventProducer {
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final KafkaConfiguration kafkaConfiguration;

    public void sendMessage(OrderConfirmationDto orderConfirmationDto) {
        OrderMessage message = OrderMapper.INSTANCE.mapToMessage(orderConfirmationDto);
        kafkaTemplate.send(kafkaConfiguration.getOrderTopic(), message);
    }

}
