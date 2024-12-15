package com.epam.backend.core.cleancode.employee;

import java.math.BigDecimal;

public class CommissionedEmployee extends Employee{

    private static final Money COMMISSION_BASE = Money.of(BigDecimal.valueOf(100), "USD");
    private final double commissionMultiplier;
    private final double bonusMultiplier;

    protected CommissionedEmployee(String name, double commissionMultiplier, double bonusMultiplier) {
        super(name);
        this.commissionMultiplier = commissionMultiplier;
        this.bonusMultiplier = bonusMultiplier;
    }

    @Override
    protected Money calculatePay() {
        return COMMISSION_BASE.multipliedBy(commissionMultiplier);
    }

    @Override
    protected Money calculateBonus() {
        return COMMISSION_BASE.multipliedBy(bonusMultiplier);
    }
}
