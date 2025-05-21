package com.employee.management.emp_mngmt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;


@RestControllerAdvice
public class CustomExceptionHandler
{

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleException(final MethodArgumentNotValidException ex)
	{
		final Map<String, String> errors = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(error -> errors.put(error.getField(), error.getDefaultMessage()));
		return errors;
	}

	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(EmployeeNotFoundException.class)
	public Map<String, String> employeeNotFound(final EmployeeNotFoundException ex)
	{
		final Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}

	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(EmployeeAlreadyExistsException.class)
	public Map<String, String> employeeNotFound(final EmployeeAlreadyExistsException ex)
	{
		final Map<String, String> error = new HashMap<>();
		error.put("error", ex.getMessage());
		return error;
	}
}