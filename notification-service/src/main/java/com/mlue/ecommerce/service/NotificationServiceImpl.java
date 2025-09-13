package com.mlue.ecommerce.service;

import com.mlue.ecommerce.constant.NotificationType;
import com.mlue.ecommerce.mapper.NotificationMapper;
import com.mlue.ecommerce.model.Notification;
import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;
import com.mlue.ecommerce.repository.NotificationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class NotificationServiceImpl implements NotificationService {
    private final NotificationRepository notificationRepository;

    @Override
    public void handleRetrievePaymentConfirmation(PaymentMessage paymentMessage) {
        Notification notification = NotificationMapper.INSTANCE.mapToEntity(paymentMessage);
        notification.setType(NotificationType.PAYMENT_CONFIRMATION);
        notificationRepository.save(notification);
    }

    @Override
    public void handleRetrieveOrderConfirmation(OrderMessage orderMessage) {
        Notification notification = NotificationMapper.INSTANCE.mapToEntity(orderMessage);
        notification.setType(NotificationType.ORDER_CONFIRMATION);
        notificationRepository.save(notification);
    }
}
