package com.test.spring.jpa.restservices;

import com.test.spring.jpa.restservices.dto.Role;
import com.test.spring.jpa.restservices.dto.User;
import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.CrossOrigin;

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
                    add(new Role("sales"));
                }
            });
            User user3 = new User("roberto", "123", new ArrayList<Role>() {
                {
                    add(new Role("standard"));
                    add(new Role("consumer"));
                }
            });
            userServices.save(user);
            userServices.save(user2);
            userServices.save(user3);
        };
    }
}
