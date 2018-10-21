package com.lamine.animebasho.services.interfaces;

import com.lamine.animebasho.entities.Quiz;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Set;

@Api(value = "Quiz", description = "Service de gestion des quizzes", tags = { "Quiz" })
@RequestMapping(value = "/api")
public interface QuizService {

    /**
     * Méthode qui retourne la liste des quizzes présents en base,
     * avec les questions et propositions associées.
     *
     * @return
     */
    @ApiOperation(httpMethod = "GET", value = "Retourne la liste des quizzes")
    @GetMapping(value = "/quizzes")
    public Set<Quiz> getQuizzes();
}
