package com.flipfit.dao;

import com.flipfit.bean.Admin;
import com.flipfit.bean.User;
import java.util.*;

public class UserDAO {
    private static Map<String, User> users = new HashMap<>();

    public static void addUser(User user) {
        users.put(user.getUserId(), user);
    }

    public static User getUser(String userId) {
        return users.get(userId);
    }

    public static List<User> getAllUsers() {
        return new ArrayList<>(users.values());
    }

    public static User authenticate(String email, String password) {
        for (User user : users.values()) {
            if (user.getEmail().equals(email) && user.getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }
    static {
    // preload default admin in user store also
    addUser(new Admin("A1", "System Admin", "admin@flipfit.com", "admin123"));
}

}
