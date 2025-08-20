package com.flipfit.bean;

public class Customer extends User {
    public Customer(String userId, String name, String email, String password) {
        super(userId, name, email, password, "CUSTOMER");
    }
}
