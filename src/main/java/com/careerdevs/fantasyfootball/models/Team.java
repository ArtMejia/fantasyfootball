package com.careerdevs.fantasyfootball.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;
    private short maxPlayers;
    private short maxStartingPlayers;
    private short maxBenchPlayers;
    private float pointsScored;


    private short wins;
    private short loses;
    private short totalPointsScored;
    private short totalPointsAgainst;

    public Team() {
    }

    public Team(Long id, String teamName) {
        this.id = id;
        this.teamName = teamName;
    }

    public Long getId() {
        return id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public short getMaxPlayers() {
        return maxPlayers;
    }

    public void setMaxPlayers(short maxPlayers) {
        this.maxPlayers = maxPlayers;
    }

    public short getMaxStartingPlayers() {
        return maxStartingPlayers;
    }

    public void setMaxStartingPlayers(short maxStartingPlayers) {
        this.maxStartingPlayers = maxStartingPlayers;
    }

    public short getMaxBenchPlayers() {
        return maxBenchPlayers;
    }

    public void setMaxBenchPlayers(short maxBenchPlayers) {
        this.maxBenchPlayers = maxBenchPlayers;
    }

    public float getPointsScored() {
        return pointsScored;
    }

    public void setPointsScored(float pointsScored) {
        this.pointsScored = pointsScored;
    }

    public short getWins() {
        return wins;
    }

    public void setWins(short wins) {
        this.wins = wins;
    }

    public short getLoses() {
        return loses;
    }

    public void setLoses(short loses) {
        this.loses = loses;
    }

    public short getTotalPointsScored() {
        return totalPointsScored;
    }

    public void setTotalPointsScored(short totalPointsScored) {
        this.totalPointsScored = totalPointsScored;
    }

    public short getTotalPointsAgainst() {
        return totalPointsAgainst;
    }

    public void setTotalPointsAgainst(short totalPointsAgainst) {
        this.totalPointsAgainst = totalPointsAgainst;
    }
}
