package com.practice.backend.com.practiceAppBackend.repositories;

import com.practice.backend.com.practiceAppBackend.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
