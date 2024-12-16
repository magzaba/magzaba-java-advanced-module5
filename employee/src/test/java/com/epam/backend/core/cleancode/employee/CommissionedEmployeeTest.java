package com.epam.backend.core.cleancode.employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CommissionedEmployeeTest {

    @Test
    void testCalculatePay() {
        double commissionMultiplier = 8;
        CommissionedEmployee employee = new CommissionedEmployee("Jane Doe", commissionMultiplier, 2);

        Money expectedPay = Money.of(BigDecimal.valueOf(800), "USD");
        assertEquals(expectedPay, employee.calculatePay());
    }

    @Test
    void testCalculateBonus() {
        double bonusMultiplier = 2;
        CommissionedEmployee employee = new CommissionedEmployee("Jane Doe", 5, bonusMultiplier);

        Money expectedBonus = Money.of(BigDecimal.valueOf(200), "USD");
        assertEquals(expectedBonus, employee.calculateBonus());
    }
}