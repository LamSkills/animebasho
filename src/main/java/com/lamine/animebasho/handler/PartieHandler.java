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
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

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

        Set<Reponse> reponses = preparerReponses(partieDto, partie);

        partieDao.save(partie);

        URI location = buildUrlResource(partieId);
        return ResponseEntity.created(location).build();
    }

    private Set<Reponse> preparerReponses(PartieDto partieDto, Partie partie) {

        Set<Reponse> reponses = new HashSet<>();

        partieDto.getReponses().stream().forEach(propId -> {
            Proposition proposition = findPropositionById(propId);
            reponses.add(new Reponse(partie, proposition));
        });

        calculerScore(reponses, partie);

        return reponses;
    }

    private List<Long> formaterListeReponses(List<String> reponses) {
        return reponses
                .stream()
                .map(Long::parseLong)
                .collect(Collectors.toList());
    }

    private void calculerScore(Set<Reponse> reponses, Partie partie) {
        double bonnesReponses = reponses
                .stream()
                .filter(reponse -> reponse.getProposition().isCorrect())
                .count();

        String score = (bonnesReponses / (double) reponses.size()) * 100 + "%";

        partie.setScore(score);
    }

    private Proposition findPropositionById(String propId) {
        return propositionDao
                .findById(Long.valueOf(propId))
                .orElseThrow(() -> new EntityNotFoundException(
                        "La proposition " + propId + " n'existe pas !")
                );
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
