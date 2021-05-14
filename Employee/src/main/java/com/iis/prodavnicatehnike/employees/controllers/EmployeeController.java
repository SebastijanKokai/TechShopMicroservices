package com.iis.prodavnicatehnike.employees.controllers;
import com.iis.prodavnicatehnike.employees.models.Employee;
import com.iis.prodavnicatehnike.employees.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @GetMapping()
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.ok(employeeRepository.findAll());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeRepository.findById(id));
    }

    @PostMapping()
    public ResponseEntity<Employee> insertEmployee(@RequestBody Employee employee){
        return ResponseEntity.ok(employeeRepository.save(employee));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<Employee>> updateEmployee(@RequestBody Employee newEmployee, @PathVariable Integer id){
        Optional<Employee> employee = employeeRepository.findById(id).map(oldEmployee -> {
            oldEmployee.setName(newEmployee.getName());
            oldEmployee.setLastName(newEmployee.getLastName());
            oldEmployee.setContact(newEmployee.getContact());
            return employeeRepository.save(oldEmployee);
        });
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.badRequest().body(employee);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
