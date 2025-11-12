package com.example.EmployeeManagement.controllers;

import com.example.EmployeeManagement.model.Employee;
import com.example.EmployeeManagement.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import java.util.List;

@Controller // This class returns the name of a view(HTML) we want
@RequestMapping("/app/employees")
public class EmployeeWebController {
    private final EmployeeService ps; 
    
    // Constructor Injection
    public EmployeeWebController(EmployeeService ps){
        this.ps = ps;
    }

    // CRUD

    // READ ALL : Returns the employee-List view which shows all employees
    @GetMapping()
    public String listEmployees(Model model){

        // Fetching Data from Service Layer
        List<Employee> employees = ps.getAllEmployees();

        // Adding Data to Model Object
        model.addAttribute("employeeList", employees);

        // Return the name of the HTML template to use
        return "employee-list";
    }

    // CREATE Showing Form : GET REQUEST
    @GetMapping("/add")
    public String addEmployee(Employee employee, Model model){

        // Adding an empty Employee Object to the form
        model.addAttribute("employee", employee);

        // Return the name of the HTML template to use
        return "add-employee-form";
    }

    // CREATE Processing Form: POST REQUEST
    @PostMapping("/add")
    public String addEmployee(@Valid Employee employee,  BindingResult result){
        // Binding Result checks to see if any validation errors occured or not
        if(result.hasErrors()){
            return "add-employee-form"; // Takes back to add employee form if error occured
        } else {
            ps.addEmployee(employee); // Adds employee to DB
            return "redirect:/app/employees"; // Redirects to home for employees
        }
    }

    // UPDATE: Show Edit Form: GET
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable int id, Model model){
        Employee employee = ps.getEmployeeByID(id);

        if(employee == null){
            return "redirect:/app/employees";
        } else {
            model.addAttribute("employee", employee);
            return "edit-employee-form";
        }
    }

    // UPDATE: Processing the update
    @PostMapping("/update/{id}")
    public String updateEmployee(@PathVariable int id, @Valid Employee employee, BindingResult result) {
        if (result.hasErrors()) {
            employee.setId(id); // Keep the ID in the object for the template to re-render
            return "edit-employee-form";
        } else {
            ps.updateEmployee(id, employee);
            return "redirect:/app/employees";
        }
    }

    // DELETE: Deleting by ID
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable int id){
        ps.deletePerson(id);
        return "redirect:/app/employees";
    }


}
