package ru.sabitov.springboottest.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "feature_enum")
public class FeatureEnum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(targetEntity = Feature.class)
            @JoinColumn(name = "feature_id")
    private Feature features;
}
