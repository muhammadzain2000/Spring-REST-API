package com.springboot.first.project.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.first.project.model.Employee;
import com.springboot.first.project.service.EmployeeService;

@RestController
@RequestMapping("/api/employees/")
public class EmployeeController {

	private EmployeeService employeeService;

	public EmployeeController(EmployeeService employeeService) {
		super();
		this.employeeService = employeeService;
	}

	// create employee REST API
	@PostMapping("create")
	public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee) {
	
		return new ResponseEntity<Employee>(employeeService.savaEmployee(employee), HttpStatus.CREATED);

	}
	
	// get all employees REST API
	@GetMapping("getAll")
	public List<Employee> getAllEmployees(){
		return employeeService.getAllEmployees();
	}
	
	// get employee by id
	@GetMapping("{id}")
	public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
		return new ResponseEntity<Employee>(employeeService.getEmployeeById(id), HttpStatus.OK);
		
	}
	
	// update employee
	@PutMapping("{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long id,@RequestBody Employee employee){
		
		return new ResponseEntity<Employee>(employeeService.updateEmployee(employee, id), HttpStatus.OK);
		
	}
	
	//delete employee
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long id){
		employeeService.deleteEmployee(id);
		return new ResponseEntity<String>("Employee deletede successfully", HttpStatus.OK);
	}

}
