package com.springboot.first.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.springboot.first.project.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
