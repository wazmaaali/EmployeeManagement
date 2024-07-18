package com.itsutra.employeemgmt.repositories;
import com.itsutra.employeemgmt.enitity.Employee;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository extends CrudRepository<Employee, Long> {
}