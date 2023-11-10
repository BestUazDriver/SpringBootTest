package ru.sabitov.spring3.models;

import lombok.*;

import jakarta.persistence.*;
import java.util.Calendar;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@ToString(exclude = {"patient", "doctor"})
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address;

    @Column(name = "date")
    private Calendar noteDate;

    private int office;

    @ManyToOne
    private Account patient;

    @ManyToOne
    private Account doctor;
}
