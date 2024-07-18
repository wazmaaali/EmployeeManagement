package com.itsutra.employeemgmt.controllers.dto;

import com.itsutra.employeemgmt.enitity.Department;
import com.itsutra.employeemgmt.enitity.Role;

import java.util.Date;

public class EmployeeDTO {

    private int id;
    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private Date dob;
    private Date joiningDay;
    private Department department;
    private Role role;
    private int salary;


    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public void setJoiningDay(Date joiningDay) {
        this.joiningDay = joiningDay;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public Date getDob() {
        return dob;
    }

    public Date getJoiningDay() {
        return joiningDay;
    }

    public Department getDepartment() {
        return department;
    }

    public Role getRole() {
        return role;
    }

    public int getSalary() {
        return salary;
    }






}
