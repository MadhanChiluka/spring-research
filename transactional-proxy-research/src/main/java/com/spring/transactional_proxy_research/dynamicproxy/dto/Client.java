package com.spring.transactional_proxy_research.dynamicproxy.dto;

import java.lang.reflect.Proxy;

public class Client {
    public static void main(String[] args) {
        ITEmployee itEmployee = new ITEmployee();
        itEmployee.setId(4120);
        itEmployee.setName("Madhan Chiluka");
        itEmployee.setSalary(250000);
        itEmployee.giveHike(10000);
        System.out.println(itEmployee.getSalary());

        IEmployee employee = EmployeeSalaryInvocationHandler.createProxy(itEmployee);
        employee.giveHike(15000);
        System.out.println(employee.getSalary());

    }
}
