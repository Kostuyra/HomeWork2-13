package com.example.homework213.controllers;

import com.example.homework213.Servieses.DepartmentServiceInterface;
import com.example.homework213.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/department")
public class DepartmentController {
	private final DepartmentServiceInterface departmentServiceInterface;

	public DepartmentController(DepartmentServiceInterface departmentServiceInterface) {
		this.departmentServiceInterface = departmentServiceInterface;
	}

	@GetMapping("/{departmentId}/salary/max")
	Employee getEmployeeWithMaxSalaryFromPartOffice(@PathVariable int departmentId) {
		return departmentServiceInterface.getEmployeeWithMaxSalaryFromDepartment(departmentId);
	}

	@GetMapping("/{departmentId}/salary/min")
	Employee getEmployeeWithMinSalaryFromPartOffice(@PathVariable int departmentId) {
		return departmentServiceInterface.getEmployeeWithMinSalaryFromDepartment(departmentId);
	}
	@GetMapping("/{departmentId}/salary/sum")
	 Double getSumEmployeesSalaryFromPartOffice(@PathVariable int departmentId) {
		return departmentServiceInterface.getSumEmployeesSalaryFromDepartment(departmentId);
	}

	@GetMapping("/{departmentId}/employees")
	List<Employee> getAllEmployeeFromPartOffice(@PathVariable int departmentId) {
		return departmentServiceInterface.getAllEmployeeFromDepartment(departmentId);
	}

	@GetMapping("/employees")
	Map<Integer, List<Employee>> getAllEmployeesFromAllPartOffice() {
		return departmentServiceInterface.getAllEmployeesFromAllDepartments();
	}


}
