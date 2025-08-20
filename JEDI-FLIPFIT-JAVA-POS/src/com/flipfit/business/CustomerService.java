package com.flipfit.business;

import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Slot;
import java.util.List;

public class CustomerService {

    /**
     * Views the slots that have been booked by the customer.
     */
    public void viewBookedSlots() {
        // Business logic to retrieve and display the list of booked slots for the current customer.
        // This would involve querying a database or a data source.
        System.out.println("Fetching your booked slots...");
    }
    /**
     * Views all available gym centers.
     * @return A list of all available GymCentre objects.
     */
    public List<GymCentre> viewCenters() {
        // Business logic to retrieve and display a list of all gym centers.
        System.out.println("Fetching all available gym centers...");
        return null; // Placeholder for a real list
    }

    /**
     * Handles the payment process for a booking.
     * @param paymentType The type of payment (e.g., credit card, debit card).
     * @param paymentInfo The payment details.
     */
    public void makePayments(int paymentType, String paymentInfo) {
        // Business logic for processing a payment.
        // This could involve integrating with a payment gateway.
        System.out.println("Processing payment of type: " + paymentType + " with info: " + paymentInfo);
    }

    /**
     * Allows the customer to edit their personal details.
     */
    public void editDetails() {
        // Business logic to update the customer's profile details.
        // This would involve receiving input and updating the customer object in the database.
        System.out.println("Allowing customer to edit their details...");
    }

    public void displayCustomerMenu() {
        System.out.println("\n*** Welcome, Customer! ***");
        System.out.println("1. View Booked Slots");
        System.out.println("2. View Available Gyms");
        System.out.println("3. Make a Payment");
        System.out.println("4. Edit My Details");
        System.out.println("5. Exit");
    }
}