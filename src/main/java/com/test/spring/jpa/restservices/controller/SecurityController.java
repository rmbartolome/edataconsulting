package com.test.spring.jpa.restservices.controller;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.test.spring.jpa.restservices.services.SecurityServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
@CrossOrigin
public class SecurityController {

    @Autowired
    private SecurityServices securityServices;

    @PostMapping
    public ResponseEntity registration(@RequestBody String requestJson) {
        JsonObject jsonObject = new JsonParser().parse(requestJson).getAsJsonObject();
        return new ResponseEntity<>(securityServices.authLogin(jsonObject.get("username").getAsString(), jsonObject.get("password").getAsString()), new HttpHeaders(), HttpStatus.OK);
    }
}
