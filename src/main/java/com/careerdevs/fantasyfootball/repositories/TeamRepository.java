package com.careerdevs.fantasyfootball.repositories;

import com.careerdevs.fantasyfootball.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {

    List<Team> findAllByTeamName(String teamName);
}
