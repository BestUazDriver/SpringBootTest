package ru.sabitov.spring3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sabitov.spring3.models.Ill;

public interface IllRepository extends JpaRepository<Ill, Long> {
}
