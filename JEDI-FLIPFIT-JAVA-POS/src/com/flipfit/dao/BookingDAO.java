package com.flipfit.dao;

import com.flipfit.bean.Booking;
import java.util.*;

public class BookingDAO {
    private static Map<String, Booking> bookings = new HashMap<>();

    public static void addBooking(Booking booking) {
        bookings.put(booking.getBookingId(), booking);
    }

    public static Booking getBooking(String bookingId) {
        return bookings.get(bookingId);
    }

    public static List<Booking> getAllBookings() {
        return new ArrayList<>(bookings.values());
    }

    public static void removeBooking(String bookingId) {
        bookings.remove(bookingId);
    }
}
