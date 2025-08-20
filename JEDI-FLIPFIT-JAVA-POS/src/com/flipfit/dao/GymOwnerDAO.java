package com.flipfit.dao;

import com.flipfit.bean.GymOwner;
import java.util.*;

public class GymOwnerDAO {
    private static Map<String, GymOwner> owners = new HashMap<>();

    public static void addOwner(GymOwner owner) {
        owners.put(owner.getUserId(), owner);
    }

    public static GymOwner getOwner(String ownerId) {
        return owners.get(ownerId);
    }

    public static List<GymOwner> getAllOwners() {
        return new ArrayList<>(owners.values());
    }
}
