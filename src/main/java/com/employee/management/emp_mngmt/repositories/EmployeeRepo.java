package com.employee.management.emp_mngmt.repositories;

import com.employee.management.emp_mngmt.models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;



public interface EmployeeRepo extends JpaRepository<Employee, Long>
{
	Optional<Employee> findByEmail(final String email);
}
