package com.example.homework213.Servieses;

import com.example.homework213.Employee;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class DepartmentService implements DepartmentServiceInterface {
	private final EmployeeService employees;

	public DepartmentService(EmployeeService employees) {
		this.employees = employees;
	}

	@Override
	public Employee getEmployeeWithMaxSalaryFromDepartment(int departmentId) {
		return employees.allEmployees().stream().
				filter(e -> e.getPartOffice() == departmentId).
				max(Comparator.comparingDouble(Employee::getSalary))
				.get();

	}

	@Override
	public Employee getEmployeeWithMinSalaryFromDepartment(int departmentId) {
		return employees.allEmployees().stream().
				filter(e -> e.getPartOffice() == departmentId).
				min(Comparator.comparingDouble(Employee::getSalary))
				.get();

	}

	public Double getSumEmployeesSalaryFromDepartment(int departmentId) {
		return employees.allEmployees().stream().filter(e -> e.getPartOffice() == departmentId).
				mapToDouble(i -> i.getSalary())
				.sum();
	}

	@Override
	public List<Employee> getAllEmployeeFromDepartment(int departmentId) {
		return employees.allEmployees().stream().filter(e -> e.getPartOffice() == departmentId)
				.collect(Collectors.toList());
	}

	@Override
	public Map<Integer, List<Employee>> getAllEmployeesFromAllDepartments() {
		return employees.allEmployees().stream().
				collect(Collectors.groupingBy(Employee::getPartOffice));
	}

}
