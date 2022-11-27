package com.careerdevs.fantasyfootball.controllers;

import com.careerdevs.fantasyfootball.models.Player;
import com.careerdevs.fantasyfootball.repositories.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/api/player")
public class PlayerController {

    @Autowired PlayerRepository playerRepository;

    @PostMapping
    public ResponseEntity<?> createAPlayer(@RequestBody Player newPlayerData) {
        Player newPlayer = playerRepository.save(newPlayerData);
        return new ResponseEntity<>(newPlayer, HttpStatus.CREATED);
    }

}
