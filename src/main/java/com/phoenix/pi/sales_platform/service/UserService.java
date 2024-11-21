package com.phoenix.pi.sales_platform.service;

import com.phoenix.pi.sales_platform.dto.UpdateUserDto;
import com.phoenix.pi.sales_platform.dto.UserDtoRequest;
import com.phoenix.pi.sales_platform.dto.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDto createUser(UserDtoRequest userDto);

    List<UserDto> getAllUsers();

    Optional<UserDto> getUserById(Long id);

    void deleteUser(Long id);

    UserDto updateUser(Long id, UpdateUserDto updateUserDto);
}
