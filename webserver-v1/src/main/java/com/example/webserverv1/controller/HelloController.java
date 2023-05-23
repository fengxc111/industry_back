package com.example.webserverv1.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/hello")
    public String hello(String name){


        return "hello " + (name == null ? " ": name);
    }


}
