package com.careerdevs.fantasyfootball.controllers;

import com.careerdevs.fantasyfootball.models.User;
import com.careerdevs.fantasyfootball.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired UserRepository userRepository;

    @PostMapping
    public ResponseEntity<?> createAUser(@RequestBody User newUserData) {
        try {
            User newUser = userRepository.save(newUserData);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllUsers() {
        List<User> allUsers = userRepository.findAll();
        return new ResponseEntity<>(allUsers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getUserById(@PathVariable Long id) {
        User requestedUser = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID: " + id + " is not found"));
        return new ResponseEntity<>(requestedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById (@PathVariable Long id) {
        User requestedUser = userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "User with ID: " + id + " is not found"));
        userRepository.deleteById(id);
        return new ResponseEntity<>("User with ID: " + id + ", " + requestedUser.getFullName() + ", has been deleted.", HttpStatus.OK);
    }

    @GetMapping("/{username}")
    public ResponseEntity<?> getUserByUsername(@PathVariable String userName) {
        User requestedUser = userRepository.findUserByUsername(userName);
        return new ResponseEntity<>(requestedUser, HttpStatus.OK);
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<?> deleteUserByUsername(@PathVariable String userName) {
        User requestedUser = userRepository.findUserByUsername(userName);
        userRepository.deleteUserByUsername(userName);
        return new ResponseEntity<>(requestedUser, HttpStatus.OK);
    }

//    @DeleteMapping("/allUsers")
//    public ResponseEntity<?> deleteAllUsers() {
//        long count = userRepository.count();
//        userRepository.deleteAll();
//        return new ResponseEntity<>("Deleted Users: " + count, HttpStatus.OK);
//    }
}
