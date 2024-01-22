package ru.sabitov.springboottest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.sabitov.springboottest.models.User;
import ru.sabitov.springboottest.services.UserService;

@Controller
@RequestMapping("/generate_data")
public class DataCreationController {

    @Autowired
    private UserService userService;

    @GetMapping
    public String showUserData(Model model){
        User user = userService.save(
                User.builder().
                        role(User.Role.SELLER).
                        email("email").
                        password("pass").
                        name("name").
                        build());
        model.addAttribute("user", user);
        return "user_info";
    }
}
