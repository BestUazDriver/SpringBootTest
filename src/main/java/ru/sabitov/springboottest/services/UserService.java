package ru.sabitov.springboottest.services;

import ru.sabitov.springboottest.models.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    User getUserById(Long id);
}
