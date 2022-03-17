package com.woc.dao.impl;

import com.woc.dao.EmployeeDao;
import com.woc.jpa.repository.DepartmentRepository;
import com.woc.jpa.repository.EmployeeRepository;
import com.woc.model.Department;
import com.woc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeDaoImpl implements EmployeeDao {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Employee> fetchAllEmployee() {
        List<Employee> employees = employeeRepository.findAll();
        return employees;
    }

    @Override
    public Employee fetchByEmail(String email) {
        Employee employee = employeeRepository.findByEmail(email);
        return employee;
    }

    @Override
    public Employee fetchById(Integer id) {
        Employee employee = employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> fetchByName(String name, String department) {
        System.out.println("department="+department);
        if(null == department) {
            return employeeRepository.findByName(name);
        }
        return employeeRepository.findByNameAndDepartment(name, department);
    }

    @Override
    public Employee createEmployee(Employee employee, String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        employee.setDepartment(department);

        Employee savedDataFromDB = employeeRepository.save(employee);
        return savedDataFromDB;
    }


    @Override
    public Employee saveEmployee(Employee employee) {
        Employee savedDataFromDB = employeeRepository.save(employee);
        return savedDataFromDB;
    }

    @Override
    public boolean deleteEmployee(Integer id) {
        try {
            employeeRepository.deleteById(id);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    /*@Override
    public boolean updateEmployee(Integer id, String name, Double salary, String department) {
        try {
            Employee employee = employeeRepository.findById(id).get();
            employee.setName(name);
            employee.setSalary(salary);
            employee.setDepartment(department);
            employeeRepository.save(employee);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }*/
}
