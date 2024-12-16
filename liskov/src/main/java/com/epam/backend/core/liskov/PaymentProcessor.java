package com.epam.backend.core.liskov;

public class PaymentProcessor {

    public void makePayment(PaymentMethod payment, double amount) {
        payment.processPayment(amount);
    }
}
