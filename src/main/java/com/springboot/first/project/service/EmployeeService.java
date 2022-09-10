package com.springboot.first.project.service;

import java.util.List;

import com.springboot.first.project.model.Employee;


public interface EmployeeService {
	Employee savaEmployee(Employee employee);
	List<Employee> getAllEmployees();
	Employee getEmployeeById(Long id);
	Employee updateEmployee(Employee employee, Long id);
	void deleteEmployee(Long id);
}
