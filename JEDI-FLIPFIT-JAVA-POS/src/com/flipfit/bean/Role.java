package com.flipfit.bean;

public class Role {
    private String roleId;
    private String name;

    public Role(String roleId, String name) {
        this.roleId = roleId;
        this.name = name;
    }

    public String getRoleId() { return roleId; }
    public String getName() { return name; }
}
