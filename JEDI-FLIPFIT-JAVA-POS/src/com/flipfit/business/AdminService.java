package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.GymOwner;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AdminService {

    /**
     * Approves a pending gym center request.
     * @param gymId The ID of the gym center to approve.
     */
    public void approveGymRequest(int gymId) {
        // Business logic to find the gym center and update its status to 'approved'.
        System.out.println("Gym with ID " + gymId + " approved successfully.");
    }

    /**
     * Approves a pending gym owner registration request.
     * @param email The email of the gym owner to approve.
     */
    public void approveGymOwnerRequest(String email) {
        // Business logic to find the gym owner and update their status to 'approved'.
        System.out.println("Gym owner with email " + email + " approved successfully.");
    }

    public void pendingGyms() {
        System.out.println("Fetching all pending gyms requests...");

        String[][] requests = {
                {"1", "name1", "gym1"},
                {"2", "name2", "gym2"},
                {"3", "name3", "gym3"},
                {"4", "name4", "gym4"},
                {"5", "name5", "gym5"}
        };

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < requests.length; i++) {
            String[] request = requests[i];
            System.out.println("\n--- Request " + (i + 1) + " ---");
            System.out.println("User ID: " + request[0]);
            System.out.println("Gym Owner: " + request[1]);
            System.out.println("Gym Name: " + request[2]);
            System.out.print("Enter 'A' to approve, 'R' to reject and anything else to ignore: ");

            String scannerInput = scanner.nextLine().toUpperCase();

            if ("A".equals(scannerInput)) {
                System.out.println("Request successfully approved! ");
            } else if ("R".equals(scannerInput)) {
                System.out.println("Request rejected. Please provide a reason:");
                String reason = scanner.nextLine();
                System.out.println("Reason: " + reason);
            } else {
                System.out.println("Invalid input. Request remains pending.");
            }
        }
    }

    public void viewAllGyms() {
        System.out.println("Fetching all registered gym centers...");

        List<String> facilitiesGym1 = List.of("Cardio", "Weights", "Showers");
        GymCentre gym1 = new GymCentre(
                1, 101, "Fitness Hub", List.of("slot1", "slot2","slot3"),50, true,
                "Bengaluru", "Karnataka", "600001", facilitiesGym1
        );

        List<String> facilitiesGym2 = List.of("Yoga", "Pool", "Sauna");
        GymCentre gym2 = new GymCentre(
                2, 102, "Zenith Fitness", List.of("slot1", "slot2","slot3"),75, true,
                "Bengaluru", "Karnataka", "560001", facilitiesGym2
        );

        // Add the dummy gyms to a list
        List<GymCentre> allGyms = new ArrayList<>();
        allGyms.add(gym1);
        allGyms.add(gym2);

        // Loop through the list and print details for each gym
        System.out.println("Displaying all registered gym centers:");
        for (GymCentre gym : allGyms) {
            System.out.println("------------------------------------");
            System.out.println("Centre ID: " + gym.getCentreId());
            System.out.println("Owner ID: " + gym.getOwnerId());
            System.out.println("Name: " + gym.getName());
            System.out.println("Capacity: " + gym.getCapacity());
            System.out.println("City: " + gym.getCity());
            System.out.println("State: " + gym.getState());
            System.out.println("Pincode: " + gym.getPincode());
            System.out.println("Slots: " + gym.getSlots());
            System.out.println("Facilities: " + gym.getFacilities());
            System.out.println("------------------------------------");
        }
    }

    public void viewAllGymOwners() {
        System.out.println("Fetching all registered gym owners...");

        GymOwner owner1 = new GymOwner(
                "OWNER", 1, "Ravi Sharma", "ravi.sharma@example.com", "secure123",
                9876543210L, "Bengaluru", 560001,
                "ABCDE1234F", "123456789012", "29ABCDE1234F1Z5"
        );

        // Dummy user 2
        GymOwner owner2 = new GymOwner(
                "OWNER", 2, "Priya Singh", "priya.singh@example.com", "mysecretpass",
                8765432109L, "Mumbai", 400001,
                "FGHIJ5678K", "987654321098", "27FGHIJ5678K1Z3"
        );

        // Add the dummy gym owners to a list
        List<GymOwner> allOwners = new ArrayList<>();
        allOwners.add(owner1);
        allOwners.add(owner2);

        // Loop through the list and print details for each gym owner
        System.out.println("Displaying all registered gym centers:");
        for (GymOwner owner : allOwners) {
            System.out.println("------------------------------------");
            System.out.println("User ID: " + owner.getUserId());
            System.out.println("Full Name: " + owner.getName());
            System.out.println("Email: " + owner.getEmail());
            System.out.println("Phone number: " + owner.getUserPhone());
            System.out.println("City: " + owner.getCity());
            System.out.println("Pincode: " + owner.getPinCode());
            System.out.println("PAN: " + owner.getPan());
            System.out.println("Aadhaar: " + owner.getAadhaar());
            System.out.println("GST: " + owner.getGst());
            System.out.println("------------------------------------");
        }
    }

    public void displayAdminMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n*** Welcome, Admin! ***");

        int op = sc.nextInt();
        System.out.println("1. View List of Registered Gyms");
        System.out.println("2. View List of Pending Gyms");
        System.out.println("3. View List of Registered Gym Owners");
        System.out.println("4. View List of Pending Gym Owners");
        System.out.println("5. View List of Registered Customers");
        System.out.println("6. View List of Payment Transactions");
        System.out.println("7. Delete User by id");
        System.out.println("8. Delete Gym by id");
        System.out.println("9. Exit");

        while(op!=9){
            System.out.println("1. View List of Registered Gyms");
            System.out.println("2. View List of Pending Gyms");
            System.out.println("3. View List of Registered Gym Owners");
            System.out.println("4. View List of Pending Gym Owners");
            System.out.println("5. View List of Registered Customers");
            System.out.println("6. View List of Payment Transactions");
            System.out.println("7. Delete User by id");
            System.out.println("8. Delete Gym by id");
            System.out.println("9. Exit");
            op = sc.nextInt();

            switch (op){
                case 1: viewAllGyms();
                    break;
                case 2:
                    break;
                case 3: viewAllGymOwners();
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
                case 9: break;
                default: System.out.println("Invalid option");
                    break;
            }

        }

    }
}