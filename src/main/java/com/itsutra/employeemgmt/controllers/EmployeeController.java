package com.itsutra.employeemgmt.controllers;


import com.itsutra.employeemgmt.controllers.dto.EmployeeDTO;
import com.itsutra.employeemgmt.enitity.Employee;
import com.itsutra.employeemgmt.services.EmployeeServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServices employeeService;
    @GetMapping("/")
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        List<Employee> employees = employeeService.getAllEmployees();
        List<EmployeeDTO> employeeDTOs = employees.stream()
                .map(this::convertToDto)
                .collect(Collectors.toList());
        return ResponseEntity.ok().body(employeeDTOs);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmployeeById(@PathVariable Long id) {
        Employee employee = employeeService.getEmployeeById(id);
        if (employee != null) {
            EmployeeDTO employeeDTO = convertToDto(employee); // Using EmployeeMapper to convert to DTO
            return ResponseEntity.ok().body(employeeDTO);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @PostMapping("/")
    public ResponseEntity<Void> addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        Employee employee = convertToEntity(employeeDTO);
        employeeService.addEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateEmployee(@RequestBody EmployeeDTO employeeDTO, @PathVariable Long id) {
        Employee employee = convertToEntity(employeeDTO);
        employeeService.updateEmployee(employee);
        return ResponseEntity.ok().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);

        return ResponseEntity.ok().build();

    }
    //map struct
    public EmployeeDTO convertToDto(Employee employee) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(employee.getId());
        employeeDTO.setFirstName(employee.getFirstName());
        employeeDTO.setLastName(employee.getLastName());
        employeeDTO.setPhone(employee.getPhone());
        employeeDTO.setEmail(employee.getEmail());
        employeeDTO.setDob(employee.getDob());
        employeeDTO.setDepartment(employee.getDepartment());
        employeeDTO.setRole(employee.getRole());
        employeeDTO.setSalary(employee.getSalary());
        employeeDTO.setJoiningDay(employee.getJoiningDay());
        return employeeDTO;
    }
    public Employee convertToEntity(EmployeeDTO employeeDTO) {
        Employee employee = new Employee();
        employee.setId(employeeDTO.getId());
        employee.setFirstName(employeeDTO.getFirstName());
        employee.setLastName(employeeDTO.getLastName());
        employee.setPhone(employeeDTO.getPhone());
        employee.setEmail(employeeDTO.getEmail());
        employee.setDob(employeeDTO.getDob());
        employee.setDepartment(employeeDTO.getDepartment());
        employee.setRole(employeeDTO.getRole());
        employee.setSalary(employeeDTO.getSalary());
        employee.setJoiningDay(employeeDTO.getJoiningDay());


        return employee;
    }
}
