package com.example.homework213;

import com.example.homework213.Servieses.EmployeeService;
import com.example.homework213.exception.*;
import static com.example.homework213.Constants.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class EmployeeServiceTest {

	private final EmployeeService out = new EmployeeService();

	@BeforeEach
	public void createEmployeeService() {
		out.addEmployee(FIRSTNAMEEMPL1, LASTNAMEEMPL1, DEPARTMENT1, SALARYEMPL1);
		out.addEmployee(FIRSTNAMEEMPL2, LASTNAMEEMPL2, DEPARTMENT1, SALARYEMPL2);
		out.addEmployee(FIRSTNAMEEMPL3, LASTNAMEEMPL3, DEPARTMENT2, SALARYEMPL3);
		out.addEmployee(FIRSTNAMEEMPL4, LASTNAMEEMPL4, DEPARTMENT2, SALARYEMPL4);
		out.addEmployee("Malahov", "Dmitry", 3, 22000.0);
		out.addEmployee("Kotov", "Mark", 3, 34000.0);
		out.addEmployee("Mikhaylov", "Ivan", 4, 42000.0);
		out.addEmployee("Stasov", "Alexey", 4, 52000.0);
		out.addEmployee("Molokov", "Vladimir", 5, 37000.0);
	}

	@Test
	public void shouldThrowStorageIsFullException() {
		out.addEmployee("Petrenko", "Viktor", 5, 33000.0);
		Assertions.assertThrows(EmployeeStorageIsFullException.class, () -> out.addEmployee("Lidov", "Artem", 5, 60000.0));
	}

	@Test
	public void shouldThrowAlreadyAddedException() {
		Assertions.assertThrows(EmployeeAlreadyAddedException.class, () -> out.addEmployee("Malahov", "Dmitry", 3, 22000.0));
	}

	@Test
	public void shouldThrowNotFoundException() {
		Assertions.assertThrows(EmployeeNotFoundException.class, () -> out.removeEmployee("Malahin", "Dmitry", 3, 22000.0));
	}

	@Test
	public void shouldReturnFoundEmployee() {
		Employee testEmployee = new Employee("Kotov", "Mark", 3, 34000.0);
		Assertions.assertEquals(testEmployee, out.findEmployee("Kotov", "Mark", 3, 34000.0));
	}
	@Test
	public void shouldReturnRemovedEmployee(){
		Employee testEmployee = new Employee("Kotov", "Mark", 3, 34000.0);
		Assertions.assertEquals(testEmployee, out.removeEmployee("Kotov", "Mark", 3, 34000.0));
	}

}
