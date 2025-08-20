package com.flipfit.bean;

import java.util.ArrayList;
import java.util.List;

public class GymCentre {
    private String gymId;
    private String ownerId;
    private String name;
    private String location;
    private List<Slot> slots = new ArrayList<>();

    public GymCentre(String gymId, String ownerId, String name, String location) {
        this.gymId = gymId;
        this.ownerId = ownerId;
        this.name = name;
        this.location = location;
    }

    public String getGymId() { return gymId; }
    public String getOwnerId() { return ownerId; }
    public String getName() { return name; }
    public String getLocation() { return location; }
    public List<Slot> getSlots() { return slots; }

    public void addSlot(Slot slot) { slots.add(slot); }

    @Override
    public String toString() {
        return "GymCentre[" + gymId + "] " + name + " at " + location + " (Slots=" + slots.size() + ")";
    }
}
