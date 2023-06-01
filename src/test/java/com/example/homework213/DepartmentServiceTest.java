package com.example.homework213;

import com.example.homework213.Servieses.DepartmentService;
import com.example.homework213.Servieses.EmployeeService;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import java.util.NoSuchElementException;
import static com.example.homework213.Constants.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class DepartmentServiceTest {
	private final EmployeeService repositoryMock = mock(EmployeeService.class);
	private DepartmentService out;

	@BeforeEach
	public void initOut() {
		out = new DepartmentService(repositoryMock);
	}

	@BeforeEach
	public void initRepositoryMock(){
		when(repositoryMock.allEmployees()).thenReturn(EMPLOYEE_LIST);
	}

	@Test
	public void shouldReturnEmployeeWithMaxSalary() {
		Assertions.assertEquals(EMPL2,out.getEmployeeWithMaxSalaryFromDepartment(DEPARTMENT1));
	}
	@Test
	public void shouldReturnEmployeeWithMinSalary() {
		Assertions.assertEquals(EMPL4,out.getEmployeeWithMinSalaryFromDepartment(DEPARTMENT2));
	}
	@Test
	public void shouldReturnSumSalariesFromDepartment() {
		Assertions.assertEquals(SALARYEMPL1+SALARYEMPL2,out.getSumEmployeesSalaryFromDepartment(DEPARTMENT1));
	}
	@Test
	public void shouldReturnEmployeesFromDepartment() {
		Assertions.assertEquals(EMPL_LIST_FIRST_DEP,out.getAllEmployeeFromDepartment(DEPARTMENT1));
	}

	@Test
	public void shouldReturnAllEmployees(){
		Assertions.assertEquals(EMPLOYEE_MAP,out.getAllEmployeesFromAllDepartments());
	}

	@Test
	public void shouldReturnEmptyListWhenDepartmentNotExist(){
		Assertions.assertEquals(EMPTY_LIST,out.getAllEmployeeFromDepartment(3));
	}

	@Test
	public void shouldReturn0WhenDepartmentListIsEmpty(){
		when(repositoryMock.allEmployees()).thenReturn(EMPTY_LIST);
		Assertions.assertEquals(0,out.getSumEmployeesSalaryFromDepartment(DEPARTMENT1));
	}
	@Test
	public void shouldReturnNoSuchElementExceptionWhenDepartmentListIsEmpty(){
		when(repositoryMock.allEmployees()).thenReturn(EMPTY_LIST);
		Assertions.assertThrowsExactly(NoSuchElementException.class, () -> out.getEmployeeWithMaxSalaryFromDepartment(DEPARTMENT1));
		Assertions.assertThrowsExactly(NoSuchElementException.class, () -> out.getEmployeeWithMinSalaryFromDepartment(DEPARTMENT1));

	}

}

