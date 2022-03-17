package com.woc.api;

import com.woc.dao.EmployeeDao;
import com.woc.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//http://localhost:9123/actuator/health

//@CrossOrigin(origins="*")
@CrossOrigin(origins={"http://localhost:5500", "http://127.0.0.0:5500", "http://127.0.0.1:5500"})
@RestController
@RequestMapping("/api")
public class EmployeeApi {

    @Autowired
    private EmployeeDao employeeDao;

    @PutMapping("/employee")
    public Employee updateEmployee(@RequestBody Employee employee) {
        Employee employeeFromDB = employeeDao.fetchById(employee.getId());
        if(null == employeeFromDB){
            throw new IllegalArgumentException("Id = " + employee.getId() + " does not exist in our system");
        }

        Employee updatedEmployee = employeeDao.saveEmployee(employee);
        return updatedEmployee;
    }

    @PatchMapping("/employee/id/{id}/name/{name}")
    public Employee patchEmployee(@PathVariable("id") Integer id, @PathVariable("name") String name){
        Employee employeeFromDB = employeeDao.fetchById(id);
        if(null == employeeFromDB){
            throw new IllegalArgumentException("Id = " + id + " does not exist in our system");
        }
        employeeFromDB.setName(name);
        Employee employee = employeeDao.saveEmployee(employeeFromDB);
        return employee;
    }

    @PostMapping("/employee/department/{dept_code}")
    public Employee createEmployee(@PathVariable("dept_code") String departmentCode, @RequestBody Employee employee){
        Employee employeeFromDB = employeeDao.createEmployee(employee, departmentCode);
        return employeeFromDB;
    }

    @GetMapping("/employee")
    public Employee fetchByEmail(@RequestParam("email") String email){
        Employee employee = employeeDao.fetchByEmail(email);
        return employee;
    }

    @GetMapping("/employeeById")
    public Employee fetchById(@RequestParam("id") Integer id){
        Employee employee = employeeDao.fetchById(id);
        return employee;
    }

    @GetMapping("/employee/id/{id}")
    public Employee getEmployeeById(@PathVariable("id") Integer id){
        Employee employee = employeeDao.fetchById(id);
        return employee;
    }

    @DeleteMapping("/employee/id/{id}")
    public boolean deleteEmployeeById(@PathVariable("id") Integer id){
        return employeeDao.deleteEmployee(id);
    }

    @GetMapping("/employeeByName")
    public List<Employee> fetchByName(@RequestParam("name") String name, @RequestParam(name = "dept", required = false) String department){
        List<Employee> employees = employeeDao.fetchByName(name, department);
        return employees;
    }

    @GetMapping("/employee/all")
    public List<Employee> fetchAllEmployee(){
        return employeeDao.fetchAllEmployee();
    }


}
