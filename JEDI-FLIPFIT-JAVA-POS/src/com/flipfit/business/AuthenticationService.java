package com.flipfit.business;

import com.flipfit.bean.User;
import com.flipfit.dao.UserDAO;

public class AuthenticationService {

    // Authenticate user by email + password
    public User login(String email, String password) {
        return UserDAO.authenticate(email, password);
    }

    // Register a new user
    public void register(User user) {
        UserDAO.addUser(user);
    }
}
