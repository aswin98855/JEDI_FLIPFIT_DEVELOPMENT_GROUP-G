package com.flipfit.dao;

import com.flipfit.bean.Slot;
import java.util.*;

public class SlotDAO {
    private static Map<String, Slot> slots = new HashMap<>();

    public static void addSlot(Slot slot) {
        slots.put(slot.getSlotId(), slot);
    }

    public static Slot getSlot(String slotId) {
        return slots.get(slotId);
    }

    public static List<Slot> getAllSlots() {
        return new ArrayList<>(slots.values());
    }
}
