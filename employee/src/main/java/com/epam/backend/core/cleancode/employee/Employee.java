package com.epam.backend.core.cleancode.employee;

public abstract class Employee {
    private final String name;

    protected Employee(String name) {
        this.name = name;
    }

    protected abstract Money calculatePay();
    protected abstract Money calculateBonus();

}
