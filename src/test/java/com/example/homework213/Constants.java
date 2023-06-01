package com.example.homework213;

import java.util.List;
import java.util.Map;

public class Constants {

	public static final String FIRSTNAMEEMPL1 = "Petrov";
	public static final String FIRSTNAMEEMPL2 = "Sidorov";
	public static final String FIRSTNAMEEMPL3 = "Kozlov";
	public static final String FIRSTNAMEEMPL4 = "Ignatov";
	public static final String LASTNAMEEMPL1 = "Vasiliy";
	public static final String LASTNAMEEMPL2 = "Petr";
	public static final String LASTNAMEEMPL3 = "Viktor";
	public static final String LASTNAMEEMPL4 = "Alexandr";
	public static final double SALARYEMPL1 = 20000.0;
	public static final double SALARYEMPL2 = 50000.0;
	public static final double SALARYEMPL3 = 40000.0;
	public static final double SALARYEMPL4 = 30000.0;
	public static final int DEPARTMENT1 = 1;
	public static final int DEPARTMENT2 = 2;
	public static final Employee EMPL1 = new Employee(FIRSTNAMEEMPL1, LASTNAMEEMPL1, DEPARTMENT1, SALARYEMPL1);

	public static final Employee EMPL2 = new Employee(FIRSTNAMEEMPL2, LASTNAMEEMPL2, DEPARTMENT1, SALARYEMPL2);
	public static final Employee EMPL3 = new Employee(FIRSTNAMEEMPL3, LASTNAMEEMPL3, DEPARTMENT2, SALARYEMPL3);
	public static final Employee EMPL4 = new Employee(FIRSTNAMEEMPL4, LASTNAMEEMPL4, DEPARTMENT2, SALARYEMPL4);
	public static final List<Employee> EMPTY_LIST = List.of();
	public static final List<Employee> EMPLOYEE_LIST = List.of(EMPL1,EMPL2,EMPL3,EMPL4);
	public static final List<Employee> EMPL_LIST_FIRST_DEP = List.of(EMPL1,EMPL2);
	public static final List<Employee> EMPL_LIST_SECOND_DEP = List.of(EMPL3,EMPL4);
	public static final Map<Integer, List<Employee>> EMPLOYEE_MAP = Map.of(
			DEPARTMENT1, EMPL_LIST_FIRST_DEP,
			DEPARTMENT2, EMPL_LIST_SECOND_DEP);





}
