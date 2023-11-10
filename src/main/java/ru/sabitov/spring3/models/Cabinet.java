package ru.sabitov.spring3.models;

import lombok.Data;

import jakarta.persistence.*;
import java.util.Calendar;
import java.util.Map;

@Data
@Entity
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int number;

    private String office;

    @Transient
    private Map<Calendar, Boolean> schedule;

}
