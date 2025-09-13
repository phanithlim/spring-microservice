package com.mlue.ecommerce.mapper;

import com.mlue.ecommerce.dto.OrderLineDto;
import com.mlue.ecommerce.dto.OrderLineResponseDto;
import com.mlue.ecommerce.model.Order;
import com.mlue.ecommerce.model.OrderLine;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface OrderLineMapper {
    OrderLineMapper INSTANCE = Mappers.getMapper(OrderLineMapper.class);

    List<OrderLineResponseDto> mapToDtoList(List<OrderLine> orderLines);

    @Mapping(target = "order", source = "orderId", qualifiedByName = "orderIdToOrder")
    OrderLine mapToEntity(OrderLineDto orderLineDto);

    @Named("orderIdToOrder")
    default Order orderIdToOrder(Long orderId) {
        if (orderId == null) return null;
        Order order = new Order();
        order.setId(orderId);
        return order;
    }
}
