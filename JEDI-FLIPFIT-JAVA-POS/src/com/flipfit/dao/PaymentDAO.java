package com.flipfit.dao;

import com.flipfit.bean.Payment;
import java.util.*;

public class PaymentDAO {
    private static Map<String, Payment> payments = new HashMap<>();

    public static void addPayment(Payment payment) {
        payments.put(payment.toString(), payment);
    }

    public static List<Payment> getAllPayments() {
        return new ArrayList<>(payments.values());
    }
}
