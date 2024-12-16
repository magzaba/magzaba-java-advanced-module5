package com.epam.backend.core.cleancode.liskov;

public class PaymentProcessor {

    public void makePayment(PaymentMethod payment, double amount) {
        payment.processPayment(amount);
    }
}
