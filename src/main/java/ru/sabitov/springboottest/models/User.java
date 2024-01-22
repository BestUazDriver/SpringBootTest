package ru.sabitov.springboottest.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Column;
import jakarta.persistence.GenerationType;
import lombok.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Table
@Builder
public class User {

    public enum State {
        CONFIRMED, NOT_CONFIRMED, DELETED, BANNED
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private Role role;

    public enum Role {
        USER,
        ADMIN,
        SELLER
    }
}
