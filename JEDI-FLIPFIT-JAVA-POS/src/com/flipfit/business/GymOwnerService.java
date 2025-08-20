package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.*;

import java.util.List;
import java.util.UUID;

public class GymOwnerService {

    // Register a new gym centre
    public void addGym(String ownerId, String name, String location) {
        GymCentre gym = new GymCentre(UUID.randomUUID().toString(), ownerId, name, location);
        GymCentreDAO.addCentre(gym);
    }

    // Add a new slot to a gym
    public void addSlot(String gymId, String time) {
        Slot slot = new Slot(UUID.randomUUID().toString(), time);
        SlotDAO.addSlot(slot);

        GymCentre centre = GymCentreDAO.getCentre(gymId);
        if (centre != null) {
            centre.addSlot(slot);
        }
    }

    // View gyms by owner
    public List<GymCentre> viewMyGyms(String ownerId) {
        return GymCentreDAO.getAllCentres().stream()
                .filter(g -> g.getOwnerId().equals(ownerId))
                .toList();
    }

    // View all bookings
    public List<Booking> viewAllBookings() {
        return BookingDAO.getAllBookings();
    }
}
