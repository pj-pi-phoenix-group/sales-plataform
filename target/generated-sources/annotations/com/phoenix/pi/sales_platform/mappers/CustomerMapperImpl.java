package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.CustomerDto;
import com.phoenix.pi.sales_platform.dto.CustomerDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.Customer;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-28T10:07:18-0300",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Override
    public CustomerDto toDto(Customer user) {
        if ( user == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setStatus( user.getStatus() );
        customerDto.setCustomerId( user.getCustomerId() );
        customerDto.setName( user.getName() );
        customerDto.setEmail( user.getEmail() );
        customerDto.setAddress( user.getAddress() );
        customerDto.setPhone( user.getPhone() );
        customerDto.setUserId( user.getUserId() );

        return customerDto;
    }

    @Override
    public Customer toEntity(CustomerDtoRequest userDto) {
        if ( userDto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setName( userDto.getName() );
        customer.setEmail( userDto.getEmail() );
        customer.setAddress( userDto.getAddress() );
        customer.setPhone( userDto.getPhone() );
        customer.setUserId( userDto.getUserId() );
        customer.setStatus( userDto.getStatus() );

        return customer;
    }
}
