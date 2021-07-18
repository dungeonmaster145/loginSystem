package com.example.loginSystem.Employees;

import com.example.loginSystem.Employees.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {


}
