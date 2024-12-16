package com.epam.backend.core.cleancode.liskov;

public abstract class PaymentMethod {
    // Template method
    final void processPayment(double amount) {
        if (validatePaymentDetails()) {
            performPayment(amount);
        } else {
            handlePaymentError();
        }
    }

    abstract boolean validatePaymentDetails();
    abstract void performPayment(double amount);
    abstract void handlePaymentError();
}
