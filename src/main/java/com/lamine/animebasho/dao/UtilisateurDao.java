package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Utilisateur;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UtilisateurDao extends CrudRepository<Utilisateur, Long> {
}