package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Quiz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Set;

@Repository
public interface QuizDao extends CrudRepository<Quiz, Long> {
    @Query("select q from Quiz q join fetch q.questions qu join fetch qu.propositions p")
    Set<Quiz> findQuizzes();
}
