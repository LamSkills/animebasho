package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Quiz;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {
    Set<Quiz> findAll();
}
