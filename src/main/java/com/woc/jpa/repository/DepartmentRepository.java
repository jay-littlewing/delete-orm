package com.woc.jpa.repository;

import com.woc.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByDepartmentCode(String departmentCode);
}
