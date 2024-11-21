package com.phoenix.pi.sales_platform.controller;

import com.phoenix.pi.sales_platform.dto.UpdateUserDto;
import com.phoenix.pi.sales_platform.dto.UserDto;
import com.phoenix.pi.sales_platform.dto.UserDtoRequest;
import com.phoenix.pi.sales_platform.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.validation.Valid;
import org.apache.commons.lang3.ObjectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    @Operation(summary = "Get all users", description = "Retrieve a list of all users")
    public ResponseEntity<List<UserDto>> getAllUsersList() {
        List<UserDto> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get an user by ID", description = "Retrieve an user by its ID")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        Optional<UserDto> userResponse = userService.getUserById(id);

        return userResponse.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(summary = "Create a new user", description = "Create a new user")
    public ResponseEntity<UserDto> createUser(@RequestBody @Valid UserDtoRequest userDto) {
        UserDto createdUser = userService.createUser(userDto);

        if (ObjectUtils.isEmpty(createdUser)) {
            return ResponseEntity.badRequest().build();
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing user"
            , description = "Update user details by providing the user ID and updated information")
    public ResponseEntity<UserDto> updateProductById(@PathVariable Long id
            , @RequestBody UpdateUserDto updateUserDto) {
        UserDto updatedUser = userService.updateUser(id, updateUserDto);

        if (updateUserDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete an user", description = "Delete an existing user by its ID")
    public ResponseEntity<Void> deleteUserById(@PathVariable Long id) {
        this.userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }
}
