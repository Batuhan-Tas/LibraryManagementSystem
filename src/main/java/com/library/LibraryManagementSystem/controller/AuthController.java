package com.library.LibraryManagementSystem.controller;

import com.library.LibraryManagementSystem.dto.RegistrationUser;
import com.library.LibraryManagementSystem.model.User;
import com.library.LibraryManagementSystem.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    public User register(@RequestBody RegistrationUser user){
        return authenticationService.register(user.getUsername(), user.getPassword());
    }
}
