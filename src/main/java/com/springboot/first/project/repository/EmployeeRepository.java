package com.springboot.first.project.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.springboot.first.project.model.Employee;
import org.springframework.data.repository.query.Param;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	
	@Query(value = "select * from employees es where es.first_name=:firstname or es.last_name=:lastname and first_name not in ('') and last_name not in ('')", nativeQuery = true)
	List<Employee> findAllByFirstNameAndLastName(@Param(value = "firstname")String firstname, @Param(value = "lastname")String lastname);


}
