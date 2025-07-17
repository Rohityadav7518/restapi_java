package com.sloth_x.restapi.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {

    @GetMapping("/")
    public String Auth() {
        return "Welcome To auth page no maven updated ";
    }
}
