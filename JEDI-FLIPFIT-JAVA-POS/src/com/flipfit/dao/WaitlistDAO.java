package com.flipfit.dao;

import com.flipfit.bean.Waitlist;
import java.util.*;

public class WaitlistDAO {
    private static List<Waitlist> waitlists = new ArrayList<>();

    public static void addWaitlist(Waitlist waitlist) {
        waitlists.add(waitlist);
    }

    public static List<Waitlist> getAllWaitlists() {
        return waitlists;
    }
}
