package ru.sabitov.springboottest.services;

import ru.sabitov.springboottest.models.User;

import java.util.List;

public interface UserService {

    User getUserById(Long id);
    void save(User user);
    List<User> getAllUsers();
}
