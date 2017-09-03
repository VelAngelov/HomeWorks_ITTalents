package task_employee_plus_others;

import java.util.Random;
import java.util.TreeSet;

public class Demo {
	public static final String[] NAMES = { "Petyr", "Ivan", "Krasi", "Sasho", "Mariq", "Desislava", "Greta",
			"Konstantina", "Elena" };

	public static void main(String[] args) {
		Company itt = new Company("Talants it");
		for (int i = 0; i < 50; i++) {
			itt.addEmployee(Company.ALLOWED_DEPL[new Random().nextInt(Company.ALLOWED_DEPL.length)],
					new Employee(NAMES[new Random().nextInt(NAMES.length)], 21 + new Random().nextInt(10),
							800 + new Random().nextInt(2000)));
		}
		System.out.println("~~~~~~~~EMPLOYEES BY AGE~~~~~~~~~~~~");
		itt.printEmployeesByAge();
		System.out.println("~~~~~~~~EMPLOYEES BY NAME~~~~~~~~~~~~");
		itt.printEmployeesByName();
		System.out.println("~~~~~~~~EMPLOYEES BY SALARY~~~~~~~~~~~~");
		itt.printEmployeesBySalary();

		System.out.println("-------");
		// all by name:
		TreeSet<Employee> set = itt.getAllEmployeesByName();
		for (Employee e : set) {
			System.out.println(e);
		}
		// all by name age without duplicates:
		System.out.println("~~~~~~~~~~~~~~~");
		TreeSet<Employee> set2 = itt.getAllEmployeesByNameAndRemoveDuplicates();
		for (Employee e : set2) {
			System.out.println(e);
		}
	}
}
