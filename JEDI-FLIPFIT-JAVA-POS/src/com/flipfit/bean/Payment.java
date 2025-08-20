package com.flipfit.bean;

public class Payment {
    private String paymentId;
    private String bookingId;
    private double amount;
    private boolean success;

    public Payment(String paymentId, String bookingId, double amount) {
        this.paymentId = paymentId;
        this.bookingId = bookingId;
        this.amount = amount;
        this.success = true; // mock: always successful
    }

    @Override
    public String toString() {
        return "Payment[" + paymentId + "] Booking=" + bookingId + " Amount=" + amount + " Success=" + success;
    }
}
