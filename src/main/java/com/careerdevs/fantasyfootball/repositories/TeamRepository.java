package com.careerdevs.fantasyfootball.repositories;

import com.careerdevs.fantasyfootball.models.Team;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamRepository extends JpaRepository<Team, Long> {
}
