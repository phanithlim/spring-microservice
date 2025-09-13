package com.mlue.ecommerce.model;


import com.mlue.ecommerce.constant.NotificationType;
import com.mlue.ecommerce.dto.order.OrderConfirmationDto;
import com.mlue.ecommerce.dto.payment.PaymentConfirmationDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Notification {
    @Id
    private String id;
    private NotificationType type;

    @CreatedDate
    private Instant createdAt;
    private OrderConfirmationDto orderConfirmation;
    private PaymentConfirmationDto paymentConfirmation;
}
