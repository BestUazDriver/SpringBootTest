package ru.sabitov.springboottest.controllers;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import ru.sabitov.springboottest.models.ApplicationFeature;
import ru.sabitov.springboottest.models.FeatureEnum;
import ru.sabitov.springboottest.repository.TestRepository;
import ru.sabitov.springboottest.services.CarService;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

@Controller
@RequestMapping("/")
public class MainController {

    private final CarService carService;
    private final TestRepository testRepository;

    @Autowired
    public MainController(CarService carService, TestRepository testRepository) {
        this.carService = carService;
        this.testRepository = testRepository;
    }

    @GetMapping
    @Transactional
    public ModelAndView getMainPage() {
        ModelAndView model = new ModelAndView("main");
        FeatureEnum featureEnum = new FeatureEnum();
        featureEnum.setFeatures(testRepository.getById(9L));
        testRepository.saveFeatureEnum(featureEnum);
        List<FeatureEnum> multValues = Collections.singletonList(featureEnum);

//        testRepository.saveAppFeature(ApplicationFeature.builder().applicationId(6L).feature(testRepository.getById(9L)).multValue(multValues).build());
        model.addObject("cars", carService.getAll());
        return model;
    }
}
