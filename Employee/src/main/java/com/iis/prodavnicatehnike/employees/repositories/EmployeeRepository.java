package com.iis.prodavnicatehnike.employees.repositories;

import com.iis.prodavnicatehnike.employees.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}