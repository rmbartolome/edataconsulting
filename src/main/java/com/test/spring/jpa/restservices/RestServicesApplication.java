package com.test.spring.jpa.restservices;

import com.test.spring.jpa.restservices.model.Role;
import com.test.spring.jpa.restservices.model.User;
import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.ArrayList;

@SpringBootApplication
@EnableJpaAuditing
public class RestServicesApplication {

    @Autowired
    private UserServices userServices;

    public static void main(String[] args) {
        SpringApplication.run(RestServicesApplication.class, args);
    }


    @Bean
    CommandLineRunner runner() {
        return args -> {
            User user = new User("User 1", "123", new ArrayList<Role>() {
                {
                    add(new Role("admin"));
                    add(new Role("standard"));
                }
            });
            User user2 = new User("admin", "123", new ArrayList<Role>() {
                {
                    add(new Role("admin"));
                    add(new Role("standard"));
                }
            });
            User user3 = new User("test", "123", new ArrayList<Role>() {
                {
                    add(new Role("standard"));
                }
            });
            userServices.createOrUpdateUser(user);
            userServices.createOrUpdateUser(user2);
            userServices.createOrUpdateUser(user3);
        };
    }
}
