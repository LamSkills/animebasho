package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QuizDao extends JpaRepository<Quiz, Long> {
}
