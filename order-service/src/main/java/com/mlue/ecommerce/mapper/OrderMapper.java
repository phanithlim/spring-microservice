package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.OrderDto;
import com.mlue.ecommerce.model.Order;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderMapper {
    OrderMapper INSTANCE = Mappers.getMapper(OrderMapper.class);
    Order toEntity(OrderDto orderDto);
}
