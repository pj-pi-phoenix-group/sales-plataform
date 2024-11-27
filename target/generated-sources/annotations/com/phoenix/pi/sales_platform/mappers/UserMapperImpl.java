package com.phoenix.pi.sales_platform.mappers;

import com.phoenix.pi.sales_platform.dto.UserDto;
import com.phoenix.pi.sales_platform.dto.UserDtoRequest;
import com.phoenix.pi.sales_platform.model.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-27T18:30:35-0300",
    comments = "version: 1.6.0.Beta1, compiler: Eclipse JDT (IDE) 3.40.0.z20241023-1306, environment: Java 17.0.13 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDto toDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setEmail( user.getEmail() );
        userDto.setName( user.getName() );
        userDto.setNumber( user.getNumber() );
        userDto.setPassword( user.getPassword() );
        userDto.setUserId( user.getUserId() );

        return userDto;
    }

    @Override
    public User toEntity(UserDtoRequest userDto) {
        if ( userDto == null ) {
            return null;
        }

        User user = new User();

        user.setEmail( userDto.getEmail() );
        user.setName( userDto.getName() );
        user.setNumber( userDto.getNumber() );
        user.setPassword( userDto.getPassword() );

        return user;
    }
}