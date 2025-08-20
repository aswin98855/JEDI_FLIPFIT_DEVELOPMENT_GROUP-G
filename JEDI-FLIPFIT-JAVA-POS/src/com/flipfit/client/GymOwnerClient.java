package com.flipfit.client;

import com.flipfit.bean.*;
import com.flipfit.business.GymOwnerService;
import com.flipfit.io.FlipFitScanner;

public class GymOwnerClient {

    private static GymOwnerService ownerService = new GymOwnerService();

    public static void menu(GymOwner owner) {
        System.out.println("\nWelcome Owner: " + owner.getName());

        while (true) {
            System.out.println("\nGymOwner Menu:");
            System.out.println("1. Add Gym");
            System.out.println("2. Add Slot to Gym");
            System.out.println("3. View My Gyms");
            System.out.println("4. View All Bookings");
            System.out.println("5. Logout");

            int choice = FlipFitScanner.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> {
                    String name = FlipFitScanner.getString("Enter gym name: ");
                    String location = FlipFitScanner.getString("Enter location: ");
                    ownerService.addGym(owner.getUserId(), name, location);
                    System.out.println("Gym added successfully!");
                }
                case 2 -> {
                    String gymId = FlipFitScanner.getString("Enter Gym ID: ");
                    String time = FlipFitScanner.getString("Enter Slot Time: ");
                    ownerService.addSlot(gymId, time);
                    System.out.println("Slot added successfully!");
                }
                case 3 -> ownerService.viewMyGyms(owner.getUserId()).forEach(System.out::println);
                case 4 -> ownerService.viewAllBookings().forEach(System.out::println);
                case 5 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
