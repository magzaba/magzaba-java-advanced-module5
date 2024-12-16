package com.epam.backend.core.cleancode.employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HourlyEmployeeTest {

    @Test
    void testCalculatePay() {
        Money hourlyRate = Money.of(BigDecimal.valueOf(20), "USD");
        int hours = 160;
        HourlyEmployee employee = new HourlyEmployee("Alice Smith", hourlyRate, hours, 10);

        Money expectedPay = Money.of(BigDecimal.valueOf(3200), "USD");
        assertEquals(expectedPay, employee.calculatePay());
    }

    @Test
    void testCalculateBonus() {
        Money hourlyRate = Money.of(BigDecimal.valueOf(20), "USD");
        int bonusPoints = 10;
        HourlyEmployee employee = new HourlyEmployee("Alice Smith", hourlyRate, 160, bonusPoints);

        Money expectedBonus = Money.of(BigDecimal.valueOf(200), "USD");
        assertEquals(expectedBonus, employee.calculateBonus());
    }
}