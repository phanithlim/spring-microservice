package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.PaymentDto;
import com.mlue.ecommerce.dto.PaymentNotificationDto;
import com.mlue.ecommerce.model.Payment;
import com.mlue.ecommerce.payment.PaymentMessage;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PaymentMapper {
    PaymentMapper INSTANCE = Mappers.getMapper(PaymentMapper.class);
    Payment mapToEntity(PaymentDto paymentDto);

    PaymentMessage mapToMessage(PaymentNotificationDto paymentNotificationDto);
}
