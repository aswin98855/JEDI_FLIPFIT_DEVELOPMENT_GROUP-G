package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.*;

import java.util.List;
import java.util.UUID;

public class CustomerService {

    // Browse all gyms
    public List<GymCentre> viewGyms() {
        return GymCentreDAO.getAllCentres();
    }

    // Browse available slots
    public List<Slot> viewSlots() {
        return SlotDAO.getAllSlots();
    }

    // Book a slot
    public Booking bookSlot(String customerId, String slotId, String gymId) {
        Slot slot = SlotDAO.getSlot(slotId);
        if (slot != null && slot.isAvailable()) {
            slot.setAvailable(false);
            Booking booking = new Booking(UUID.randomUUID().toString(), customerId, slotId, gymId);
            BookingDAO.addBooking(booking);
            NotificationDAO.addNotification(new Notification(UUID.randomUUID().toString(), customerId,
                    "Booking confirmed for slot " + slot.getTime()));
            return booking;
        }
        return null;
    }

    // Cancel a booking
    public boolean cancelBooking(String bookingId) {
        Booking booking = BookingDAO.getBooking(bookingId);
        if (booking != null) {
            BookingDAO.removeBooking(bookingId);
            Slot slot = SlotDAO.getSlot(booking.getSlotId());
            if (slot != null) slot.setAvailable(true);
            return true;
        }
        return false;
    }

    // View my bookings
    public List<Booking> viewBookings() {
        return BookingDAO.getAllBookings();
    }
}
