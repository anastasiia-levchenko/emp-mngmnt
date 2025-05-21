package com.employee.management.emp_mngmt.services;

import com.employee.management.emp_mngmt.models.Employee;

import java.util.List;


public interface EmployeeService
{
	Employee addEmployee(final Employee employee);

	List<Employee> getEmployees();

	Employee getEmployeeById(final Long id);

	Employee updateEmployee(final Employee employee, final Long id);

	void deleteEmployee(final Long id);
}
