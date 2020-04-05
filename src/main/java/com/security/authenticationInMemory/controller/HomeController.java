package com.security.authenticationInMemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/home")
    public String getHome(){
        return "Welcome! You are logged-In SuccessFully!!!";
    }
}
