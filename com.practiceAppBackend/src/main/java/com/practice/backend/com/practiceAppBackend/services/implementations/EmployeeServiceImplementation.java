package com.practice.backend.com.practiceAppBackend.services.implementations;

import com.practice.backend.com.practiceAppBackend.entities.Employee;
import com.practice.backend.com.practiceAppBackend.repositories.EmployeeRepository;
import com.practice.backend.com.practiceAppBackend.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImplementation implements EmployeeServiceInterface {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Employee create(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public Optional<Employee> getEmployeeById(Long id) {
        return this.employeeRepository.findById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee updateEmployee(Long id, Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findById(id);

        if (existingEmployee.isEmpty())
            return null;

        Employee foundEmployee = existingEmployee.get();

        if (employee.getName() != null)
            foundEmployee.setName(employee.getName());

        if (employee.getEmail() != null)
            foundEmployee.setEmail(employee.getEmail());

        if (employee.getPassword() != null)
            foundEmployee.setPassword(employee.getPassword());

        if (employee.getSalary() != null)
            foundEmployee.setSalary(employee.getSalary());

        return employeeRepository.save(foundEmployee);
    }

    @Override
    public String deleteEmployee(Long id) {
        Optional<Employee> searchResult = employeeRepository.findById(id);
        if (searchResult.isEmpty())
            return "User doesn't exist!";

        employeeRepository.deleteById(id);
        return "User deleted successfully";
    }
}
