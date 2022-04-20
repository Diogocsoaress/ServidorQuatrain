package com.quatrain.Quatrain.models.repositories;

import com.quatrain.Quatrain.models.User;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface UserRepository extends CrudRepository<User, Integer> {
    @Modifying @Transactional
    @Query(value="insert into users (user_name, user_email, user_password)"+
        " values(:#{#User.name}, :#{#User.email}, :#{#User.password})", nativeQuery=true)
    Integer createUser(@Param("User") User user);
}
