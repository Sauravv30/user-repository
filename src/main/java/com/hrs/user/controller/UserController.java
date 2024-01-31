package com.hrs.user.controller;

import com.hrs.user.api.UserApi;
import com.hrs.user.model.AuthResponse;
import com.hrs.user.model.Delete;
import com.hrs.user.model.CustomResponse;
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
public class UserController implements UserApi {

    private UserService userService;

    /**
     * Delete user response entity.
     *
     * @param userId the user id
     * @return the response entity
     */
    @Override
    public ResponseEntity<Delete> deleteUser(Long userId) {
        userService.deleteUserById(userId);
        return new ResponseEntity<>(new Delete().id(userId).status("User deleted"), HttpStatus.NO_CONTENT);
    }

    /**
     * Gets user by id.
     *
     * @param userId the user id
     * @return the user by id
     */
    @Override
    public ResponseEntity<User> getUserById(Long userId) {
        return new ResponseEntity<>(userService.getUserById(userId), HttpStatus.OK);
    }

    /**
     * Login user response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @Override
    public ResponseEntity<AuthResponse> loginUser(User user) {

        return new ResponseEntity<>(userService.loginUser(user),HttpStatus.OK);
    }

    /**
     * Register user response entity.
     *
     * @param user the user
     * @return the response entity
     */
    @Override
    public ResponseEntity<CustomResponse> registerUser(User user) {
        return new ResponseEntity<>(userService.registerUser(user),HttpStatus.CREATED);
    }

    /**
     * Update user response entity.
     *
     * @param userId the user id
     * @param user   the user
     * @return the response entity
     */
    @Override
    public ResponseEntity<User> updateUser(Long userId, User user) {
        return new ResponseEntity<>(userService.updateUser(userId,user), HttpStatus.OK);
    }
}
