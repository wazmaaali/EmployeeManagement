package com.itsutra.employeemgmt.controllers;

import com.itsutra.employeemgmt.controllers.dto.DepartmentDTO;
import com.itsutra.employeemgmt.controllers.dto.EmployeeDTO;
import com.itsutra.employeemgmt.enitity.Department;
import com.itsutra.employeemgmt.enitity.Employee;
import com.itsutra.employeemgmt.services.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/")
    public ResponseEntity<List<DepartmentDTO>> getAllDepartments() {

        List<Department> departments = departmentService.getAllDepartments();
        List<DepartmentDTO> departmentDTOs = departments.stream()
                .map(this::convertToDto)
                .toList();
        return ResponseEntity.ok().body(departmentDTOs);

    }
    @PostMapping("/")
    public ResponseEntity<Void> addEmployee(@RequestBody DepartmentDTO departmenDTO) {
        Department department = convertToEntity(departmenDTO);
        departmentService.addDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }
    public DepartmentDTO convertToDto(Department department) {

        DepartmentDTO departmentDTO = new DepartmentDTO();
        departmentDTO.setId(department.getId());
        departmentDTO.setName(department.getName());
//        departmentDTO.setEmployees(department.getEmployees());
        return departmentDTO;
    }
    public Department convertToEntity(DepartmentDTO departmentDTO) {
        Department department = new Department();
        department.setId(departmentDTO.getId());
        department.setName(departmentDTO.getName());
//        department.setEmployees(departmentDTO.getEmployees());
        return department;

    }

}