package com.flipfit.business;

import com.flipfit.bean.User;
import com.flipfit.bean.Customer;
import com.flipfit.bean.GymOwner;

public class AuthenticationServiceImpl implements AuthenticationService {

    public User loginUser(String email, String password) {
        // Hardcoded check for admin credentials
        if ("admin@flipfit.com".equals(email) && "admin123".equals(password)) {
            System.out.println("Admin login successful!");
            User adminUser = new User();
            adminUser.setEmail("admin@flipfit.com");
            adminUser.setPassword("admin123");
            adminUser.setUserName("Admin");
            return adminUser;
        }

        // Placeholder for user login logic.
        // In a real application, you would check a database here.
        System.out.println("Attempting to log in user with email: " + email);
        if (email.equals("admin@example.com") && password.equals("pass")) {
            User user = new User();
            user.setEmail("admin@example.com");
            user.setPassword("pass");
            user.setUserName("Example Admin");
            return user;
        }
        return null;
    }

    public void registerCustomer(String name, String email, String password, String phone) {
        // Placeholder for customer registration logic
        System.out.println("Registering new customer: " + name);
        // Save the new Customer object to a database or data store
        // Customer newCustomer = new Customer(email, password, name, phone);
    }

    public void registerGymOwner(String name, String email, String password, String phone, String aadhar, String gstNumber) {
        // Placeholder for gym owner registration logic
        System.out.println("Registering new gym owner: " + name);
        // Save the new GymOwner object to a database or data store
        // GymOwner newGymOwner = new GymOwner(email, password, name, aadhar, gstNumber);
    }
}
