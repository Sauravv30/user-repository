package com.hrs.user.controller;

import com.hrs.user.api.UserApi;
import com.hrs.user.model.AuthResponse;
import com.hrs.user.model.Delete;
import com.hrs.user.model.User;
import com.hrs.user.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type User controller.
 */
@RestController
@AllArgsConstructor
@Validated
@CrossOrigin("lb://HOTEL-GATEWAY")
public class UserController implements UserApi {

    private UserService userService;

    @Override
    public ResponseEntity<Delete> deleteUser(Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(new Delete().id(userId).status("User deleted"), HttpStatus.NO_CONTENT);
    }

    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthResponse> loginUser(User user) {

        return new ResponseEntity<>(userService.loginUser(user),HttpStatus.OK);
    }

    @Override
    public ResponseEntity<AuthResponse> registerUser(User user) {
        return new ResponseEntity<>(userService.registerUser(user),HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<User> updateUser(Long userId, User user) {
        return new ResponseEntity<>(userService.updateUser(userId,user), HttpStatus.OK);
    }
}
