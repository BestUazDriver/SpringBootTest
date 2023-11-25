package ru.sabitov.springboottest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sabitov.springboottest.services.CarService;
import ru.sabitov.springboottest.services.UserService;

@Controller
@RequestMapping("/")
public class MainController {

    @Autowired
    private UserService userService;

    @Autowired
    private CarService carService;

    @GetMapping
    public ModelAndView getMainPage(){
        ModelAndView model = new ModelAndView("main");
        model.addObject("cars", carService.getAll());
        return model;
    }
}
