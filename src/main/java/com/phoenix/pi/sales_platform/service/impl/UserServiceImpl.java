package com.phoenix.pi.sales_platform.service.impl;

import com.phoenix.pi.sales_platform.dto.UpdateUserDto;
import com.phoenix.pi.sales_platform.dto.UserDtoRequest;
import com.phoenix.pi.sales_platform.dto.UserDto;
import com.phoenix.pi.sales_platform.exception.ProductException;
import com.phoenix.pi.sales_platform.exception.UserException;
import com.phoenix.pi.sales_platform.mappers.UserMapper;
import com.phoenix.pi.sales_platform.model.entity.Product;
import com.phoenix.pi.sales_platform.model.entity.User;
import com.phoenix.pi.sales_platform.repository.UserRepository;
import com.phoenix.pi.sales_platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public UserDto createUser(UserDtoRequest userDto) {
        User user = userMapper.toEntity(userDto);

        if (Objects.isNull(userDto)){
            throw new UserException("It cannot be null");
        }
        User savedUser = userRepository.save(user);
        return userMapper.toDto(savedUser);
    }

    @Override
    public Optional<UserDto> getUserById(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));

        return Optional.ofNullable(userMapper.toDto(existingUser));
    }

    @Override
    public UserDto updateUser(Long id, UpdateUserDto updateUserDto){
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));

        if (Objects.nonNull(updateUserDto.getName())){
            existingUser.setName(updateUserDto.getName());
        }
        if (Objects.nonNull(updateUserDto.getEmail())){
            existingUser.setEmail(updateUserDto.getEmail());
        }
        if (Objects.nonNull(updateUserDto.getNumber())){
            existingUser.setNumber(updateUserDto.getNumber());
        }
        //todo: fix this - create an specific method for this
        if (Objects.nonNull(updateUserDto.getPassword())){
            existingUser.setPassword(updateUserDto.getPassword());
        }

        User updatedUser = this.userRepository.save(existingUser);

        return userMapper.toDto(updatedUser);
    }


    @Override
    public void deleteUser(Long id) {
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserException("User not found with ID: " + id));

        this.userRepository.delete(existingUser);
    }
}
