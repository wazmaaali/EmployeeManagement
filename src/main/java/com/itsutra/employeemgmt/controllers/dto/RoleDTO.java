package com.itsutra.employeemgmt.controllers.dto;

import com.itsutra.employeemgmt.enitity.Employee;

import java.util.List;

public class RoleDTO {

    private int id;
    private String name;
    private List<Employee> employees;

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
