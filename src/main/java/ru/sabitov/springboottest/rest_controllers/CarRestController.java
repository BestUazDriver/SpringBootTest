package ru.sabitov.springboottest.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sabitov.springboottest.dto.AddCarDto;
import ru.sabitov.springboottest.models.Car;
import ru.sabitov.springboottest.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    private final CarService carService;

    @Autowired
    public CarRestController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping("/add")
    public ResponseEntity<Car> addCar(@RequestBody AddCarDto carDto) {
        return ResponseEntity.ok(carService.saveCar(AddCarDto.getCar(carDto)));
    }
}
