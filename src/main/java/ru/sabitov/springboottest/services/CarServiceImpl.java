package ru.sabitov.springboottest.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.sabitov.springboottest.models.Car;
import ru.sabitov.springboottest.repository.CarRepository;

import java.util.List;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAll() {
        return carRepository.findAll();
    }
}
