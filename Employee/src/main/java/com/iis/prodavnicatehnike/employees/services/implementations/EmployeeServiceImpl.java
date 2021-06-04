package com.iis.prodavnicatehnike.employees.services.implementations;

import com.iis.prodavnicatehnike.employees.models.Employee;
import com.iis.prodavnicatehnike.employees.repositories.EmployeeRepository;
import com.iis.prodavnicatehnike.employees.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> findAllEmployees() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findEmployeeById(Integer id) {
        return employeeRepository.findById(id);
    }

    @Override
    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> updateEmployee(Employee newEmployee, Integer id) {
        return employeeRepository.findById(id).map(oldEmployee -> {
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setLastName(newEmployee.getLastName());
            oldEmployee.setContact(newEmployee.getContact());
            return employeeRepository.save(oldEmployee);
        });
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
