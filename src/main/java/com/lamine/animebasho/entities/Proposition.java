package com.lamine.animebasho.entities;

import javax.persistence.*;

@Entity
public class Proposition {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "label")
    private String label;

    @Column(name = "is_correct", nullable = false)
    private boolean isCorrect;

    @ManyToOne(cascade = CascadeType.ALL)
    private Question question;

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

    public boolean isCorrect() {
        return isCorrect;
    }

    public void setCorrect(boolean correct) {
        isCorrect = correct;
    }

    public Question getQuestion() {
        return question;
    }

    public void setQuestion(Question question) {
        this.question = question;
    }

    @Override
    public String toString() {
        return "Proposition{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
