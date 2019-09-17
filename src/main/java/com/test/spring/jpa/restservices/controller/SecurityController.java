package com.test.spring.jpa.restservices.controller;

import com.test.spring.jpa.restservices.services.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class SecurityController {

    @Autowired
    private SecurityServices securityServices;

    @PostMapping("/auth")
    public ResponseEntity registration(@RequestParam("username") String username, @RequestParam("password") String password) {
        return new ResponseEntity<>(securityServices.authLogin(username, password), new HttpHeaders(), HttpStatus.OK);
    }
}
