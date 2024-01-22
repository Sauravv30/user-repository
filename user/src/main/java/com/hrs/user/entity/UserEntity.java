package com.hrs.user.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

/**
 * The type User entity.
 */
@Entity
@Getter
@Setter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user-sequence")
    @SequenceGenerator(name = "user-sequence", sequenceName = "user-sequence", allocationSize = 1)
    @Column(name = "id", nullable = false)
    private Long id;
    @NotNull
    private String username;
    @NotNull
    private String email;
    @NotNull
    private String mobile;
    @NotNull
    private String password;
    @NotNull
    private String role;


}
