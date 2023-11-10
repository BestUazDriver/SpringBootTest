package ru.sabitov.spring3.models;


import lombok.*;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString(exclude = {"ills", "ingredients"})
@EqualsAndHashCode(exclude = {"ills", "ingredients"})
public class Cure {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "cure_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ingredient_id", referencedColumnName = "id"))
    private List<Ingredient> ingredients;

    @ManyToMany
    @JoinTable(joinColumns = @JoinColumn(name = "cure_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "ill_id", referencedColumnName = "id"))
    private List<Ill> ills;

}



