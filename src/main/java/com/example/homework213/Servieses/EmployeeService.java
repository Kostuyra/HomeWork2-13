package com.example.homework213.Servieses;

import com.example.homework213.Employee;
import com.example.homework213.exception.EmployeeAlreadyAddedException;
import com.example.homework213.exception.EmployeeNotFoundException;
import com.example.homework213.exception.EmployeeStorageIsFullException;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Service
public class EmployeeService implements EmployeeServiceInterface {
	private final List<Employee> employees;
	private static final int countEmployees = 10;

	public EmployeeService() {
		this.employees = new ArrayList<>();
	}

	@Override
	public Employee addEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		checkSizeArray();
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (checkExistEmployee(employee)) {
			throw new EmployeeAlreadyAddedException(employee);
		}
		employees.add(employee);
		return employee;
	}

	@Override
	public Employee removeEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		employees.remove(employee);
		return employee;
	}

	@Override
	public Employee findEmployee(String firstName, String lastName, Integer partOffice, Double salary) {
		Employee employee = new Employee(firstName, lastName, partOffice, salary);
		if (!checkExistEmployee(employee)) {
			throw new EmployeeNotFoundException(employee);
		}
		return employee;
	}

	@Override
	public List<Employee> allEmployees() {
		return employees;
	}

	private boolean checkExistEmployee(Employee employee) {
		return employees.contains(employee);
	}

	private void checkSizeArray() {
		if (employees.size() == countEmployees) {
			throw new EmployeeStorageIsFullException();
		}
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		EmployeeService that = (EmployeeService) o;
		return Objects.equals(employees, that.employees);
	}

	@Override
	public int hashCode() {
		return Objects.hash(employees);
	}
}



