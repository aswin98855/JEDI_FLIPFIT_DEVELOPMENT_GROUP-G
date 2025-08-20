package com.flipfit.dao;

import com.flipfit.bean.*;

public class BootstrapData {

    public static void init() {
        UserDAO.addUser(new Admin("A1", "System Admin", "admin@flipfit.com", "admin123"));

        GymOwner owner1 = new GymOwner("O1", "Vishnu", "owner@flipfit.com", "owner123");
        GymOwner owner2 = new GymOwner("O2", "Pankaj", "pankaj@flipfit.com", "pankaj123");
        UserDAO.addUser(owner1);
        UserDAO.addUser(owner2);

        Customer cust1 = new Customer("C1", "Arpit", "cust1@flipfit.com", "cust123");
        Customer cust2 = new Customer("C2", "Aryan", "cust2@flipfit.com", "aryan123");
        UserDAO.addUser(cust1);
        UserDAO.addUser(cust2);

        GymCentre gym1 = new GymCentre("G1", owner1.getUserId(), "Iron Temple", "C4 Block");
        GymCentre gym2 = new GymCentre("G2", owner2.getUserId(), "Lift Lab", "HSR Layout");
        GymCentreDAO.addCentre(gym1);
        GymCentreDAO.addCentre(gym2);

        Slot s1 = new Slot("S1", "06:00 - 07:00 AM");
        Slot s2 = new Slot("S2", "07:00 - 08:00 AM");
        Slot s3 = new Slot("S3", "06:00 - 07:00 PM");
        Slot s4 = new Slot("S4", "07:00 - 08:00 PM");

        SlotDAO.addSlot(s1); gym1.addSlot(s1);
        SlotDAO.addSlot(s2); gym1.addSlot(s2);
        SlotDAO.addSlot(s3); gym2.addSlot(s3);
        SlotDAO.addSlot(s4); gym2.addSlot(s4);

        Booking b1 = new Booking("B1", cust1.getUserId(), s1.getSlotId(), gym1.getGymId());
        b1.setPaymentStatus(false);
        s1.setAvailable(false);
        BookingDAO.addBooking(b1);

        Payment p1 = new Payment("P1", b1.getBookingId(), 500);
        PaymentDAO.addPayment(p1);
        b1.setPaymentStatus(true);

        Notification n1 = new Notification("N1", cust1.getUserId(),
                "Your booking for " + s1.getTime() + " at " + gym1.getName() + " is confirmed!");
        Notification n2 = new Notification("N2", owner1.getUserId(),
                "Customer " + cust1.getName() + " booked a slot at your gym " + gym1.getName());
        NotificationDAO.addNotification(n1);
        NotificationDAO.addNotification(n2);
    }
}
