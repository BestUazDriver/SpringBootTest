package ru.sabitov.springboottest.models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "feature")
public class Feature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String type;

    @ManyToMany
            @JoinTable(name = "application_feature", joinColumns = @JoinColumn(name = "feature_id", referencedColumnName = "id"))
    private List<FeatureEnum> enumValues;

    @Column(name = "has_default")
    private Boolean hasDefault;

    @Column(name = "default_str_value")
    private String defaultString;

    @Column(name = "default_bool_value")
    private Boolean defaultBool;

    @Column(name = "default_num_value")
    private Float defaultNum;
}
