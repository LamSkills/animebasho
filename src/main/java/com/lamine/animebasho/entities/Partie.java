package com.lamine.animebasho.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Partie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "quiz_id")
    private Quiz quiz;

    @ManyToOne
    @JoinColumn(name = "utilisateur_id")
    private Utilisateur utilisateur;

    @JsonManagedReference
    @OneToMany(mappedBy = "partie", cascade = CascadeType.ALL)
    private Set<Reponse> reponses;

    @Column(name = "score")
    private String score;

    public Partie() {
        if (reponses == null) {
            this.reponses = new HashSet<>();
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Quiz getQuiz() {
        return quiz;
    }

    public void setQuiz(Quiz quiz) {
        this.quiz = quiz;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Set<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(Set<Reponse> reponses) {
        this.reponses = reponses;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Partie{" +
                "id=" + id +
                ", quiz=" + quiz +
                ", utilisateur=" + utilisateur +
                ", reponses=" + reponses +
                ", score='" + score + '\'' +
                '}';
    }
}
