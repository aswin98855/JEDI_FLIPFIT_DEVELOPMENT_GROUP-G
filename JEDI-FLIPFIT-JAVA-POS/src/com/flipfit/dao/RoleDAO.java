package com.flipfit.dao;

import com.flipfit.bean.Role;
import java.util.*;

public class RoleDAO {
    private static Map<String, Role> roles = new HashMap<>();

    static {
        roles.put("ADMIN", new Role("1", "ADMIN"));
        roles.put("CUSTOMER", new Role("2", "CUSTOMER"));
        roles.put("OWNER", new Role("3", "OWNER"));
    }

    public static Role getRole(String name) {
        return roles.get(name);
    }

    public static List<Role> getAllRoles() {
        return new ArrayList<>(roles.values());
    }
}
