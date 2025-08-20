package com.flipfit.bean;

public class Booking {
    private String bookingId;
    private String customerId;
    private String slotId;
    private String gymCentreId;
    private boolean paymentStatus;

    public Booking(String bookingId, String customerId, String slotId, String gymCentreId) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.slotId = slotId;
        this.gymCentreId = gymCentreId;
        this.paymentStatus = false;
    }

    public String getBookingId() { return bookingId; }
    public String getCustomerId() { return customerId; }
    public String getSlotId() { return slotId; }
    public String getGymCentreId() { return gymCentreId; }
    public boolean isPaymentStatus() { return paymentStatus; }

    public void setPaymentStatus(boolean status) { this.paymentStatus = status; }

    @Override
    public String toString() {
        return "Booking[" + bookingId + "] Customer=" + customerId + " Slot=" + slotId +
                " Gym=" + gymCentreId + " Paid=" + paymentStatus;
    }
}
