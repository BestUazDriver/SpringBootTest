package ru.sabitov.spring3.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"cures", "accounts"})
@EqualsAndHashCode(exclude = {"cures", "accounts"})
@Entity
public class Ill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @ManyToMany(mappedBy = "ills")
    private List<Cure> cures;

    @JsonBackReference
    @ManyToMany(mappedBy = "illness")
    private List<Account> accounts;

}


