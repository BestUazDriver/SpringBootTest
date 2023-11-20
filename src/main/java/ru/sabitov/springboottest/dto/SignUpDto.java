package ru.sabitov.springboottest.dto;


import ru.sabitov.springboottest.models.User;

public class SignUpDto {

    private String name;
    private String email;

    public User getUser(){
        User user = new User();
        user.setName(this.name);
        user.setEmail(this.email);
        return user;
    }
}
