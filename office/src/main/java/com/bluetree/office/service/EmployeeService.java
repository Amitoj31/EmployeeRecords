package com.bluetree.office.service;

import com.bluetree.office.exception.EmployeeAlreadyExistingException;
import com.bluetree.office.exception.EmployeeNotFoundException;
import com.bluetree.office.model.Employee;

import java.util.List;

public interface EmployeeService {
    public List<Employee> getAllEmployee();
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistingException;
    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException;
    public void deleteEmployee(int id) throws EmployeeNotFoundException;
    public Employee getEmployById(int id) throws EmployeeNotFoundException;
}
