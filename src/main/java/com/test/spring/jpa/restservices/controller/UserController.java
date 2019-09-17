package com.test.spring.jpa.restservices.controller;

import com.test.spring.jpa.restservices.model.User;
import com.test.spring.jpa.restservices.services.SecurityServices;
import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private SecurityServices securityServices;

    @GetMapping("/all")
    public ResponseEntity getUsers() {
        return new ResponseEntity<>(userServices.getAllUsers(), new HttpHeaders(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUser(@PathVariable Long id) {
        return new ResponseEntity<>(userServices.getUserById(id), new HttpHeaders(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userServices.createOrUpdateUser(user),new HttpHeaders(),  HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity updateUser(@Valid @RequestBody User user) {
        return new ResponseEntity<>(userServices.createOrUpdateUser(user),new HttpHeaders(),  HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        return new ResponseEntity<>(userServices.deleteById(id),new HttpHeaders(), HttpStatus.OK);
    }
}
