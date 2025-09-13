package com.mlue.ecommerce.service;

import com.mlue.ecommerce.order.OrderMessage;
import com.mlue.ecommerce.payment.PaymentMessage;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import org.thymeleaf.context.Context;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.thymeleaf.spring6.SpringTemplateEngine;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import static com.mlue.ecommerce.constant.EmailTemplate.ORDER_CONFIRMATION;
import static com.mlue.ecommerce.constant.EmailTemplate.PAYMENT_CONFIRMATION;

@Service
@RequiredArgsConstructor
public class EmailServiceImpl implements EmailService {
    private final JavaMailSender mailSender;
    private final SpringTemplateEngine templateEngine;

    @Override
    @Async
    public void sendPaymentSuccessEmail(PaymentMessage paymentMessage) throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        helper.setFrom("contact@mlue-shop.com");

        final String templateName = PAYMENT_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", paymentMessage.getCustomerFirstName() + " " + paymentMessage.getCustomerLastName());
        variables.put("amount", paymentMessage.getTotalAmount());
        variables.put("orderReference", paymentMessage.getOrderReference());

        Context context = new Context();
        context.setVariables(variables);
        helper.setSubject(PAYMENT_CONFIRMATION.getSubject());

        try {
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            helper.setTo(paymentMessage.getCustomerEmail());
            mailSender.send(mimeMailMessage);
        } catch (Exception e) {
            throw new MessagingException("Failed to send email", e);
        }

    }

    @Override
    @Async
    public void sendOrderConfirmationEmail(OrderMessage orderMessage) throws MessagingException {
        MimeMessage mimeMailMessage = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(mimeMailMessage, MimeMessageHelper.MULTIPART_MODE_RELATED, StandardCharsets.UTF_8.name());
        helper.setFrom("contact@mlue-shop.com");

        final String templateName = ORDER_CONFIRMATION.getTemplate();
        Map<String, Object> variables = new HashMap<>();
        variables.put("customerName", orderMessage.getCustomer().getFirstName() + " " + orderMessage.getCustomer().getLastName());
        variables.put("orderReference", orderMessage.getOrderReference());
        variables.put("totalAmount", orderMessage.getTotalAmount());
        variables.put("products", orderMessage.getPurchaseItems());

        Context context = new Context();
        context.setVariables(variables);
        helper.setSubject(ORDER_CONFIRMATION.getSubject());

        try {
            String htmlContent = templateEngine.process(templateName, context);
            helper.setText(htmlContent, true);
            helper.setTo(orderMessage.getCustomer().getEmail());
            mailSender.send(mimeMailMessage);
        } catch (Exception e) {
            throw new MessagingException("Failed to send order confirmation email", e);
        }
    }

}
