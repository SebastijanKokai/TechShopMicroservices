package com.iis.prodavnicatehnike.employees.controllers;
import com.iis.prodavnicatehnike.employees.dtos.CreateEmployeeDTO;
import com.iis.prodavnicatehnike.employees.dtos.EmployeeDTO;
import com.iis.prodavnicatehnike.employees.models.Employee;
import com.iis.prodavnicatehnike.employees.services.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path="/employees")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    @GetMapping()
    public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAllEmployees());
    }

    @GetMapping(path="/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> getEmployeeById(@PathVariable("id") Integer id){
        return ResponseEntity.ok(employeeService.findEmployeeById(id));
    }

    @PostMapping()
    public ResponseEntity<EmployeeDTO> insertEmployee(@RequestBody CreateEmployeeDTO employee){
        return ResponseEntity.ok(employeeService.createEmployee(employee));
    }

    @PutMapping(path="/{id}")
    public ResponseEntity<Optional<EmployeeDTO>> updateEmployee(@RequestBody CreateEmployeeDTO newEmployee, @PathVariable Integer id){
        Optional<EmployeeDTO> employee = employeeService.updateEmployee(newEmployee, id);
        if (employee.isPresent()) {
            return ResponseEntity.ok(employee);
        } else {
            return ResponseEntity.badRequest().body(employee);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable("id") Integer id)
    {
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }
}
