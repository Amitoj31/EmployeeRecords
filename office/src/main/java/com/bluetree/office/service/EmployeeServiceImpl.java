package com.bluetree.office.service;

import com.bluetree.office.exception.EmployeeAlreadyExistingException;
import com.bluetree.office.exception.EmployeeNotFoundException;
import com.bluetree.office.model.Employee;
import com.bluetree.office.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{
    private EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository=employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }

    @Override
    public Employee addEmployee(Employee employee) throws EmployeeAlreadyExistingException {
        if(employeeRepository.findById(employee.getId()).isPresent()) {
            throw new EmployeeAlreadyExistingException();
        }
        else {
            return employeeRepository.save(employee);
        }
    }

    @Override
    public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
        if(employeeRepository.findById(employee.getId()).isPresent()) {
            return employeeRepository.save(employee);

        }
        else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        if(employeeRepository.findById(id).isPresent()) {
             employeeRepository.deleteById(id);

        }
        else {
            throw new EmployeeNotFoundException();
        }
    }

    @Override
    public Employee getEmployById(int id) throws EmployeeNotFoundException {
        if(employeeRepository.findById(id).isPresent()) {
            return employeeRepository.findById(id).get();

        }
        else {
            throw new EmployeeNotFoundException();
        }
    }
}
