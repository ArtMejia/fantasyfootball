package com.careerdevs.fantasyfootball.controllers;

import com.careerdevs.fantasyfootball.models.User;
import com.careerdevs.fantasyfootball.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createAUser(@RequestBody User newUserData) {
        User newUser = userRepository.save(newUserData);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }

    @DeleteMapping("/allUsers")
    public ResponseEntity<?> deleteAllUsers() {
        long count = userRepository.count();
        userRepository.deleteAll();
        return new ResponseEntity<>("Deleted Users: " + count, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        Optional<User> requestedUser = userRepository.findById(id);
        if (requestedUser.isEmpty()) {
            return new ResponseEntity<>("Invalid ID", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(requestedUser.get(), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable Long id) {
        User requestedUser = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID: " + id + " is not found"));
        userRepository.deleteById(id);
        return new ResponseEntity<>("User with ID: " + id + ", " + requestedUser.getFullName() + ", has been deleted.", HttpStatus.OK);
    }
}
