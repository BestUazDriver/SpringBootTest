package ru.sabitov.springboottest.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.sabitov.springboottest.dto.SignUpDto;
import ru.sabitov.springboottest.models.User;
import ru.sabitov.springboottest.services.UserServiceImpl;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserRestController {

    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(SignUpDto userDto) {
        User user = userDto.getUser();
        userService.save(user);
        return ResponseEntity.ok(userService.getUserById(user.getId()));
    }
}
