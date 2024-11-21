package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.UserDtoRequest;
import com.phoenix.pi.sales_platform.dto.UserDto;
import com.phoenix.pi.sales_platform.model.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDto toDto (User user);
    User toEntity(UserDtoRequest userDto);

}
