package com.lamine.animebasho.handler;

import com.lamine.animebasho.dao.PartieDao;
import com.lamine.animebasho.entities.Partie;
import com.lamine.animebasho.exceptions.PartieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PartieHandler {

    @Autowired
    private PartieDao partieDao;

    public Partie retournerPartie(Long partieId) {
        return partieDao
                .findById(partieId)
                .orElseThrow(() -> new PartieNotFoundException("La partie "+ partieId + " n'existe pas !"));
    }
}
