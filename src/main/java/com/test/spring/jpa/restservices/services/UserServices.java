package com.test.spring.jpa.restservices.services;

import com.test.spring.jpa.restservices.dto.User;
import org.springframework.data.repository.CrudRepository;

public interface UserServices extends CrudRepository<User, Long> {

}
