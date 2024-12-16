package com.epam.backend.core.cleancode.employee;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PayrollServiceTest {

    @Test
    void testCreatePaymentList(){
        Employee employee1 = new SalariedEmployee("Employee One", Money.of(BigDecimal.valueOf(3000), "USD"), 0.1d);
        var pay1 = Money.of(BigDecimal.valueOf(3000), "USD");
        var bonus1 = Money.of(BigDecimal.valueOf(300), "USD");
        Employee employee2 = new HourlyEmployee("Employee Two", Money.of(BigDecimal.valueOf(20), "USD"), 160, 10);
        var pay2 = Money.of(BigDecimal.valueOf(3200), "USD");
        var bonus2 = Money.of(BigDecimal.valueOf(200), "USD");
        Employee employee3 = new CommissionedEmployee("Employee Three", 8, 2);
        var pay3 = Money.of(BigDecimal.valueOf(800), "USD");
        var bonus3 = Money.of(BigDecimal.valueOf(200), "USD");

        var payrollService = new PayrollService();

        var salaryList = payrollService.createPaymentList(List.of(employee1, employee2, employee3));

        assertNotNull(salaryList);
        assertEquals(3, salaryList.size());
        assertTrue(salaryList.containsKey(employee1));
        assertTrue(salaryList.containsKey(employee2));
        assertTrue(salaryList.containsKey(employee3));
        assertEquals(List.of(pay1, bonus1), salaryList.get(employee1));
        assertEquals(List.of(pay2, bonus2), salaryList.get(employee2));
        assertEquals(List.of(pay3, bonus3), salaryList.get(employee3));
    }

}