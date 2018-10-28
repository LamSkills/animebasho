package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Partie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PartieDao extends CrudRepository<Partie, Long> {
    @Query("select p from Partie p where p.id = :id")
    Optional<Partie> findPartieById(@Param("id") Long id);
}
