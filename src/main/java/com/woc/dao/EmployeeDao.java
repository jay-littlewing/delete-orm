package com.woc.dao;

import com.woc.model.Employee;

import java.util.List;

//CRUD - CREATE, READ, UPDATE, DELETE
public interface EmployeeDao {
    List<Employee> fetchAllEmployee();
    Employee fetchByEmail(String email);
    Employee createEmployee(Employee employee, String departmentCode);
    Employee saveEmployee(Employee employee);
    boolean deleteEmployee(Integer id);
    //boolean updateEmployee(Integer id, String name, Double salary, String department);

    Employee fetchById(Integer id);

    List<Employee> fetchByName(String name, String department);
}
