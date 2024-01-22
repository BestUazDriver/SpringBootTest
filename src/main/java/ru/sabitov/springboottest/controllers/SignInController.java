package ru.sabitov.springboottest.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/login")
public class SignInController {

    @GetMapping
    public String showLoginPage(){
        return "login";
    }
}
