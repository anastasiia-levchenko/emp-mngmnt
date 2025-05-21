package com.employee.management.emp_mngmt.exceptions;

public class EmployeeAlreadyExistsException extends RuntimeException
{
	public EmployeeAlreadyExistsException(final String message)
	{
		super(message);
	}
}
