package task_employee_plus_others;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

public class Employee {
	/*
	 * Each employee has name, age, salary and an ID number.
	 */
	private String name;
	private int age;
	private double salary;
	private static int idCounter;
	private int id;
	private Queue<Integer> salaries;
	public static final Comparator<Employee> COMPARATOR_BY_NAME = (o1, o2) -> {
		int result = o1.name.compareTo(o2.name);
		if (result == 0) {
			result = o1.id - o2.id;
		}
		return result;
	};
	public static final Comparator<Employee> COMPARATOR_BY_NAME_AGE = (o1, o2) -> {
		int result = o1.name.compareTo(o2.name);
		if (result == 0) {
			result = o1.age - o2.age;
		}
		return result;
	};
	public static final Comparator<Employee> COMPARATOR_BY_AGE = (o1, o2) -> {
		int result = o1.age - o2.age;
		if (result == 0) {
			result = o1.id - o2.id;
		}
		return result;
	};
	public static final Comparator<Employee> COMPARATOR_BY_SALARY = (o1, o2) -> {
		int result = (int) ((o1.salary - o2.salary) * 100);
		if (result == 0) {
			result = o1.id - o2.id;
		}
		return result;
	};

	public Employee(String name, int age, double salary) {
		this.id = ++idCounter;
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.salaries = new LinkedList<Integer>();
	}

	@Override
	public String toString() {
		return name + ", age=" + age + ", salary=" + salary;
	}

	public boolean offerNextSalary(int e) {
		return salaries.offer(e);
	}

	public int pollNextSalary() {
		return salaries.poll();
	}

	public int peekNextSalary() {
		return salaries.peek();
	}

}
