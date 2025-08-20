package com.flipfit.bean;

public class Notification {
    private String notificationId;
    private String userId;
    private String message;

    public Notification(String notificationId, String userId, String message) {
        this.notificationId = notificationId;
        this.userId = userId;
        this.message = message;
    }

    @Override
    public String toString() {
        return "Notification[" + notificationId + "] for " + userId + ": " + message;
    }
}
