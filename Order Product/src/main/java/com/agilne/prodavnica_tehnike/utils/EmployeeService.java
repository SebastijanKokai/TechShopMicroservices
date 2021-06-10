package com.agilne.prodavnica_tehnike.utils;

import com.agilne.prodavnica_tehnike.models.Employee;
import org.springframework.web.client.RestTemplate;

public class EmployeeService {
    private final RestTemplate restTemplate = new RestTemplate();
    private final String employeeURL = "http://localhost:8083/employees";

    public Employee getEmployeeById(Integer employeeId) {
        return restTemplate.getForObject(employeeURL + "/" + employeeId, Employee.class);
    }
}
