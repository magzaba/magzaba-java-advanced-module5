package com.epam.backend.core.cleancode.employee;

import java.math.BigDecimal;

public class HourlyEmployee extends Employee {

    private final int hours;
    private final int bonusPoints;
    private final Money hourlyRate;

    protected HourlyEmployee(String name, Money hourlyRate, int hours, int bonusPoints) {
        super(name);
        this.hourlyRate = hourlyRate;
        this.hours = hours;
        this.bonusPoints = bonusPoints;
    }

    @Override
    protected Money calculatePay() {
        return Money.of(hourlyRate.getAmount().multiply(BigDecimal.valueOf(hours)), hourlyRate.getCurrency());
    }

    @Override
    protected Money calculateBonus() {
        return Money.of(hourlyRate.getAmount().multiply(BigDecimal.valueOf(bonusPoints)), hourlyRate.getCurrency());
    }
}
