package com.test.spring.jpa.restservices.controller;

import com.test.spring.jpa.restservices.model.User;
import com.test.spring.jpa.restservices.services.SecurityService;
import com.test.spring.jpa.restservices.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
@CrossOrigin
public class AuthController {

    @Autowired
    private UserServices userServices;

    @Autowired
    private SecurityService securityService;


    @GetMapping("/login")
    public String login(Model model, String error, String logout) {
        if (error != null)
            model.addAttribute("error", "Your username and password is invalid.");

        if (logout != null)
            model.addAttribute("message", "You have been logged out successfully.");

        return "login";
    }

    @PostMapping("/registration")
    public String registration(@ModelAttribute("userForm") User userForm) {
        userServices.createOrUpdateUser(userForm);

        securityService.authLogin(userForm.getName(), userForm.getPassword());

        return "redirect:/welcome";
    }
}
