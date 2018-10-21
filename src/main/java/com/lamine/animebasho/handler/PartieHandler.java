package com.lamine.animebasho.handler;

import com.lamine.animebasho.dao.*;
import com.lamine.animebasho.dto.PartieDto;
import com.lamine.animebasho.entities.*;
import com.lamine.animebasho.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashSet;
import java.util.Set;

@Component
public class PartieHandler {

    @Autowired
    private PartieDao partieDao;

    @Autowired
    private UtilisateurDao utilisateurDao;

    @Autowired
    private QuizDao quizDao;

    @Autowired
    private PropositionDao propositionDao;

    /**
     * Retourne la partie récupérée en base à partir de l'id fourni en entrée.
     *
     * @param partieId
     * @return
     */
    public Partie retournerPartie(Long partieId) {
        return partieDao
                .findPartieById(partieId);
    }

    /**
     * Enregistre la partie jouée par l'utilisateur et calcule son score réalisé.
     *
     * @param partieDto
     * @return
     */
    public ResponseEntity enregistrerPartie(PartieDto partieDto) {
        Partie partie = buildPartie(partieDto);
        Long partieId = partieDao.save(partie).getId();

        buildReponsesAndCalculateScore(partieDto, partie);
        partieDao.save(partie);

        URI location = buildUrlResource(partieId);
        return ResponseEntity.created(location).build();
    }

    private void buildReponsesAndCalculateScore(PartieDto partieDto, Partie partie) {
        Set<Proposition> propositionsCorrectes = new HashSet<>();
        Set<Proposition> propositions = new HashSet<>();

        partieDto.getReponses().forEach(propId -> {
            Proposition proposition = propositionDao
                    .findById(Long.valueOf(propId))
                    .orElseThrow(() -> new EntityNotFoundException(
                            "La proposition " + propId + " n'existe pas !")
                    );

            if (proposition.isCorrect()) {
                propositionsCorrectes.add(proposition);
            }
            propositions.add(proposition);
            Reponse reponse = new Reponse(partie, proposition);
        });

        int score = propositionsCorrectes.size() / propositions.size() * 100;

        partie.setScore(score + "%");
    }

    private Partie buildPartie(PartieDto partieDto) {
        Partie partie = new Partie();
        Utilisateur utilisateur = utilisateurDao
                .findById(Long.valueOf(partieDto.getUserId()))
                .orElseThrow(() -> new EntityNotFoundException(
                        "L'utilisateur " + partieDto.getUserId() + " n'existe pas !")
                );
        Quiz quiz = quizDao
                .findById(Long.valueOf(partieDto.getQuizId()))
                .orElseThrow(() -> new EntityNotFoundException(
                        "Le quiz " + partieDto.getQuizId() + " n'existe pas !")
                );

        partie.setUtilisateur(utilisateur);
        partie.setQuiz(quiz);

        return partie;
    }

    private URI buildUrlResource(Long partieId) {
        return ServletUriComponentsBuilder
                    .fromCurrentRequest()
                    .path("/{partieId}")
                    .buildAndExpand(partieId)
                    .toUri();
    }
}
