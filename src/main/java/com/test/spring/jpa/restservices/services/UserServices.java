package com.test.spring.jpa.restservices.services;

import com.test.spring.jpa.restservices.dto.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface UserServices extends CrudRepository<User, Long> {

    public User findByName(@Param("orderNumber") String username);
}
