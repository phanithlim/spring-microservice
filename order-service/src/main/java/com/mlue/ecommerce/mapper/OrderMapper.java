package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.OrderConfirmationDto;
import com.mlue.ecommerce.dto.OrderDto;
import com.mlue.ecommerce.dto.OrderResponseDto;
import com.mlue.ecommerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import com.mlue.ecommerce.order.OrderMessage;

import java.util.List;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order mapToEntity(OrderDto orderDto);

    OrderMessage mapToMessage(OrderConfirmationDto orderConfirmationDto);

    List<OrderResponseDto> mapToListResponseDto(List<Order> orders);
    OrderResponseDto mapToResponseDto(Order order);
}
