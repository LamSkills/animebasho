package com.lamine.animebasho.services.impl;

import com.lamine.animebasho.dto.PartieDto;
import com.lamine.animebasho.entities.Partie;
import com.lamine.animebasho.handler.PartieHandler;
import com.lamine.animebasho.services.interfaces.PartieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PartieServiceImpl implements PartieService {

    @Autowired
    private PartieHandler partieHandler;

    @Override
    public Partie retournerPartie(@PathVariable(value = "partieId") Long partieId) {
        return partieHandler.retournerPartie(partieId);
    }

    @Override
    public void enregistrerPartie(PartieDto partieDto) {

    }
}
