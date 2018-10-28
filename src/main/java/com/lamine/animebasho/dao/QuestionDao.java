package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Question;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@Repository
public interface QuestionDao extends CrudRepository<Question, Long> {
    @Query("select q from Question q inner join q.propositions p  " +
           "where p.id in :pId group by q having count(q) > 1")
    Set<Question> findDuplicateAnswers(@Param("pId") List<Long> propositionIds);
}
