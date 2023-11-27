package ru.sabitov.springboottest.dto;

import lombok.Data;
import ru.sabitov.springboottest.models.Car;

@Data
public class AddCarDto {
    private String name;
    private String model;
    private int horsePower;

    public static Car getCar(AddCarDto carDto) {
        return Car.builder().name(carDto.name).model(carDto.model).horsePower(carDto.horsePower).build();
    }
}
