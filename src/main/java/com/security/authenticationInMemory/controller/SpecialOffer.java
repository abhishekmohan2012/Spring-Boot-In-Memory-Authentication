package com.security.authenticationInMemory.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SpecialOffer {

    @GetMapping("/specialOffer")
    public String getAdmin(){
        return "Hey This Is Offer Zone...";
    }

    @GetMapping("/specialOffer/offers")
    public String getAdminDashBoard(){
        return "Let me Get You some offer..";
    }

}
