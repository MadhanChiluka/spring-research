package com.spring.transactional_proxy_research.dynamicproxy.dto;

public interface IEmployee {

    public void setId(int id);

    public void setName(String name);

    public void setSalary(double salary);

    public String getName();

    public int getId();

    public double getSalary();

    public void giveHike(double amount);

    public void payCut(double amount);
}
