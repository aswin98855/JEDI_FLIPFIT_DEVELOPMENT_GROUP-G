package com.flipfit.client;

import com.flipfit.bean.*;
import com.flipfit.business.CustomerService;
import com.flipfit.business.PaymentService;
import com.flipfit.io.FlipFitScanner;

public class CustomerClient {

    private static CustomerService customerService = new CustomerService();
    private static PaymentService paymentService = new PaymentService();

    public static void menu(Customer customer) {
        System.out.println("\nWelcome Customer: " + customer.getName());

        while (true) {
            System.out.println("\nCustomer Menu:");
            System.out.println("1. View Gyms");
            System.out.println("2. View Slots");
            System.out.println("3. Book Slot");
            System.out.println("4. Cancel Booking");
            System.out.println("5. View Bookings");
            System.out.println("6. Make Payment");
            System.out.println("7. Logout");

            int choice = FlipFitScanner.getInt("Enter choice: ");
            switch (choice) {
                case 1 -> customerService.viewGyms().forEach(System.out::println);
                case 2 -> customerService.viewSlots().forEach(System.out::println);
                case 3 -> {
                    String slotId = FlipFitScanner.getString("Enter Slot ID: ");
                    String gymId = FlipFitScanner.getString("Enter Gym ID: ");
                    Booking booking = customerService.bookSlot(customer.getUserId(), slotId, gymId);
                    System.out.println(booking != null ? "Booking successful: " + booking : "Booking failed!");
                }
                case 4 -> {
                    String bookingId = FlipFitScanner.getString("Enter Booking ID to cancel: ");
                    boolean success = customerService.cancelBooking(bookingId);
                    System.out.println(success ? "Cancelled successfully!" : "Invalid booking!");
                }
                case 5 -> customerService.viewBookings().forEach(System.out::println);
                case 6 -> {
                    String bookingId = FlipFitScanner.getString("Enter Booking ID for payment: ");
                    double amt = FlipFitScanner.getDouble("Enter amount: ");
                    Payment p = paymentService.makePayment(bookingId, amt);
                    System.out.println(p != null ? "Payment Done: " + p : "Payment failed!");
                }
                case 7 -> { return; }
                default -> System.out.println("Invalid choice!");
            }
        }
    }
}
