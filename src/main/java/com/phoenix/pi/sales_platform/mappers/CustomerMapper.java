package com.phoenix.pi.sales_platform.mappers;
import org.mapstruct.Mapper;

import com.phoenix.pi.sales_platform.dto.CustomerDto;
import com.phoenix.pi.sales_platform.dto.CustomerDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.Customer;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerDto toDto (Customer user);
    Customer toEntity(CustomerDtoRequest userDto);

}
