package com.example.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
	@PostMapping(value = "/create")
    public String createAccount() {
        return "hello world";
    }
}
