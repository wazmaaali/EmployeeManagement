package com.itsutra.employeemgmt.repositories;

import com.itsutra.employeemgmt.enitity.Department;
import org.springframework.data.repository.CrudRepository;

public interface DepartmentRepository extends CrudRepository<Department, Long> {
}
