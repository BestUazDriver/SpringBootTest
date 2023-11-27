package ru.sabitov.springboottest.repository;

import ru.sabitov.springboottest.models.User;

import java.util.List;

public interface UserRepository {

    User getUserById(Long id);

    void save(User user);

    List<User> getAllUsers();
}
