package ru.sabitov.springboottest.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "application")
public class Application {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToMany
    @JoinTable(name = "application_feature", joinColumns = @JoinColumn(name = "application_id", referencedColumnName = "id"))
    private List<Feature> features;
}
