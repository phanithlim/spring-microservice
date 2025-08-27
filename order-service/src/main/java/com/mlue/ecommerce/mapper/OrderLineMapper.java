package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.OrderLineDto;
import com.mlue.ecommerce.model.Order;
import com.mlue.ecommerce.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

@Mapper
public interface OrderLineMapper {
    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class);

    @Mapping(target = "order", source = "orderId", qualifiedByName = "orderIdToOrder")
    OrderLine toEntity(OrderLineDto orderLineDto);

    @Named("orderIdToOrder")
    default Order orderIdToOrder(Long orderId) {
        if (orderId == null) return null;
        Order order = new Order();
        order.setId(orderId);
        return order;
    }
}
