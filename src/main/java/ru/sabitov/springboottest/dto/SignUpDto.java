package ru.sabitov.springboottest.dto;


import lombok.Data;
import ru.sabitov.springboottest.models.User;

import static ru.sabitov.springboottest.models.User.Role;

@Data
public class SignUpDto {

    private String name;
    private String email;

    public static User getUser(SignUpDto signUpDto) {
        User user = new User();
        user.setName(signUpDto.name);
        user.setEmail(signUpDto.email);
        user.setRole(Role.USER);
        return user;
    }
}
