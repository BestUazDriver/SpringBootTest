package ru.sabitov.springboottest.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.sabitov.springboottest.dto.AddCarDto;
import ru.sabitov.springboottest.models.Car;
import ru.sabitov.springboottest.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarService carService;
    @PutMapping
    public ResponseEntity<Car> addCar(AddCarDto carDto){
        Car car = AddCarDto.getCar(carDto);
        return ResponseEntity.ok(carService.saveCar(car));
    }
}
