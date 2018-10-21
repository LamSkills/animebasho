package com.lamine.animebasho.services.interfaces;

import com.lamine.animebasho.dto.PartieDto;
import com.lamine.animebasho.entities.Partie;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(value = "Partie", description = "Service de gestion des parties de l'utilisateur", tags = { "Partie" })
@RequestMapping(value = "/api")
public interface PartieService {

    @ApiOperation(httpMethod = "GET", value = "Retourne la partie jouée par un utilisateur")
    @GetMapping(value = "/parties/{partieId}")
    Partie retournerPartie(@PathVariable(value = "partieId") Long partieId);

    @ApiOperation(httpMethod = "POST", value = "Enregistre une partie d'un utilisateur")
    @PostMapping(value = "/parties")
    void enregistrerPartie(@RequestBody PartieDto partieDto);

}
