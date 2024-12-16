package com.epam.backend.core.liskov;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CreditCardPayment extends PaymentMethod {

    private final Logger log = LoggerFactory.getLogger(getClass());

    boolean validatePaymentDetails() {
        // Validate credit card details
        return true; // Assuming validation is successful
    }

    void performPayment(double amount) {
        // Process credit card payment
        log.info("Processing credit card payment for amount: {}", amount);
    }

    void handlePaymentError() {
        // Handle credit card payment error
        log.error("Credit card payment details are invalid.");
    }
}
