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
    @Column(name = "application_id")
    private Long applicationId;

    @Id
    @ManyToOne(targetEntity = Feature.class, fetch = FetchType.EAGER, cascade = { CascadeType.REMOVE })
    @JoinColumn(name = "feature_id")
    private Feature feature;

    @ManyToOne(targetEntity = FeatureEnum.class, fetch = FetchType.LAZY)
    @JoinColumn(name = "enum_value")
    private FeatureEnum enumValue;

    @ManyToMany(targetEntity = FeatureEnum.class)
    @JoinTable(name = "feature_enum_checked", joinColumns = {
            @JoinColumn(name = "application_id", referencedColumnName = "application_id"),
            @JoinColumn(name = "feature_id", referencedColumnName = "feature_id") }, inverseJoinColumns = {
            @JoinColumn(name = "feature_enum_id") })
    private List<FeatureEnum> multValue;
}
