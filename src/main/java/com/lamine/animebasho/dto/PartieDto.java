package com.lamine.animebasho.dto;

import java.util.Arrays;

public class PartieDto {

    private String userId;
    private String quizId;
    private String[] reponses;

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

    public String[] getReponses() {
        return reponses;
    }

    public void setReponses(String[] reponses) {
        this.reponses = reponses;
    }

    @Override
    public String toString() {
        return "PartieDto{" +
                "userId='" + userId + '\'' +
                ", quizId='" + quizId + '\'' +
                ", reponses=" + Arrays.toString(reponses) +
                '}';
    }
}
