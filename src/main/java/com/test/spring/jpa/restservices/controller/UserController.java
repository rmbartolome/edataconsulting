package com.test.spring.jpa.restservices.controller;

import com.test.spring.jpa.restservices.dto.User;
import com.test.spring.jpa.restservices.exceptions.ResourceNotFoundException;
import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserServices userServices;

    @GetMapping("/all")
    public Iterable<User> getUsers() {
        return userServices.findAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        return userServices.findById(id)
        .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }

    @PostMapping("/add")
    public ResponseEntity addUser(@Valid @RequestBody User user) {
        user = userServices.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @PutMapping("/add")
    public ResponseEntity updateUser(@Valid @RequestBody User user) {
        user = userServices.save(user);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteUser(@PathVariable Long id) {
        userServices.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
