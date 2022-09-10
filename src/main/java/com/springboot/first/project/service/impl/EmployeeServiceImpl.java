package com.springboot.first.project.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.springboot.first.project.exception.ResourceNotFoundException;
import com.springboot.first.project.model.Employee;
import com.springboot.first.project.repository.EmployeeRepository;
import com.springboot.first.project.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	private EmployeeRepository employeeRepository;

	public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
		super();
		this.employeeRepository = employeeRepository;
	}

	@Override
	public Employee savaEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> getAllEmployees() {
		return employeeRepository.findAll();
	}

	@Override
	public Employee getEmployeeById(Long id) {
//		Optional<Employee> employee = employeeRepository.findById(id);
//		if (employee.isPresent()) {
//			return employee.get();
//		} else {
//			throw new ResourceNotFoundException("Employee", "ID", id);
//		}
		
		//lambda expression
		return employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
	}

	@Override
	public Employee updateEmployee(Employee employee, Long id) {
		// we need to check whether employee with given id exist in db
		Employee existingEmployee = employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));
		existingEmployee.setFirstName(employee.getFirstName());
		existingEmployee.setLastName(employee.getLastName());
		existingEmployee.setEmail(employee.getEmail());
		employeeRepository.save(existingEmployee);
		return existingEmployee;
	}

	@Override
	public void deleteEmployee(Long id) {
		
		//check whether employee exist in db or not
		employeeRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Employee", "id", id));

		employeeRepository.deleteById(id);
	}

}
