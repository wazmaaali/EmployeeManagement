package com.itsutra.employeemgmt.services;

import com.itsutra.employeemgmt.enitity.Employee;
import com.itsutra.employeemgmt.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServices {
    @Autowired
    private EmployeeRepository employeeRepository;
    public List<Employee> getAllEmployees() {
        return (List<Employee>) employeeRepository.findAll();
    }
    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id).orElse(null);
    }
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }


}
