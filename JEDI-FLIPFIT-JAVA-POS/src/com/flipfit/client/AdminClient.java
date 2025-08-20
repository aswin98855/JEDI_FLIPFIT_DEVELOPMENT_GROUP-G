package com.flipfit.client;

import com.flipfit.bean.Admin;
import com.flipfit.business.AdminService;
import com.flipfit.io.FlipFitScanner;

public class AdminClient {

    private static AdminService adminService = new AdminService();

    public static void menu(Admin admin) {
        System.out.println("\nWelcome Admin: " + admin.getName());

        while (true) {
            System.out.println("\nAdmin Menu:");
            System.out.println("1. View All Gyms");
            System.out.println("2. View All Users");
            System.out.println("3. View All Bookings");
            System.out.println("4. Logout");

            int choice = FlipFitScanner.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> adminService.viewAllCentres().forEach(System.out::println);
                case 2 -> adminService.viewAllUsers().forEach(System.out::println);
                case 3 -> adminService.viewAllBookings().forEach(System.out::println);
                case 4 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
