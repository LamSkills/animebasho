package com.lamine.animebasho.handler;

import com.lamine.animebasho.dao.PartieDao;
import com.lamine.animebasho.dto.PartieDto;
import com.lamine.animebasho.entities.Partie;
import com.lamine.animebasho.exceptions.PartieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Component
public class PartieHandler {

    @Autowired
    private PartieDao partieDao;

    public Partie retournerPartie(Long partieId) {
        return partieDao
                .findById(partieId)
                .orElseThrow(() -> new PartieNotFoundException("La partie "+ partieId + " n'existe pas !"));
    }

    public ResponseEntity enregistrerPartie(PartieDto partieDto) {
        Partie partie = buildPartie(partieDto);

        Long partieId = partieDao.save(partie).getId();
        URI location = buildUrlResource(partieId);
        return ResponseEntity.created(location).build();
    }

    private Partie buildPartie(PartieDto partieDto) {
        return null;
    }

    private URI buildUrlResource(Long partieId) {
        return ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{partieId}")
                    .buildAndExpand(partieId)
                    .toUri();
    }
}
