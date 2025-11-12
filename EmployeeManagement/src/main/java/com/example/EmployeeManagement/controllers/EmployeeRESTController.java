package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // This class returns a raw json object
@RequestMapping("/api/employees") // Base path for all employee endpoints
public class EmployeeRESTController {

    private final EmployeeService ps;

    // Constructor Injection
    public EmployeeRESTController(EmployeeService ps) {
        this.ps = ps;
    }

    // CREATE: Deals with POST to /api/employees ---
    @PostMapping
    public ResponseEntity<Employee> createEmployee(@Valid @RequestBody Employee newEmployee) {
        Employee employee = ps.addEmployee(newEmployee);
        // Return 201 Created status and the new employee object
        return new ResponseEntity<>(employee, HttpStatus.CREATED);
    }

    // READ All: GET /api/employees ---
    @GetMapping
    public List<Employee> getAllEmployees() {
        return ps.getAllEmployees(); // Returns all employees as JSON
    }

    // READ by ID: GET /api/employees/{id} ---
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable int id) {
        Employee employee = ps.getEmployeeByID(id);
        if (employee != null) {
            // Found: Return 200 OK
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            // Not Found: Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // UPDATE: PUT /api/employees/{id} ---
    @PutMapping("/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable int id, @Valid @RequestBody Employee updatedEmployee) {
        Employee employee = ps.updateEmployee(id, updatedEmployee);
        if (employee != null) {
            // Found and Updated: Return 200 OK
            return new ResponseEntity<>(employee, HttpStatus.OK);
        } else {
            // Not Found: Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // DELETE: DELETE /api/employees/{id} ---
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable int id) {
        boolean wasDeleted = ps.deletePerson(id);
        if (wasDeleted) {
            // Deleted successfully: Return 204 No Content
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            // Not Found: Return 404 Not Found
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Home Endpoint to check that the application is running
    @GetMapping(path = "/home")
    public String home(){
        return "Employee Management System API is running.";
    }
}
