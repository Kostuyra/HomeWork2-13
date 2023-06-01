package com.example.homework213.Servieses;

import com.example.homework213.Employee;

import java.util.List;
import java.util.Map;

public interface DepartmentServiceInterface {
	Employee getEmployeeWithMaxSalaryFromDepartment(int departmentId);
	Employee getEmployeeWithMinSalaryFromDepartment(int departmentId);

	Double getSumEmployeesSalaryFromDepartment(int departmentId);
	List<Employee> getAllEmployeeFromDepartment(int departmentId);
	Map<Integer,List<Employee>> getAllEmployeesFromAllDepartments();
}
