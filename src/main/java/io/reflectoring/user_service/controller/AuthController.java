package io.reflectoring.user_service.controller;

import io.reflectoring.user_service.model.User;
import io.reflectoring.user_service.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final UserService userService;
    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    ResponseEntity<User> register(@RequestBody User user) {
        User registeredUser = userService.register(user);
        return ResponseEntity.ok(registeredUser);
    }
    @PostMapping("/login")
    ResponseEntity<String> login(@RequestParam String username,  @RequestParam String password) {
        Optional<User> authenticateUser = Optional.ofNullable(userService.authenticateUser(username, password));
        if (authenticateUser.isPresent()) {
            return ResponseEntity.ok("Login successful!");
        }
        return ResponseEntity.ok( "User not found!");
    }

}
