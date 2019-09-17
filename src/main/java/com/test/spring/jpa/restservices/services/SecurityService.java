package com.test.spring.jpa.restservices.services;

public interface SecurityService {

    String findLoggedInUsername();

    void authLogin(String username, String password);
}
