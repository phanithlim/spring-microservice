package com.mlue.ecommerce.service;

import com.mlue.ecommerce.dto.PaymentDto;
import com.mlue.ecommerce.dto.PaymentNotificationDto;
import com.mlue.ecommerce.event.PaymentNotificationEvent;
import com.mlue.ecommerce.mapper.PaymentMapper;
import com.mlue.ecommerce.model.Payment;
import com.mlue.ecommerce.repository.PaymentRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@Transactional
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    @Override
    public Long createPayment(PaymentDto paymentDto) {
        Payment payment = PaymentMapper.INSTANCE.mapToEntity(paymentDto);

        PaymentNotificationDto paymentNotificationDto = new PaymentNotificationDto(
                paymentDto.orderReference(),
                paymentDto.amount(),
                paymentDto.paymentMethod(),
                paymentDto.customer().firstName(),
                paymentDto.customer().lastName(),
                paymentDto.customer().email()
        );
        applicationEventPublisher.publishEvent(new PaymentNotificationEvent(paymentNotificationDto));
        return paymentRepository.save(payment).getId();
    }
}
