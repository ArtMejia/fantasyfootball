package com.careerdevs.fantasyfootball.repositories;

import com.careerdevs.fantasyfootball.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PlayerRepository extends JpaRepository<Player, Long> {
    List<Player> findAllByLastName(String lastName);
}
