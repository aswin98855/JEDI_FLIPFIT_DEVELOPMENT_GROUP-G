package com.flipfit.dao;

import com.flipfit.bean.Customer;
import java.util.*;

public class CustomerDAO {
    private static Map<String, Customer> customers = new HashMap<>();

    public static void addCustomer(Customer customer) {
        customers.put(customer.getUserId(), customer);
    }

    public static Customer getCustomer(String customerId) {
        return customers.get(customerId);
    }

    public static List<Customer> getAllCustomers() {
        return new ArrayList<>(customers.values());
    }
}
