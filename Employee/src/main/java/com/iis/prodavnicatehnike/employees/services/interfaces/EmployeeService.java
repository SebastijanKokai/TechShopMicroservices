package com.iis.prodavnicatehnike.employees.services.interfaces;

import com.iis.prodavnicatehnike.employees.dtos.CreateEmployeeDTO;
import com.iis.prodavnicatehnike.employees.dtos.EmployeeDTO;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<EmployeeDTO> findAllEmployees();
    Optional<EmployeeDTO> findEmployeeById(Integer id);
    EmployeeDTO createEmployee(CreateEmployeeDTO employee);
    Optional<EmployeeDTO> updateEmployee(CreateEmployeeDTO employee, Integer id);
    void deleteEmployee(Integer id);
}