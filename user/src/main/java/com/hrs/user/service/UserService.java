package com.hrs.user.service;

import com.hrs.user.entity.UserEntity;
import com.hrs.user.exception.CustomException;
import com.hrs.user.exception.NotFoundCustomException;
import com.hrs.user.mapper.UserMapper;
import com.hrs.user.model.AuthResponse;
import com.hrs.user.model.User;
import com.hrs.user.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * The type User service.
 */
@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;
    private UserMapper userMapper;
    private JwtService jwtService;

    /**
     * Register user auth response.
     *
     * @param user the user
     * @return the auth response
     */
    public AuthResponse registerUser(User user) {
        if (userRepository.existsByUsername(user.getUsername())) {
            throw new CustomException("Username already preserved, please choose another username");
        }
        UserEntity persistedEntity = userRepository.save(userMapper.modelToEntity(user));
        return createAuthResponse(persistedEntity);
    }

    /**
     * Login user auth response.
     *
     * @param user the user
     * @return the auth response
     */
    public AuthResponse loginUser(User user) {
        UserEntity persistedEntity = userRepository.findByUsernameAndPassword
                (user.getUsername(), user.getPassword()).orElseThrow(() -> new NotFoundCustomException("User not found"));
        return createAuthResponse(persistedEntity);
    }

    /**
     * Gets user by id.
     *
     * @param id the id
     * @return the user by id
     */
    public User getUserById(long id) {
        return userMapper.entityToModel(fetchUserById(id));
    }

    /**
     * Fetch user by id user entity.
     *
     * @param id the id
     * @return the user entity
     */
    public UserEntity fetchUserById(long id) {
        return userRepository.findById(id).orElseThrow(() -> new NotFoundCustomException("User not found with this id " + id));
    }

    /**
     * Delete user by id.
     *
     * @param id the id
     */
    public void deleteUserById(long id) {
        userRepository.deleteById(id);
    }

    /**
     * Update user user.
     *
     * @param id   the id
     * @param user the user
     * @return the user
     */
    public User updateUser(long id, User user) {
        UserEntity persistedEntity = fetchUserById(id);
        UserEntity newEntity = userMapper.modelToEntity(user);
        newEntity.setId(persistedEntity.getId());
        return userMapper.entityToModel(userRepository.save(newEntity));
    }

    private AuthResponse createAuthResponse(UserEntity userEntity) {
        Map<String, Object> claims = new HashMap<>();
        claims.put("username", userEntity.getUsername());
        claims.put("userId", userEntity.getId());
        claims.put("role",userEntity.getRole());
        String accessToken = jwtService.generate(claims, "ACCESS");
        String refreshToken = jwtService.generate(claims, "REFRESH");
        return new AuthResponse().accessToken(accessToken).refreshToken(refreshToken);
    }


}
