package com.flipfit.business;

import com.flipfit.bean.Payment;
import com.flipfit.bean.Booking;
import com.flipfit.dao.*;

import java.util.List;
import java.util.UUID;

public class PaymentService {

    // Process payment for a booking (mock: always successful)
    public Payment makePayment(String bookingId, double amount) {
        Booking booking = BookingDAO.getBooking(bookingId);
        if (booking != null) {
            Payment payment = new Payment(UUID.randomUUID().toString(), bookingId, amount);
            booking.setPaymentStatus(true);
            PaymentDAO.addPayment(payment);
            return payment;
        }
        return null;
    }

    // View all payments
    public List<Payment> viewPayments() {
        return PaymentDAO.getAllPayments();
    }
}
