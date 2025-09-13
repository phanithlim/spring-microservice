package com.mlue.ecommerce.configuration;

import lombok.Data;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@Configuration
@Data
public class KafkaConfiguration {

    @Value(value = "${spring.kafka.bootstrap-servers}")
    private String kafkaServers;

    @Value(value = "${spring.kafka.schema-registry-url}")
    private String schemaRegistryUrl;

    @Value(value = "${spring.kafka.num-partition}")
    private int numPartition;

    @Value(value = "${spring.kafka.num-replica-factor}")
    private short numReplicaFactor;

    @Value(value = "${order-service.order-topic}")
    private String orderTopic;

    @Bean
    public NewTopic orderTopic() {
        return new NewTopic(orderTopic, numPartition, numReplicaFactor);
    }

}
