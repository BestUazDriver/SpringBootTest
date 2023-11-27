package ru.sabitov.springboottest.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sabitov.springboottest.dto.AddCarDto;
import ru.sabitov.springboottest.models.Car;
import ru.sabitov.springboottest.services.CarService;

@RestController
@RequestMapping("/cars")
public class CarRestController {

    @Autowired
    private CarService carService;

    @PutMapping
    public ResponseEntity<Car> addCar(@RequestBody AddCarDto carDto){
        Car car = AddCarDto.getCar(carDto);
        return ResponseEntity.ok(carService.saveCar(car));
    }
}
