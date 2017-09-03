package task_employee_plus_others;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.TreeSet;

public class Company {
	/*
	 * Write a program that fills Employee objects into a Company. The company
	 * has a name and a collection of Employees separated in different
	 * departments.Write a demo that creates the company and adds employees into
	 * different departments. Then list all employees that the company has. The
	 * output of the program should be a list of departments and a sublist of
	 * employees for each department.
	 * 
	 * Departments are known by their name only.
	 */
	private String name;
	private HashMap<String, ArrayList<Employee>> employees;
	public static final String[] ALLOWED_DEPL = { "mathematics", "software developer", "software architects",
			"mashine leanring engineers" };

	public Company(String name) {
		this.name = name;
		employees = new HashMap<String, ArrayList<Employee>>();
	}

	public boolean addEmployee(String dep, Employee e) {
		dep = dep.toLowerCase();
		if (employees.containsKey(dep)) {
			employees.get(dep).add(e);
			return true;
		}
		for (String s : ALLOWED_DEPL) {
			if (dep.equals(s)) {
				employees.put(dep, new ArrayList<Employee>());
				employees.get(dep).add(e);
				return true;
			}
		}
		return false;
	}

	private void sorteByComparator(Comparator<Employee> comparator) {
		for (String key : employees.keySet()) {
			Collections.sort(employees.get(key), comparator);
		}
	}

	public void printEmployees() {
		for (String key : employees.keySet()) {
			System.out.println("===========" + key + "===========");
			ArrayList<Employee> list = employees.get(key);
			for (Employee e : list) {
				System.out.println(e);
			}
		}
	}

	public void printEmployeesByName() {
		sorteByComparator(Employee.COMPARATOR_BY_NAME);
		printEmployees();
	}

	public void printEmployeesByAge() {
		sorteByComparator(Employee.COMPARATOR_BY_AGE);
		printEmployees();
	}

	public void printEmployeesBySalary() {
		sorteByComparator(Employee.COMPARATOR_BY_SALARY);
		printEmployees();
	}

	public String getName() {
		return name;
	}

	public TreeSet<Employee> getAllEmployeesByName() {
		TreeSet<Employee> allByName = new TreeSet<>(Employee.COMPARATOR_BY_NAME);
		for (ArrayList<Employee> list : employees.values()) {
			allByName.addAll(list);
		}
		return allByName;
	}

	public TreeSet<Employee> getAllEmployeesByNameAndRemoveDuplicates() {
		TreeSet<Employee> allByName = new TreeSet<>(Employee.COMPARATOR_BY_NAME_AGE);
		for (ArrayList<Employee> list : employees.values()) {
			allByName.addAll(list);
		}
		return allByName;
	}

}
