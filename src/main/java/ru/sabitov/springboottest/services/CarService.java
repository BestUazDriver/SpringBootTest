package ru.sabitov.springboottest.services;

import ru.sabitov.springboottest.models.Car;

import java.util.List;

public interface CarService {
    List<Car> getAll();

    Car saveCar(Car car);
}
