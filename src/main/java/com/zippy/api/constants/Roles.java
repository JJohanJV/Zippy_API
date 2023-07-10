package com.zippy.api.constants;

public enum Roles {
    ADMIN, CLIENT, EMPLOYEE;

    public Roles[] getRoles() {
        return Roles.values();
    }
}
