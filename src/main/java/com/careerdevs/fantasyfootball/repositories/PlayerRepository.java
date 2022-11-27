package com.careerdevs.fantasyfootball.repositories;

import com.careerdevs.fantasyfootball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlayerRepository extends JpaRepository<Player, Long> {
}
