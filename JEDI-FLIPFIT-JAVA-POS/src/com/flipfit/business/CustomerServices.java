package com.flipfit.business;

import com.flipfit.bean.Customer;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Booking;
import com.flipfit.bean.Slot;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Service class for all business logic related to Customers.
 * This class handles customer-specific operations based on the provided UML diagram.
 */
public class CustomerServices {

    // Simulating a database/repository layer for demonstration purposes.
    // In a real application, you would use a database and repository classes.
    private List<Customer> customerDatabase = new ArrayList<>();
    private List<GymCentre> gymDatabase = new ArrayList<>();
    private List<Booking> bookingDatabase = new ArrayList<>();

    /**
     * Registers a new customer in the system.
     * Corresponds to the 'Registration' use case.
     * @param customer The Customer object to be registered.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerCustomer(Customer customer) {
        // You would typically add validation here (e.g., check for existing email).
        if (customerDatabase.stream().anyMatch(c -> c.getEmail().equals(customer.getEmail()))) {
            System.out.println("Error: A customer with this email already exists.");
            return false;
        }
        customerDatabase.add(customer);
        System.out.println("Customer " + customer.getName() + " registered successfully.");
        return true;
    }

    /**
     * Allows a customer to search for gyms based on criteria.
     * Corresponds to the 'View Centers' use case.
     * @param query The search query (e.g., location, gym name).
     * @return A list of GymCentre objects that match the search query.
     */
    public List<GymCentre> searchGyms(String query) {
        List<GymCentre> results = new ArrayList<>();
        for (GymCentre gym : gymDatabase) {
            // Updated search logic to use the getCity() method from GymCentre
            if (gym.getName().toLowerCase().contains(query.toLowerCase()) ||
                    gym.getCity().toLowerCase().contains(query.toLowerCase())) {
                results.add(gym);
            }
        }
        return results;
    }

    /**
     * Books a slot at a specific gym.
     * This method assumes an `AuthenticationService` handles user authentication.
     * Corresponds to the 'Slot Booking' use case.
     * @param customer The authenticated customer.
     * @param gym The gym profile for the booking.
     * @param bookingDetails The details of the booking (e.g., date, time).
     * @return true if the booking is successful, false otherwise.
     */
    public boolean bookGymSlot(Customer customer, GymCentre gym, Booking bookingDetails) {
        // Updated to use customerId and gymId from the new Booking bean
        bookingDetails.setCustomerId(customer.getUserId());
        bookingDetails.setGymId(gym.getCentreId());
        bookingDatabase.add(bookingDetails);
        System.out.println("Booking for customer ID " + customer.getUserId() + " at gym " + gym.getName() + " successful.");
        return true;
    }

    /**
     * Allows a customer to view their booking history.
     * @param customer The authenticated customer.
     * @return A list of Booking objects for the customer.
     */
    public List<Booking> viewBookingHistory(Customer customer) {
        List<Booking> customerBookings = new ArrayList<>();
        for (Booking booking : bookingDatabase) {
            // Updated to use customerId for comparison
            if (booking.getCustomerId() == customer.getUserId()) {
                customerBookings.add(booking);
            }
        }
        return customerBookings;
    }

    /**
     * Cancels a specific booking for a customer.
     * Corresponds to the 'Cancel Booking' use case.
     * @param customer The authenticated customer.
     * @param bookingId The unique ID of the booking to be cancelled.
     * @return true if the cancellation is successful, false otherwise.
     */
    public boolean cancelBooking(Customer customer, int bookingId) {
        Iterator<Booking> iterator = bookingDatabase.iterator();
        while (iterator.hasNext()) {
            Booking booking = iterator.next();
            // Updated to use int comparison and getUserId()
            if (booking.getBookingId() == bookingId && booking.getCustomerId() == customer.getUserId()) {
                iterator.remove();
                System.out.println("Booking " + bookingId + " for customer " + customer.getName() + " has been cancelled.");
                return true;
            }
        }
        System.out.println("Error: Booking " + bookingId + " not found or customer is not authorized.");
        return false;
    }

    /**
     * Allows a customer to edit their profile information.
     * Corresponds to the 'Edit Profile' use case.
     * @param customer The authenticated customer.
     * @param updatedProfile The Customer object with updated information.
     * @return true if the profile update is successful, false otherwise.
     */
    public boolean editProfile(Customer customer, Customer updatedProfile) {
        for (int i = 0; i < customerDatabase.size(); i++) {
            Customer currentCustomer = customerDatabase.get(i);
            // Verify that the customer being updated is the same as the authenticated one.
            if (currentCustomer.getEmail().equals(customer.getEmail())) {
                customerDatabase.set(i, updatedProfile);
                System.out.println("Customer profile for " + updatedProfile.getName() + " has been updated.");
                return true;
            }
        }
        System.out.println("Error: Customer profile not found for update.");
        return false;
    }
}
