package com.interview.project.gamemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.project.gamemanagement.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
