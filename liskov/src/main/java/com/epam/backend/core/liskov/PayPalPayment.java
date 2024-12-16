package com.epam.backend.core.liskov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class PayPalPayment extends PaymentMethod {

    private final Logger log = LoggerFactory.getLogger(getClass());

    boolean validatePaymentDetails() {
        // Validate PayPal account
        return true; // Assuming validation is successful
    }

    void performPayment(double amount) {
        // Log in to PayPal and process payment
        log.info("Processing PayPal payment for amount: {}", amount);
    }

    void handlePaymentError() {
        // Handle PayPal payment error
        log.error("PayPal payment details are invalid or account not linked to bank.");
    }
}
