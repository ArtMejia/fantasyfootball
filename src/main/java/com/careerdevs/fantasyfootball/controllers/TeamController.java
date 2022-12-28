package com.careerdevs.fantasyfootball.controllers;

import com.careerdevs.fantasyfootball.models.Team;
import com.careerdevs.fantasyfootball.repositories.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/api/teams")
public class TeamController {

    @Autowired TeamRepository teamRepository;

    @PostMapping
    public ResponseEntity<?> createATeam(@RequestBody Team newTeamData) {
        try {
            Team newTeam = teamRepository.save(newTeamData);
            return new ResponseEntity<>(newTeam, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping
    public ResponseEntity<?> getAllTeams() {
        List<Team> allTeams = teamRepository.findAll();
        return new ResponseEntity<>(allTeams, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getTeamById(@PathVariable Long id) {
        Team requestedTeam = teamRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with ID: " + id + " is not found"));
        return new ResponseEntity<>(requestedTeam, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTeamById(@PathVariable Long id) {
        Team requestedTeam = teamRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with ID: " + id +" is not found"));
        teamRepository.deleteById(id);
        return new ResponseEntity<>("Team with ID " + id + ", " + requestedTeam + ", has been deleted.", HttpStatus.OK);
    }

    @PostMapping("/{id}")
    public ResponseEntity<?> updateTeamById (@PathVariable Long id, @RequestBody Team updatedTeamData) {
        Team updatedTeam = teamRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND, "Team with ID: " + id +" is not found"));
        if (updatedTeamData.getTeamName() !=null && !updatedTeamData.getTeamName().equals("")) {
            updatedTeam.setTeamName(updatedTeam.getTeamName());
        }
        return new ResponseEntity<>(updatedTeam, HttpStatus.OK);
    }

    //    @DeleteMapping("/allTeams")
//    public ResponseEntity<?> deleteAllTeams() {
//        long count = teamRepository.count();
//        teamRepository.deleteAll();
//        return new ResponseEntity<>("Deleted Teams: " + count, HttpStatus.OK);
//    }

}
