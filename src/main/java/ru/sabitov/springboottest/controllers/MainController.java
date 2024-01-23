package ru.sabitov.springboottest.controllers;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sabitov.springboottest.models.User;
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
        System.err.println("authenticated: " + SecurityContextHolder.getContext().getAuthentication().getPrincipal().toString());
        model.addObject("cars", carService.getAll());
        return model;
    }
    @GetMapping("/test")
    public String showUserData(Model model, HttpServletResponse response){
        response.addCookie(new Cookie("JSESSIONID", "LOLkek"));
        String user = SecurityContextHolder.getContext().getAuthentication().getName();
        model.addAttribute("user", user);
        return "cur_user_info";
    }
}
