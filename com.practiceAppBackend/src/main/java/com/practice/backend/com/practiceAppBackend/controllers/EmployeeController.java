package com.practice.backend.com.practiceAppBackend.controllers;

import com.practice.backend.com.practiceAppBackend.entities.Employee;
import com.practice.backend.com.practiceAppBackend.services.EmployeeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    private EmployeeServiceInterface employeeServiceInterface;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    ResponseEntity<?> create(@RequestBody Employee employee) {
        return new ResponseEntity<>(this.employeeServiceInterface.create(employee), HttpStatus.CREATED);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/find")
    public ResponseEntity<?> getEmployeeById(@RequestParam("id") Long id) {
        Optional<Employee> result = this.employeeServiceInterface.getEmployeeById(id);
        if (result.isEmpty()) {
            return new ResponseEntity<>("Employee NOT FOUND!", HttpStatus.NOT_FOUND);
        } else {
            return new ResponseEntity<>(result.get(), HttpStatus.FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/findAll")
    public ResponseEntity<?> getAllEmployees() {
        return new ResponseEntity<>(this.employeeServiceInterface.getAllEmployees(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/update")
    public ResponseEntity<?> updateEmployee(@RequestParam("id") Long id, @RequestBody Employee employee) {
        return new ResponseEntity<>(this.employeeServiceInterface.updateEmployee(id, employee), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<?> deleteEmployee(@RequestParam("id") Long id) {
        return new ResponseEntity<>(this.employeeServiceInterface.deleteEmployee(id), HttpStatus.OK);
    }
}
