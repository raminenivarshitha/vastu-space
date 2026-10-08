package com.vastudesign.backend.vastu;

public class VastuIssue {

    private String item;
    private String severity;
    private String message;
    private String recommendation;

    public VastuIssue() {
    }

    public VastuIssue(
            String item,
            String severity,
            String message,
            String recommendation
    ) {
        this.item = item;
        this.severity = severity;
        this.message = message;
        this.recommendation = recommendation;
    }

    public String getItem() {
        return item;
    }

    public String getSeverity() {
        return severity;
    }

    public String getMessage() {
        return message;
    }

    public String getRecommendation() {
        return recommendation;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setRecommendation(String recommendation) {
        this.recommendation = recommendation;
    }
}