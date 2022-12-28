package com.careerdevs.fantasyfootball.controllers;

import com.careerdevs.fantasyfootball.models.Player;
import com.careerdevs.fantasyfootball.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/players")
public class PlayerController {

    @Autowired PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<?> createOnePlayer(@RequestBody Player newPlayerData) {
        try {
            Player newPlayer = playerRepository.save(newPlayerData);
            return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllPlayers() {
        List<Player> allPlayers = playerRepository.findAll();
        return new ResponseEntity<>(allPlayers, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerById(@PathVariable Long id) {
        Player requestedPlayer = playerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player with ID: " + id +" is not found"));
        return new ResponseEntity<>(requestedPlayer, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayerById(@PathVariable Long id) {
        Player requestedPlayer = playerRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Player with ID: " + id +" is not found"));
        playerRepository.deleteById(id);
        return new ResponseEntity<>("Player with ID " + id + ", " + requestedPlayer.getLastName() + ", has been deleted.", HttpStatus.OK);
    }


//    @DeleteMapping
//    public ResponseEntity<?> deleteAllPlayers() {
//        long count = playerRepository.count();
//        playerRepository.deleteAll();
//        return new ResponseEntity<>("Deleted Players: " + count, HttpStatus.OK);
//    }

}
