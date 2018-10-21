package com.lamine.animebasho.entities;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

    @OneToMany(mappedBy = "question", cascade = CascadeType.ALL)
    private Set<Proposition> propositions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(label, question.label) &&
                Objects.equals(quiz, question.quiz) &&
                Objects.equals(propositions, question.propositions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, quiz, propositions);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
