package com.flipfit.bean;

public class Slot {
    private String slotId;
    private String time;
    private boolean available;

    public Slot(String slotId, String time) {
        this.slotId = slotId;
        this.time = time;
        this.available = true;
    }

    public String getSlotId() { return slotId; }
    public String getTime() { return time; }
    public boolean isAvailable() { return available; }

    public void setAvailable(boolean available) { this.available = available; }

    @Override
    public String toString() {
        return "Slot[" + slotId + "] " + time + " Available=" + available;
    }
}
