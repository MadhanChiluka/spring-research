package com.spring.transactional_proxy_research.dynamicproxy.dto;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class EmployeeSalaryInvocationHandler implements InvocationHandler {
    //Define Target Object
    private final IEmployee employeeTarget;

    public EmployeeSalaryInvocationHandler(IEmployee employeeTarget) {
        this.employeeTarget = employeeTarget;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        // Pre Processing
        if(method.getName().equals("giveHike")) {
            double hikeValue = (double) args[0];
            if(hikeValue <= 0.0) {
                throw new RuntimeException("Hike amount cannot be negative");
            }
        }


        // Make Actual Call
        Object returnValue = method.invoke(employeeTarget, args);

        // Post Processing
        System.out.println("Executing method : " + method.getName() + " for employee id : " + employeeTarget.getId());

        return returnValue;
    }

    public static IEmployee createProxy(IEmployee iEmployee) {
        EmployeeSalaryInvocationHandler empHandler = new EmployeeSalaryInvocationHandler(iEmployee);
        IEmployee employee = (IEmployee) Proxy.newProxyInstance(
                ITEmployee.class.getClassLoader(),
                new Class<?>[] {IEmployee.class},
                empHandler);
        return employee;
    }


}
