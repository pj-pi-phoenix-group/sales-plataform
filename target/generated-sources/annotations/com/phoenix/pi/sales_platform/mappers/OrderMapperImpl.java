package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.OrderDto;
import com.phoenix.pi.sales_platform.model.entity.Order;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-10T09:12:22-0300",
    comments = "version: 1.6.0.Beta1, compiler: javac, environment: Java 17.0.12 (Amazon.com Inc.)"
)
@Component
public class OrderMapperImpl implements OrderMapper {

    @Override
    public OrderDto toDto(Order order) {
        if ( order == null ) {
            return null;
        }

        OrderDto orderDto = new OrderDto();

        return orderDto;
    }

    @Override
    public Order toEntity(OrderDto orderDto) {
        if ( orderDto == null ) {
            return null;
        }

        Order order = new Order();

        return order;
    }
}
