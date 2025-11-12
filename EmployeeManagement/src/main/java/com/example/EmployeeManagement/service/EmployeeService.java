package com.example.EmployeeManagement.service;

import com.example.EmployeeManagement.exception.EmployeeNotFoundException;
import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class EmployeeService {
    private final EmployeeRepository repository;

    public EmployeeService(EmployeeRepository repository){
        this.repository = repository;
    }

    // CRUD
    // Create
    // Read
    // Update
    // Delete

    // CREATE: Creates and Adds new Employee to H2 DB
    public Employee addEmployee(Employee newEmployee){
        return repository.save(newEmployee); // .save adds to H2 DB and auto-gens id
    }

    // READ ALL: Returns all the Employee Entities in the DB
    public List<Employee> getAllEmployees(){
        return repository.findAll();
    }

    // READ BY ID: Returns Employee by ID
    public Employee getEmployeeByID(int id){
        Optional<Employee> employee = repository.findById(id); // Optional <T> may or may not contain a non-null value of type T
        return employee.orElseThrow(() -> new EmployeeNotFoundException("Employee not found with ID:" + id)); // Returns the person or throws exception
        // Need to use the lambda function as the .orElseThrow() does not accept a straight exception as parameter needs a Supplier, thus lambda
        // Also if no lambda the exception is always generated straight away even if the employee exists
    }

    // UPDATE BY ID: Updates and Employee based on ID
    public Employee updateEmployee(int id, Employee updatedEmployee){
        if(repository.existsById(id)){
            updatedEmployee.setId(id);
            return repository.save(updatedEmployee);
        } else {
            // Throw exception
            throw new EmployeeNotFoundException("Cannot update: Employee not found with ID: " + id);
        }
    }

    // DELETE
    public boolean deletePerson(int id){
        if(repository.existsById(id)){
            repository.deleteById(id);
            return true;
        } else {
            // Throw exception
            throw new EmployeeNotFoundException("Cannot delete: Employee not found with ID: " + id);
        }
    }


}
