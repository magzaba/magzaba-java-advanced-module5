package com.epam.backend.core.cleancode.employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SalariedEmployeeTest {

    @Test
    void testCalculatePay() {
        Money baseSalary = Money.of(BigDecimal.valueOf(3000), "USD");
        SalariedEmployee employee = new SalariedEmployee("John Doe", baseSalary, 0.10);

        Money expectedPay = Money.of(BigDecimal.valueOf(3000), "USD");
        assertEquals(expectedPay, employee.calculatePay());
    }

    @Test
    void testCalculateBonus() {
        Money baseSalary = Money.of(BigDecimal.valueOf(3000), "USD");
        double bonusRate = 0.10;
        SalariedEmployee employee = new SalariedEmployee("John Doe", baseSalary, bonusRate);

        Money expectedBonus = Money.of(BigDecimal.valueOf(300), "USD");
        assertEquals(expectedBonus, employee.calculateBonus());
    }
}