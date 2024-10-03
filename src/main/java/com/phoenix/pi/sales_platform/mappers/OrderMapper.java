package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.OrderDto;
import com.phoenix.pi.sales_platform.model.Order;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDto toDto(Order order);

    Order toEntity(OrderDto orderDto);
}
