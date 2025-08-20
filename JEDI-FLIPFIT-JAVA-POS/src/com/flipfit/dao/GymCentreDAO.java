package com.flipfit.dao;

import com.flipfit.bean.GymCentre;
import java.util.*;

public class GymCentreDAO {
    private static Map<String, GymCentre> centres = new HashMap<>();

    public static void addCentre(GymCentre centre) {
        centres.put(centre.getGymId(), centre);
    }

    public static GymCentre getCentre(String gymId) {
        return centres.get(gymId);
    }

    public static List<GymCentre> getAllCentres() {
        return new ArrayList<>(centres.values());
    }
}
