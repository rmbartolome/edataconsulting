package com.test.spring.jpa.restservices;

import com.test.spring.jpa.restservices.dao.UserRepository;
import com.test.spring.jpa.restservices.model.Role;
import com.test.spring.jpa.restservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Arrays;
import java.util.HashSet;

@SpringBootApplication
@EnableJpaAuditing
public class RestServicesApplication {

    @Autowired
    private UserRepository userServices;

    public static void main(String[] args) {
        SpringApplication.run(RestServicesApplication.class, args);
    }


    @Bean
    CommandLineRunner runner() {
        return args -> {
            addUsersTest();
        };
    }

    private void addUsersAdmin(){
        Role role = new Role();
        role.setName("admin");
        User userAdmin = new User();
        userAdmin.setName("admin");
        userAdmin.setPassword("123456");
        userAdmin.setRoles(new HashSet<>(Arrays.asList(role)));
        role.setUsers(new HashSet<>(Arrays.asList(userAdmin)));
        userServices.save(userAdmin);
    }

    private void addUsersTest(){
/*
        userServices.save(new User("User 1", "123", new HashSet<>() {
            {
                add(new Role("admin"));
                add(new Role("standard"));
            }
        }));
        userServices.save(new User("admin", "123", new ArrayList<Role>() {
            {
                add(new Role("admin"));
                add(new Role("standard"));
                add(new Role("sales"));
            }
        }));
        userServices.save(new User("roberto", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("marcos", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("carlos", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("juan", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("jose", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("maria", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("ana", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("elena", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));

        userServices.save(new User("juana", "123", new ArrayList<Role>() {
            {
                add(new Role("standard"));
                add(new Role("consumer"));
            }
        }));
        */
    }
}
