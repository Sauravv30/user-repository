package com.hrs.user.repository;


import com.hrs.user.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * The interface User repository.
 */
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    /**
     * Exists by username boolean.
     *
     * @param username the username
     * @return the boolean
     */
    boolean existsByUsername(String username);

    /**
     * Find by username and password optional.
     *
     * @param username the username
     * @param password the password
     * @return the optional
     */
    Optional<UserEntity> findByUsernameAndPassword(String username, String password);
}
