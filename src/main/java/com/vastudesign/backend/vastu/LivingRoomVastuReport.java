package com.vastudesign.backend.vastu;

import java.util.List;

public class LivingRoomVastuReport {

    private int score;
    private String rating;
    private List<VastuIssue> issues;

    public LivingRoomVastuReport() {
    }

    public LivingRoomVastuReport(
            int score,
            String rating,
            List<VastuIssue> issues
    ) {
        this.score = score;
        this.rating = rating;
        this.issues = issues;
    }

    public int getScore() {
        return score;
    }

    public String getRating() {
        return rating;
    }

    public List<VastuIssue> getIssues() {
        return issues;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public void setIssues(List<VastuIssue> issues) {
        this.issues = issues;
    }
}