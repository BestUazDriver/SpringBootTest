package ru.sabitov.springboottest.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import ru.sabitov.springboottest.dto.SignUpDto;
import ru.sabitov.springboottest.models.User;
import ru.sabitov.springboottest.repository.UserRepositoryImpl;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserRestController {

    private final UserRepositoryImpl userService;

    @Autowired
    public UserRestController(UserRepositoryImpl userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @PostMapping(value = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody SignUpDto userDto) {
        User user = SignUpDto.getUser(userDto);
        userService.save(user);
        return ResponseEntity.ok(userService.getUserById(user.getId()));
    }
}
