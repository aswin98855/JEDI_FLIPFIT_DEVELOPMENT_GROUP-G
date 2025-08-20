package com.flipfit.bean;

public class Waitlist {
    private String waitlistId;
    private String slotId;
    private String customerId;

    public Waitlist(String waitlistId, String slotId, String customerId) {
        this.waitlistId = waitlistId;
        this.slotId = slotId;
        this.customerId = customerId;
    }

    @Override
    public String toString() {
        return "Waitlist[" + waitlistId + "] Slot=" + slotId + " Customer=" + customerId;
    }
}
