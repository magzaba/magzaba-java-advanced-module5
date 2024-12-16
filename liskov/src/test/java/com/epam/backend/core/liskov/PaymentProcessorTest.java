package com.epam.backend.core.liskov;

import org.junit.jupiter.api.Test;

import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.doNothing;

class PaymentProcessorTest {
    @Test
    void testCreditCardPaymentSuccess() {
        // given
        PaymentMethod creditCardPayment = mock(CreditCardPayment.class);
        when(creditCardPayment.validatePaymentDetails()).thenReturn(true);
        doNothing().when(creditCardPayment).performPayment(anyDouble());
        PaymentProcessor processor = new PaymentProcessor();

        // when
        processor.makePayment(creditCardPayment, 100.0);

        // then
        verify(creditCardPayment).validatePaymentDetails();
        verify(creditCardPayment).performPayment(100.0);
        verify(creditCardPayment, never()).handlePaymentError();
    }

    @Test
    void testCreditCardPaymentFailure() {
        // given
        PaymentMethod creditCardPayment = mock(CreditCardPayment.class);
        when(creditCardPayment.validatePaymentDetails()).thenReturn(false);
        doNothing().when(creditCardPayment).handlePaymentError();
        PaymentProcessor processor = new PaymentProcessor();

        // when
        processor.makePayment(creditCardPayment, 100.0);

        // then
        verify(creditCardPayment).validatePaymentDetails();
        verify(creditCardPayment, never()).performPayment(anyDouble());
        verify(creditCardPayment).handlePaymentError();
    }

    @Test
    void testPayPalPaymentSuccess() {
        // given
        PaymentMethod payPalPayment = mock(PayPalPayment.class);
        when(payPalPayment.validatePaymentDetails()).thenReturn(true);
        doNothing().when(payPalPayment).performPayment(anyDouble());
        PaymentProcessor processor = new PaymentProcessor();

        // when
        processor.makePayment(payPalPayment, 200.0);

        // then
        verify(payPalPayment).validatePaymentDetails();
        verify(payPalPayment).performPayment(200.0);
        verify(payPalPayment, never()).handlePaymentError();
    }

    @Test
    void testPayPalPaymentFailure() {
        // given
        PaymentMethod payPalPayment = mock(PayPalPayment.class);
        when(payPalPayment.validatePaymentDetails()).thenReturn(false);
        doNothing().when(payPalPayment).handlePaymentError();
        PaymentProcessor processor = new PaymentProcessor();

        // Act
        processor.makePayment(payPalPayment, 200.0);

        // then
        verify(payPalPayment).validatePaymentDetails();
        verify(payPalPayment, never()).performPayment(anyDouble());
        verify(payPalPayment).handlePaymentError();
    }
}