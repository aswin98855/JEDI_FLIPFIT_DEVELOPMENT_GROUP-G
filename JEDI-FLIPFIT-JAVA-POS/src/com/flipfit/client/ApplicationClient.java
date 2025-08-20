package com.flipfit.client;

import com.flipfit.business.AdminService;
import com.flipfit.business.AuthenticationService;
import com.flipfit.business.CustomerService;
import com.flipfit.business.GymOwnerService;

import java.util.Scanner;

public class ApplicationClient {
    private final Scanner scanner = new Scanner(System.in);
    AuthenticationService authenticationService = new AuthenticationService();
    AdminService adminService = new AdminService();
    GymOwnerService gymOwnerService = new GymOwnerService();
    CustomerService customerService = new CustomerService();

    public void login() {

        System.out.println("--- Login ---");
        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.println("Enter Role: Customer/Owner/Admin");
        String role = scanner.nextLine();

        System.out.println("Login request received for user: " + username);

        if(role.equalsIgnoreCase("Customer")){
            customerService.displayCustomerMenu();
        }

        else if(role.equalsIgnoreCase("Owner")){
            gymOwnerService.displayGymOwnerMenu();
        }

        else if(role.equalsIgnoreCase("Admin")){
            adminService.displayAdminMenu();
        }

        else {
            System.out.println("Invalid Role");
        }
    }

    public void registerCustomer() {
        System.out.println("--- Customer Registration ---");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.println("Registration received for customer: " + name);
        authenticationService.registerCustomer(name, email, password, phone);
        System.out.println("Registration Successful");
    }

    public void registerOwner() {
        System.out.println("--- Gym Owner Registration ---");
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();

        System.out.print("Enter your email: ");
        String email = scanner.nextLine();

        System.out.print("Enter your password: ");
        String password = scanner.nextLine();

        System.out.print("Enter your phone number: ");
        String phone = scanner.nextLine();

        System.out.print("Enter your aadhaar number: ");
        String aadhaar = scanner.nextLine();

        System.out.print("Enter your PAN number: ");
        String pan = scanner.nextLine();

        System.out.print("Enter your GST number: ");
        String gst = scanner.nextLine();

        System.out.println("Registration received for Owner: " + name);
        authenticationService.registerGymOwner(name, email, password, phone, aadhaar, pan, gst);
        System.out.println("Registration Successful");
    }
}
