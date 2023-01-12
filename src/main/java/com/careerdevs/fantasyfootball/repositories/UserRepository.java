package com.careerdevs.fantasyfootball.repositories;

import com.careerdevs.fantasyfootball.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findUserByUsername (String userName);
}
