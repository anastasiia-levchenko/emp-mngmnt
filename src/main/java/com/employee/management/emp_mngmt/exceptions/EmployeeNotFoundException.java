package com.employee.management.emp_mngmt.exceptions;

public class EmployeeNotFoundException  extends RuntimeException
{
	public EmployeeNotFoundException(final String message)
	{
		super(message);
	}
}
