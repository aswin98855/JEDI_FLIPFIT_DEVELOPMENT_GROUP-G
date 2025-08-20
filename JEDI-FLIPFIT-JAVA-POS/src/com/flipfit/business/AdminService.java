package com.flipfit.business;

import com.flipfit.bean.*;
import com.flipfit.dao.*;

import java.util.List;

public class AdminService {

    // Approve gym centres (simply return all for now)
    public List<GymCentre> viewAllCentres() {
        return GymCentreDAO.getAllCentres();
    }

    // View all users
    public List<User> viewAllUsers() {
        return UserDAO.getAllUsers();
    }

    // View all bookings
    public List<Booking> viewAllBookings() {
        return BookingDAO.getAllBookings();
    }
}
