package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Partie;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieDao extends CrudRepository<Partie, Long> {
    @Query("select p from Partie p join fetch p.reponses rep where p.id = :id")
    Partie findPartieById(@Param("id") Long id);
}
