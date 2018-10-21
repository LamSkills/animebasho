package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Partie;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PartieDao extends CrudRepository<Partie, Long> {
}
