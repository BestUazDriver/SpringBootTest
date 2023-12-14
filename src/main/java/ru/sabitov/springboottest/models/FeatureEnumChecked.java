package ru.sabitov.springboottest.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = FeatureEnumChecked.TABLE_NAME, indexes = @Index(name = "feature_enum_checked_feature_id_idx", columnList = "feature_id", unique = false))
public class FeatureEnumChecked implements Serializable {

    private static final long serialVersionUID = 1L;
    public static final String TABLE_NAME = "feature_enum_checked";

    @Id
    @Column(name = "application_id")
    private Long applicationId;

    @Id
    @Column(name = "feature_enum_id")
    private Long featureEnumId;

    @Column(name = "feature_id")
    private Long featureId;
}
