package com.practice.backend.com.practiceAppBackend.services;

import com.practice.backend.com.practiceAppBackend.entities.Employee;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface EmployeeServiceInterface {
    public Employee create(Employee employee);

    public Optional<Employee> getEmployeeById(Long id);

    public List<Employee> getAllEmployees();

    public Employee updateEmployee(Long id, Employee employee);

    public String deleteEmployee(Long id);
}
