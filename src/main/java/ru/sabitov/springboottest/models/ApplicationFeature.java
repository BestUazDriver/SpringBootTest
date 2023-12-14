package ru.sabitov.springboottest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "application_feature")
public class ApplicationFeature {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "application_id")
    private Long application_id;

    @ManyToOne(targetEntity = Feature.class, fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @ManyToOne(targetEntity = FeatureEnum.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "enum_value")
    private FeatureEnum enumValue;
}
