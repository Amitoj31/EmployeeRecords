package com.bluetree.office.controller;

import com.bluetree.office.exception.EmployeeAlreadyExistingException;
import com.bluetree.office.exception.EmployeeNotFoundException;
import com.bluetree.office.model.Employee;
import com.bluetree.office.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@CrossOrigin("*")
@RestController
@RequestMapping("/employee/v1")
public class EmployeeController {

    private EmployeeService employeeService;
    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService=employeeService;
    }

    @GetMapping("/emp")
    public ResponseEntity<?> getAllEmployeeRecords() {
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }
    @PostMapping("/emp")
    public ResponseEntity<?> addEmployeeRecord(@RequestBody Employee employee) throws EmployeeAlreadyExistingException {
        return new ResponseEntity<>(employeeService.addEmployee(employee), HttpStatus.OK);
    }
    @PutMapping("/emp")
    public ResponseEntity<?> updateEmployeeRecord(@RequestBody Employee employee) throws EmployeeNotFoundException {
        return new ResponseEntity<>(employeeService.updateEmployee(employee), HttpStatus.OK);
    }
    @DeleteMapping("/emp/{id}")
    public ResponseEntity<?> deleteEmployeeRecord(@PathVariable int id) throws EmployeeNotFoundException {
    Employee e=this.employeeService.getEmployById(id);
        employeeService.deleteEmployee(id);
        return new ResponseEntity<>(e, HttpStatus.OK);
    }

}
