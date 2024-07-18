package com.itsutra.employeemgmt.controllers.dto;

import com.itsutra.employeemgmt.enitity.Employee;

import java.util.List;

public class DepartmentDTO {
    private int id;
    private String name;
    private List<Employee> employees;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public List<Employee> getEmployees() {
//        return employees;
//    }
//
//    public void setEmployees(List<Employee> employees) {
//        this.employees = employees;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }




}
