package com.hrs.user.mapper;

import com.hrs.user.entity.UserEntity;
import com.hrs.user.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The interface User mapper.
 */
@Mapper(componentModel = "spring")
public interface UserMapper {
    /**
     * Model to entity user entity.
     *
     * @param user the user
     * @return the user entity
     */
    UserEntity modelToEntity(User user);

    /**
     * Entity to model user.
     *
     * @param userEntity the user entity
     * @return the user
     */
    @Mapping(ignore = true, target = "password")
    User entityToModel(UserEntity userEntity);

}
