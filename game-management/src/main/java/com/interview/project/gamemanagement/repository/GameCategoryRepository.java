package com.interview.project.gamemanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.interview.project.gamemanagement.model.GameCategory;

@Repository
public interface GameCategoryRepository extends JpaRepository<GameCategory, Long> {

}
