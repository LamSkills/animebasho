package com.lamine.animebasho.services.interfaces;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Api(value = "Quiz", description = "Service de gestion des quizzes", tags = { "Quiz" })
@RequestMapping(value = "/api")
public interface QuizService {

    @ApiOperation(httpMethod = "GET", value = "Retourne la liste des quizzes")
    @GetMapping(value = "/quizzes")
    public String getQuizzes();
}
