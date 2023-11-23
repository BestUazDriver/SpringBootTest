package ru.sabitov.springboottest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sabitov.springboottest.models.Car;

public interface CarRepository extends JpaRepository<Car, Long> {
}
