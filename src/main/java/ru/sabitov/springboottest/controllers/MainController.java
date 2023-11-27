package ru.sabitov.springboottest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sabitov.springboottest.services.CarService;

@Controller
@RequestMapping("/")
public class MainController {

    private final CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping
    public ModelAndView getMainPage() {
        ModelAndView model = new ModelAndView("main");
        model.addObject("cars", carService.getAll());
        return model;
    }
}
