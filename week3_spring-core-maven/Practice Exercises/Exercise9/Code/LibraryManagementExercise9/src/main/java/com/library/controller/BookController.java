package com.library.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookController {

    @GetMapping("/")
    public String home() {
        return "Welcome to the Library Management System!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Library!";
    }
}
