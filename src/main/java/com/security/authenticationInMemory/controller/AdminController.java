package com.security.authenticationInMemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AdminController {

    @GetMapping("/admin")
    public String getAdmin(){
        return "Hey Admin...";
    }

    @GetMapping("/admin/dashboard")
    public String getAdminDashBoard(){
        return "Hey Admin...You are in Dashboard";
    }
}
