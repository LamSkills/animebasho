package com.lamine.animebasho.dao;

import com.lamine.animebasho.entities.Proposition;
import com.lamine.animebasho.entities.Question;
import com.lamine.animebasho.entities.Quiz;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashSet;
import java.util.Set;

@RunWith(SpringRunner.class)
@DataJpaTest
public class QuizDaoTest {

    @Autowired
    private TestEntityManager em;

    @Autowired
    private QuizDao quizDao;

    private Quiz quiz;

    @Before
    public void init() {

        // Given
        this.quiz = loadDataIntoQuiz();
    }

    @Test
    public void whenFindQuizzes_thenReturnQuizzes() {

        // When
        Set<Quiz> results = quizDao.findQuizzes();

        // Then
        for (Quiz result : results) {
            Assert.assertEquals(this.quiz.getLabel(), result.getLabel());
            Assert.assertEquals(this.quiz.getQuestions(), result.getQuestions());
        }

    }

    private Quiz loadDataIntoQuiz() {
        Quiz quiz = new Quiz();
        quiz.setId(null);
        quiz.setLabel("Quiz One Piece");

        Question question = new Question();
        question.setId(1L);
        question.setLabel("Prime de Luffy actuelle ?");
        question.setQuiz(quiz);

        Set<Proposition> propositions = createPropositions(question);
        question.setPropositions(propositions);

        Set<Question> questions = new HashSet<>();
        questions.add(question);

        quiz.setQuestions(questions);

        return quiz;
    }

    private Set<Proposition> createPropositions(Question question) {
        Proposition proposition1 = new Proposition();
        proposition1.setLabel("100 000 000");
        proposition1.setCorrect(false);
        proposition1.setQuestion(question);

        Proposition proposition2 = new Proposition();
        proposition2.setLabel("300 000 000");
        proposition2.setCorrect(false);
        proposition2.setQuestion(question);

        Proposition proposition3 = new Proposition();
        proposition3.setLabel("500 000 000");
        proposition3.setCorrect(true);
        proposition3.setQuestion(question);

        Proposition proposition4 = new Proposition();
        proposition4.setLabel("700 000 000");
        proposition4.setCorrect(false);
        proposition4.setQuestion(question);

        Set<Proposition> propositions = new HashSet<>();
        propositions.add(proposition1);
        propositions.add(proposition2);
        propositions.add(proposition3);
        propositions.add(proposition4);

        return propositions;
    }
}
