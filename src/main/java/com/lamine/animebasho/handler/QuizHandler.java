package com.lamine.animebasho.handler;

import com.lamine.animebasho.dao.QuizDao;
import com.lamine.animebasho.entities.Quiz;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class QuizHandler {

    @Autowired
    private QuizDao quizDao;

    public Set<Quiz> retournerQuizzes() {
        return this.quizDao.findQuizzes();
    }
}
