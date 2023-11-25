package ru.sabitov.springboottest.dto;


import ru.sabitov.springboottest.models.User;

public class SignUpDto {

    private String name;
    private String email;

    public static User getUser(SignUpDto signUpDto){
        User user = new User();
        user.setName(signUpDto.name);
        user.setEmail(signUpDto.email);
        return user;
    }
}
