package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Proposition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PropositionDao extends CrudRepository<Proposition, Long> {
}
