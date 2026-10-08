package com.vastudesign.backend.vastu;

public class VastuResult {

    private int score;
    private String status;
    private String message;

    public VastuResult() {
    }

    public VastuResult(int score, String status, String message) {
        this.score = score;
        this.status = status;
        this.message = message;
    }

    public int getScore() {
        return score;
    }

    public String getStatus() {
        return status;
    }

    public String getMessage() {
        return message;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}