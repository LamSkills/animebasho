package com.lamine.animebasho.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "reponse")
public class Reponse {

    @JsonProperty("reponse")
    @EmbeddedId
    private ReponseId id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "fk_partie_id", insertable = false, updatable = false)
    private Partie partie;

    @ManyToOne
    @JoinColumn(name = "fk_proposition_id", insertable = false, updatable = false)
    private Proposition proposition;

    public Reponse() {
    }

    /**
     * Constructeur de la réponse de l'utilisateur à une partie.
     * L'association allant de Proposition vers Reponse a été
     * omise volontairement afin d'éviter la dépendance circulaire.
     *
     * @param partie
     * @param proposition
     */
    public Reponse(Partie partie, Proposition proposition) {
        this.id = new ReponseId(partie.getId(), proposition.getId());
        this.partie = partie;
        this.proposition = proposition;

        partie.getReponses().add(this);
    }

    @Override
    public String toString() {
        return "Reponse{" +
                "partieId=" + id.getPartieId() +
                "propositionId=" + id.getPropositionId() +
                '}';
    }

    @Embeddable
    public static class ReponseId implements Serializable {

        @Column(name = "fk_partie_id")
        protected Long partieId;

        @Column(name = "fk_proposition_id")
        protected Long propositionId;

        public ReponseId() {
        }

        public ReponseId(Long partieId, Long propositionId) {
            this.partieId = partieId;
            this.propositionId = propositionId;
        }

        public Long getPartieId() {
            return partieId;
        }

        public void setPartieId(Long partieId) {
            this.partieId = partieId;
        }

        public Long getPropositionId() {
            return propositionId;
        }

        public void setPropositionId(Long propositionId) {
            this.propositionId = propositionId;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ReponseId reponseId = (ReponseId) o;
            return Objects.equals(partieId, reponseId.partieId) &&
                    Objects.equals(propositionId, reponseId.propositionId);
        }

        @Override
        public int hashCode() {
            return Objects.hash(partieId, propositionId);
        }

        @Override
        public String toString() {
            return "ReponseId{" +
                    "partieId=" + partieId +
                    ", propositionId=" + propositionId +
                    '}';
        }
    }
}
