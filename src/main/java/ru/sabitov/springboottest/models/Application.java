package ru.sabitov.springboottest.models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


}
