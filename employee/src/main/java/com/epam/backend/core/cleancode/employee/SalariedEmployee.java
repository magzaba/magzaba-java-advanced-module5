package com.epam.backend.core.cleancode.employee;

public class SalariedEmployee extends Employee {
    private final Money baseSalary;
    private final double bonusRate;

    protected SalariedEmployee(String name, Money baseSalary, double bonusRate) {
        super(name);
        this.baseSalary = baseSalary;
        this.bonusRate = bonusRate;
    }

    @Override
    protected Money calculatePay() {
        return baseSalary;
    }

    @Override
    protected Money calculateBonus() {
        return baseSalary.multipliedBy(bonusRate);
    }
}