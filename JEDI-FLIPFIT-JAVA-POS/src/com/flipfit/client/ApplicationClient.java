package com.flipfit.client;

import com.flipfit.bean.*;
import com.flipfit.business.AuthenticationService;
import com.flipfit.dao.UserDAO;
import com.flipfit.io.FlipFitScanner;

public class ApplicationClient {

    private static AuthenticationService authService = new AuthenticationService();

    public static void main(String[] args) {
        com.flipfit.dao.BootstrapData.init();
        System.out.println("===== Welcome to FlipFit Application =====");

        while (true) {
            System.out.println("\nMain Menu:");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. Exit");
            int choice = FlipFitScanner.getInt("Enter choice: ");

            switch (choice) {
                case 1 -> login();
                case 2 -> register();
                case 3 -> {
                    System.out.println("Exiting... Thank you!");
                    System.exit(0);
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private static void login() {
        String email = FlipFitScanner.getString("Enter email: ");
        String password = FlipFitScanner.getString("Enter password: ");
        User user = authService.login(email, password);

        if (user == null) {
            System.out.println("Invalid credentials!");
            return;
        }

        switch (user.getRole()) {
            case "ADMIN" -> AdminClient.menu((Admin) user);
            case "CUSTOMER" -> CustomerClient.menu((Customer) user);
            case "OWNER" -> GymOwnerClient.menu((GymOwner) user);
            default -> System.out.println("Unknown role!");
        }
    }

    private static void register() {
        String name = FlipFitScanner.getString("Enter name: ");
        String email = FlipFitScanner.getString("Enter email: ");
        String password = FlipFitScanner.getString("Enter password: ");
        System.out.println("Choose Role: 1. Customer  2. GymOwner");
        int r = FlipFitScanner.getInt("Enter: ");

        User user;
        if (r == 1) {
            user = new Customer("C" + (UserDAO.getAllUsers().size() + 1), name, email, password);
        } else {
            user = new GymOwner("O" + (UserDAO.getAllUsers().size() + 1), name, email, password);
        }
        authService.register(user);
        System.out.println("Registration successful!");
    }
}
