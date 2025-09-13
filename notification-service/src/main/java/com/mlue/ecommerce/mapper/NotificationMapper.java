package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.model.Notification;
import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper
public interface NotificationMapper {
    NotificationMapper INSTANCE = Mappers.getMapper(NotificationMapper.class);

    @Mapping(target = "paymentConfirmation", source = "paymentMessage")
    Notification mapToEntity(PaymentMessage paymentMessage);

    @Mapping(target = "orderConfirmation", source = "orderMessage")
    @Mapping(target = "orderConfirmation.products" , source = "purchaseItems")
    @Mapping(target = "orderConfirmation.orderReference", source = "orderReference")
    @Mapping(target = "orderConfirmation.totalAmount", source = "totalAmount")
    @Mapping(target = "orderConfirmation.paymentMethod", source = "paymentMethod")
    Notification mapToEntity(OrderMessage orderMessage);
}
