package com.flipfit.business;

import com.flipfit.bean.GymOwner;
import com.flipfit.bean.GymCentre;
import com.flipfit.bean.Booking;
import com.flipfit.bean.Slot;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Service class for all business logic related to Gym Owners.
 * This class handles gym owner-specific operations as per the UML diagram.
 */
public class GymOwnerServices {

    // Simulating database/repository layer for demonstration purposes.
    // In a real application, you would use a database and repository classes.
    private List<GymOwner> ownerDatabase = new ArrayList<>();
    private List<GymCentre> gymDatabase = new ArrayList<>();
    private List<Booking> bookingDatabase = new ArrayList<>();

    /**
     * Registers a new gym owner.
     * Corresponds to the 'Owner Registration' use case.
     * @param owner The GymOwner object to be registered.
     * @return true if registration is successful, false otherwise.
     */
    public boolean registerOwner(GymOwner owner) {
        if (ownerDatabase.stream().anyMatch(o -> o.getEmail().equals(owner.getEmail()))) {
            System.out.println("Error: A gym owner with this email already exists.");
            return false;
        }
        ownerDatabase.add(owner);
        System.out.println("Gym Owner " + owner.getName() + " registered successfully.");
        return true;
    }

    /**
     * Allows a gym owner to register their gym.
     * This method assumes the owner is already authenticated.
     * Corresponds to the 'Gym Registration' use case.
     * @param owner The authenticated GymOwner.
     * @param gym The GymCentre to be registered.
     * @return true if gym registration is successful, false otherwise.
     */
    public boolean registerGym(GymOwner owner, GymCentre gym) {
        if (gymDatabase.stream().anyMatch(g -> g.getCentreId() == gym.getCentreId())) {
            System.out.println("Error: A gym with this ID already exists.");
            return false;
        }
        // Associate the gym with the owner by setting the owner ID.
        gym.setOwnerId(owner.getUserId());
        gymDatabase.add(gym);
        System.out.println("Gym " + gym.getName() + " registered by owner " + owner.getName() + ".");
        return true;
    }

    /**
     * Allows a gym owner to manage their gym's profile (e.g., edit details, add plans).
     * This assumes the owner is authenticated and owns the gym.
     * Corresponds to the 'Manage Gym Profile' use case.
     * @param owner The authenticated GymOwner.
     * @param gymToUpdate The GymCentre object with updated information.
     * @return true if the update is successful, false otherwise.
     */
    public boolean manageGymProfile(GymOwner owner, GymCentre gymToUpdate) {
        // Find the gym in the database and verify ownership.
        for (int i = 0; i < gymDatabase.size(); i++) {
            GymCentre currentGym = gymDatabase.get(i);
            if (currentGym.getCentreId() == gymToUpdate.getCentreId() && currentGym.getOwnerId() == owner.getUserId()) {
                // Update the gym profile with the new data.
                gymDatabase.set(i, gymToUpdate);
                System.out.println("Gym profile for " + gymToUpdate.getName() + " updated successfully.");
                return true;
            }
        }
        System.out.println("Error: Gym not found or owner is not authorized to manage this gym.");
        return false;
    }

    /**
     * Allows a gym owner to view booking details for their gym.
     * Corresponds to the 'View Booking Details' use case.
     * @param owner The authenticated GymOwner.
     * @return A list of Booking objects for the owner's gym(s).
     */
    public List<Booking> viewBookingDetails(GymOwner owner) {
        // First, get all the gym IDs owned by this owner.
        List<Integer> ownedGymIds = gymDatabase.stream()
                .filter(gym -> gym.getOwnerId() == owner.getUserId())
                .map(GymCentre::getCentreId)
                .collect(Collectors.toList());

        // Then, filter the bookings for those gym IDs.
        List<Booking> ownerBookings = bookingDatabase.stream()
                .filter(booking -> ownedGymIds.contains(booking.getGymId()))
                .collect(Collectors.toList());

        return ownerBookings;
    }

    // New methods to reflect the more detailed use case diagram.

    /**
     * Allows a gym owner to update the facilities offered at their gym.
     * Corresponds to the 'Update Facilities' use case.
     * @param owner The authenticated GymOwner.
     * @param gym The GymCentre object to update.
     * @param newFacilities A list of new facilities to be set.
     * @return true if facilities were updated successfully, false otherwise.
     */
    public boolean updateFacilities(GymOwner owner, GymCentre gym, List<String> newFacilities) {
        // Logic to verify ownership and update facilities.
        if (gym.getOwnerId() == owner.getUserId()) {
            gym.setFacilities(newFacilities);
            System.out.println("Facilities for gym " + gym.getName() + " updated successfully.");
            return true;
        }
        System.out.println("Error: Owner is not authorized to update facilities for this gym.");
        return false;
    }

    /**
     * Allows a gym owner to create or update available slots for their gym.
     * Corresponds to the 'Create/Update Slots' use case.
     * @param owner The authenticated GymOwner.
     * @param gym The GymCentre object to update.
     * @param slots A list of new or updated slot objects.
     * @return true if slots were updated successfully, false otherwise.
     */
    public boolean createUpdateSlots(GymOwner owner, GymCentre gym, List<Slot> slots) {
        // Corrected to use owner.getUserId() for consistency.
        if (gym.getOwnerId() == owner.getUserId()) {
            // This is a simple replacement. In a real-world app, you might merge them.
            gym.setSlots((ArrayList) slots);
            System.out.println("Slots for gym " + gym.getName() + " updated successfully.");
            return true;
        }
        System.out.println("Error: Owner is not authorized to update slots for this gym.");
        return false;
    }

    /**
     * Placeholder method for viewing performance reports.
     * This method would require a more complex implementation.
     * Corresponds to the 'View Performance Report' use case.
     * @param owner The authenticated GymOwner.
     * @return A string representing a summary report.
     */
    public String viewPerformanceReport(GymOwner owner) {
        // This is a placeholder. The actual implementation would
        // analyze booking data, revenue, etc.
        return "Performance report for " + owner.getName() + " is currently unavailable.";
    }
}
