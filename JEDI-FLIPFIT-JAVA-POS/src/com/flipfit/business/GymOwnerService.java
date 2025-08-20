package com.flipfit.business;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Payment;
import java.util.List;
import java.util.Scanner;

public class GymOwnerService {

    private static final Scanner in = new Scanner(System.in);

    public void addCentre() {
        // Now just prints, no bean used
        System.out.println("Adding new gym centre... ");
    }

    public List<GymCentre> viewGymDetails() {
        System.out.println("Fetching details for all your gym centres...");
        // Dummy data for demonstration
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %n", "Gym ID", "Name", "Location");
        System.out.println("------------------------------------------------------------------");
        System.out.printf("%-15s %-20s %-20s %n", "G101", "Fit Hub", "Pune");
        System.out.printf("%-15s %-20s %-20s %n", "G102", "Powerhouse", "Mumbai");
        System.out.println("------------------------------------------------------------------");
        return null;
    }

    public List<Customer> viewCustomers() {
        System.out.println("Fetching customer list for your gym centres...");
        return null;
    }

    public List<Payment> viewPayments() {
        System.out.println("Fetching payment history...");
        return null;
    }

    public void editDetails() {
        // This method will now be handled by the nested menu in gymOwnerMenu
    }

    /**
     * This method handles the entire gym owner menu flow with nested loops.
     */
    public void displayGymOwnerMenu() {
        boolean exitOwnerMenu = false;
        while (!exitOwnerMenu) {
            System.out.println("\n*** Welcome, Gym Owner! ***");
            System.out.println("1. Add a new Gym Centre");
            System.out.println("2. View My Gym Details");
            System.out.println("3. View My Customer List");
            System.out.println("4. View Payments");
            System.out.println("5. Edit My Details");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");

            int choice = in.nextInt();
            in.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    // Nested loop for adding a new gym centre
                    boolean continueAdding = true;
                    while (continueAdding) {
                        System.out.println("\n--- Add a New Gym Centre ---");
                        System.out.print("Enter gym name: ");
                        String name = in.nextLine();
                        System.out.print("Enter gym city: ");
                        String city = in.nextLine();
                        System.out.print("Enter gym state: ");
                        String state = in.nextLine();
                        // Call method without passing a bean
                        addCentre();
                        System.out.println("Gym Centre with name " + name + " and location " + city + ", " + state + " added. Do you want to add another? (yes/no)");
                        String response = in.nextLine();
                        if (response.equalsIgnoreCase("no")) {
                            continueAdding = false;
                        }
                    }
                    break;
                case 2:
                    viewGymDetails();
                    break;
                case 3:
                    viewCustomers();
                    break;
                case 4:
                    viewPayments();
                    break;
                case 5:
                    // Nested menu for editing details
                    boolean continueEditing = true;
                    while (continueEditing) {
                        System.out.println("\n--- Edit My Details ---");
                        System.out.println("1. Change Name");
                        System.out.println("2. Change City");
                        System.out.println("3. Change State");
                        System.out.println("4. Back to main menu");
                        System.out.print("Enter your choice: ");
                        int editChoice = in.nextInt();
                        in.nextLine(); // Consume newline
                        switch (editChoice) {
                            case 1:
                                System.out.print("Enter new name: ");
                                String newName = in.nextLine();
                                System.out.println("Name changed to: " + newName);
                                break;
                            case 2:
                                System.out.print("Enter new city: ");
                                String newCity = in.nextLine();
                                System.out.println("City changed to: " + newCity);
                                break;
                            case 3:
                                System.out.print("Enter new state: ");
                                String newState = in.nextLine();
                                System.out.println("State changed to: " + newState);
                                break;
                            case 4:
                                continueEditing = false;
                                break;
                            default:
                                System.out.println("Invalid choice. Please try again.");
                        }
                    }
                    break;
                case 6:
                    exitOwnerMenu = true;
                    System.out.println("Exiting Gym Owner menu.");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
