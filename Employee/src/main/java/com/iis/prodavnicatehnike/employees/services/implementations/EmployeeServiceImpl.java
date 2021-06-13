package com.iis.prodavnicatehnike.employees.services.implementations;

import com.iis.prodavnicatehnike.employees.dtos.CreateEmployeeDTO;
import com.iis.prodavnicatehnike.employees.dtos.EmployeeDTO;
import com.iis.prodavnicatehnike.employees.models.Employee;
import com.iis.prodavnicatehnike.employees.repositories.EmployeeRepository;
import com.iis.prodavnicatehnike.employees.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<Employee> employeeEntities = employeeRepository.findAll();
        List<EmployeeDTO> employeeDtos = new ArrayList<>();
        for (Employee employee : employeeEntities) {
            employeeDtos.add(new EmployeeDTO(employee.getId(), employee.getName(), employee.getLastName(), employee.getContact()));
        }
        return employeeDtos;
    }

    @Override
    public Optional<EmployeeDTO> findEmployeeById(Integer id) {
        Optional<Employee> employeeEntity = employeeRepository.findById(id);
        return employeeEntity.map(employee -> new EmployeeDTO(employee.getId(), employee.getName(),
                employee.getLastName(), employee.getContact()));
    }

    @Override
    public EmployeeDTO createEmployee(CreateEmployeeDTO employee) {
        Employee employeeEntity = new Employee();
        employeeEntity.setName(employee.getName());
        employeeEntity.setLastName(employee.getLastName());
        employeeEntity.setContact(employee.getContact());
        Employee newEntity = employeeRepository.save(employeeEntity);
        return new EmployeeDTO(newEntity.getId(), newEntity.getName(), newEntity.getLastName(), newEntity.getContact());
    }

    @Override
    public Optional<EmployeeDTO> updateEmployee(CreateEmployeeDTO newEmployee, Integer id) {
        return employeeRepository.findById(id).map(oldEmployee -> {
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setLastName(newEmployee.getLastName());
            oldEmployee.setContact(newEmployee.getContact());
            Employee updatedEntity =  employeeRepository.save(oldEmployee);
            return new EmployeeDTO(updatedEntity.getId(), updatedEntity.getName(), updatedEntity.getLastName(),
                    updatedEntity.getContact());
        });
    }

    @Override
    public void deleteEmployee(Integer id) {
        employeeRepository.deleteById(id);
    }
}
