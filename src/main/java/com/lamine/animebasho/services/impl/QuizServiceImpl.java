package com.lamine.animebasho.services.impl;

import com.lamine.animebasho.entities.Quiz;
import com.lamine.animebasho.handler.QuizHandler;
import com.lamine.animebasho.services.interfaces.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
public class QuizServiceImpl implements QuizService {

    @Autowired
    private QuizHandler quizHandler;

    public Set<Quiz> getQuizzes() {
        return quizHandler.retournerQuizzes();
    }

}
