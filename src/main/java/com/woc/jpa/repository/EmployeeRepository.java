package com.woc.jpa.repository;

import com.woc.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    Employee findByEmail(String email);
    List<Employee> findByName(String name);
    List<Employee> findByNameAndDepartment(String name, String department);
}
