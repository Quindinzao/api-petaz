package com.quindinzao.petaz.controller;

import com.quindinzao.petaz.dto.AuthRequest;
import com.quindinzao.petaz.model.User;
import com.quindinzao.petaz.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserRepository userRepository;

    @PostMapping("/register")
    public ResponseEntity<String> createUser(@RequestBody User user) {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.badRequest().body("This email already exists!");
        } else if (Objects.equals(user.getName(), "") || Objects.equals(user.getEmail(), "") || Objects.equals(user.getPassword(), "")) {
            return ResponseEntity.badRequest().body("Invalid name, email or password!");
        } else if (user.getDocument().length() != 11 || user.getDocument().length() != 14) {
            return ResponseEntity.badRequest().body("Your document must be 11 or 14 characters long!");
        }
        userRepository.save(user);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PostMapping("/auth")
    public ResponseEntity<String> authUser(@RequestBody User user) {
        Optional<User> optionalUser = userRepository.findByEmail(user.getEmail());

        if (optionalUser.isPresent() && optionalUser.get().getPassword().equals(user.getPassword())) {
            User authenticatedUser = optionalUser.get();
            String responseJson = String.format(
                    "{\"id\": \"%s\", \"name\": \"%s\", \"document\": \"%s\"}",
                    authenticatedUser.getId(),
                    authenticatedUser.getName(),
                    authenticatedUser.getDocument()
            );
            return ResponseEntity.ok(responseJson);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("{\"error\": \"Invalid email or password\"}");
        }
    }

    @GetMapping("/all-users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        return user.map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
