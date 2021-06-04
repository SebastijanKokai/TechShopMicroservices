package com.iis.prodavnicatehnike.employees.services.interfaces;

import com.iis.prodavnicatehnike.employees.models.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> findAllEmployees();
    Optional<Employee> findEmployeeById(Integer id);
    Employee createEmployee(Employee employee);
    Optional<Employee> updateEmployee(Employee employee, Integer id);
    void deleteEmployee(Integer id);
}