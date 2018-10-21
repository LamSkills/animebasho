package com.lamine.animebasho.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "label")
    private String label;

    @JsonBackReference
    @ManyToOne(cascade = CascadeType.ALL)
    private Quiz quiz;

    @JsonManagedReference
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

    public Set<Proposition> getPropositions() {
        return propositions;
    }

    public void setPropositions(Set<Proposition> propositions) {
        this.propositions = propositions;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question = (Question) o;
        return Objects.equals(id, question.id) &&
                Objects.equals(label, question.label);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label);
    }

    @Override
    public String toString() {
        return "Question{" +
                "id=" + id +
                ", label='" + label + '\'' +
                '}';
    }
}
