package com.epam.backend.core.cleancode.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PayrollService {

    public Map<Employee, List<Money>> createPaymentList(List<Employee> employees){
        Map<Employee, List<Money>> paymentList = new HashMap<>();
        employees.forEach(employee -> paymentList.put(employee, List.of(employee.calculatePay(), employee.calculateBonus())));
        return paymentList;
    }
}
