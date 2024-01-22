package ru.sabitov.springboottest.repository;

import ru.sabitov.springboottest.models.User;

import java.util.List;

public interface UserRepository {

    User getUserById(Long id);

    User save(User user);

    List<User> getAllUsers();

    User findByUsername(String username);
}
