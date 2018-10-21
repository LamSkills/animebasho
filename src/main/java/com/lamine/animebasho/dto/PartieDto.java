package com.lamine.animebasho.dto;

import java.util.List;

public class PartieDto {

    private String userId;
    private String quizId;
    private List<String> reponses;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public List<String> getReponses() {
        return reponses;
    }

    public void setReponses(List<String> reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return "PartieDto{" +
                "userId='" + userId + '\'' +
                ", quizId='" + quizId + '\'' +
                ", reponses=" + reponses +
                '}';
    }
}
