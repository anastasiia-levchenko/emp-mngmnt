package com.employee.management.emp_mngmt.services.impl;

import com.employee.management.emp_mngmt.exceptions.EmployeeAlreadyExistsException;
import com.employee.management.emp_mngmt.exceptions.EmployeeNotFoundException;
import com.employee.management.emp_mngmt.models.Employee;
import com.employee.management.emp_mngmt.repositories.EmployeeRepo;
import com.employee.management.emp_mngmt.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService
{
	private final EmployeeRepo employeeRepo;

	@Override
	public Employee addEmployee(final Employee employee)
	{
		final String employeeEmail = employee.getEmail();
		if (employeeExists(employeeEmail))
		{
			throw new EmployeeAlreadyExistsException(employeeEmail + " employee already exists");
		}

		return employeeRepo.save(employee);
	}

	@Override
	public List<Employee> getEmployees()
	{
		return employeeRepo.findAll();
	}

	@Override
	public Employee getEmployeeById(final Long id)
	{
		return employeeRepo.findById(id).orElseThrow(
				() -> new EmployeeNotFoundException(String.format("The employee with the id %s could not be found", id)));
	}

	@Override
	public Employee updateEmployee(final Employee employee, final Long id)
	{
		return employeeRepo.findById(id).map(dbEmp -> {
			dbEmp.setFirstName(employee.getFirstName());
			dbEmp.setLastName(employee.getLastName());
			dbEmp.setEmail(employee.getEmail());
			dbEmp.setDepartment(employee.getDepartment());

			return employeeRepo.save(dbEmp);
		}).orElseThrow(() -> new EmployeeNotFoundException("The employee could not be found"));
	}

	@Override
	public void deleteEmployee(final Long id)
	{
		if (!employeeRepo.existsById(id))
		{
			throw new EmployeeNotFoundException("The employee could not be found");
		}
		employeeRepo.deleteById(id);
	}

	private boolean employeeExists(final String email)
	{
		return employeeRepo.findByEmail(email).isPresent();
	}
}
