package com.flipfit.dao;

import com.flipfit.bean.Admin;
import java.util.HashMap;
import java.util.Map;

public class AdminDAO {
    private static Map<String, Admin> admins = new HashMap<>();

    static {
        admins.put("A1", new Admin("A1", "System Admin", "admin@flipfit.com", "admin123"));
    }

    public static Admin getAdmin(String adminId) {
        return admins.get(adminId);
    }

    public static Map<String, Admin> getAllAdmins() {
        return admins;
    }
}
