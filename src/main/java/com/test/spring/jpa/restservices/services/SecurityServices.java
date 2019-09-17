package com.test.spring.jpa.restservices.services;

import com.test.spring.jpa.restservices.model.Role;
import com.test.spring.jpa.restservices.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SecurityServices {

    @Autowired
    private UserServices userServices;

    public int authLogin(String username, String password) {
        User user = userServices.getUserByName(username);
        if(user!=null){
            if(isAdmin(user.getRoles())){
                return 1;
            }
            return 2;
        }
        return 0;
    }

    private boolean isAdmin(List<Role> roles){
        for (Role role: roles){
            if(role.getName().equalsIgnoreCase("admin")){
                return true;
            }
        }
        return false;
    }
}
