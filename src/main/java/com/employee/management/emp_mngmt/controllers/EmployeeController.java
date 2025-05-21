package com.employee.management.emp_mngmt.controllers;

import com.employee.management.emp_mngmt.models.Employee;
import com.employee.management.emp_mngmt.services.EmployeeService;
import lombok.RequiredArgsConstructor;
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

import java.util.List;


@RestController
@RequestMapping("/employees")
@RequiredArgsConstructor
public class EmployeeController
{
	private final EmployeeService employeeService;

	@GetMapping
	public ResponseEntity<List<Employee>> getEmployees()
	{
		return new ResponseEntity<>(employeeService.getEmployees(), HttpStatus.FOUND);
	}

	@PostMapping
	public Employee addEmployee(@RequestBody final Employee employee)
	{
		return employeeService.addEmployee(employee);
	}

	@PutMapping("/update/{id}")
	public Employee updateEmployee(@RequestBody final Employee employee, @PathVariable final Long id)
	{
		return employeeService.updateEmployee(employee, id);
	}

	@DeleteMapping("/delete/{id}")
	public void deleteEmployee(@PathVariable final Long id)
	{
		employeeService.deleteEmployee(id);
	}

	@GetMapping("/employee/{id}")
	public Employee getEmployeeById(@PathVariable final Long id)
	{
		return employeeService.getEmployeeById(id);
	}
}