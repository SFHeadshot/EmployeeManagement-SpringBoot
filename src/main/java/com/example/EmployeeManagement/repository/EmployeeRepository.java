package com.example.EmployeeManagement.repository;

import com.example.EmployeeManagement.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
// This extends JpaRepository, inheriting all CRUD methods (save, findById, findAll, deleteById, etc.)
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
// The <Person, Integer> means: "This repository manages the Person Entity, and its primary key (ID) is an Integer."
// Spring Data JPA automatically provides basic CRUD operations automatically.
}
