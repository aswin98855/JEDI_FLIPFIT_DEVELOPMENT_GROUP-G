package com.flipfit.dao;

import com.flipfit.bean.Notification;
import java.util.*;

public class NotificationDAO {
    private static List<Notification> notifications = new ArrayList<>();

    public static void addNotification(Notification notification) {
        notifications.add(notification);
    }

    public static List<Notification> getAllNotifications() {
        return notifications;
    }
}
