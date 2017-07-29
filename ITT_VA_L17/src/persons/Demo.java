package persons;

import persons.classes.*;

public class Demo {
	public static void main(String[] args) {
		// 1.
		Person[] person = new Person[10];
		// 2.
		person[0] = new Person("Ivan", 35, true);
		person[1] = new Person("Maria", 32, false);
		person[2] = new Student("Petyr", 22, true, 5.40);
		person[3] = new Student("Lili", 23, false, 5.80);
		person[4] = new Employee("Vesko", 45, true, 50);
		person[5] = new Employee("Svetla", 50, false, 30);
		// 3.
		for (int i = 0; i < 10; i++) {
			if(person[i]==null) {
				continue;
			}
			if(person[i] instanceof Employee) {
				Employee employee = (Employee) person[i];
				System.out.println("Employee:");
				System.out.print(employee.showEmployeeInfo());
				System.out.println();
			}else if(person[i] instanceof Student) {
				Student student = (Student) person[i];
				System.out.println("Student:");
				System.out.print(student.showStudentInfo());
				System.out.println();
			}else {
				System.out.println("Person:");
				System.out.print(person[i].showPersonInfo());
				System.out.println();
			}
		}
		// 4.
		for (int i = 0; i < 10; i++) {
			if(person[i]==null) {
				continue;
			}
			if(person[i] instanceof Employee) {
				Employee employee = (Employee) person[i];
				System.out.println("Employee:");
				System.out.print(employee.showEmployeeInfo());
				System.out.printf("Overtime for %d hours:%.2f$%n",2,employee.calculateOvertime(2));
				System.out.println();
			}
		}
		// 5.
		/*
		 * Отговор на въпроса:Ако се дефинира такъв конструктор ще имаме проблем с това че
		 * контруктора по подразбиране на класа родител изисква параметри и ние трябва да ги подадем.
		 * Варианти да се справим със задачата са няколко:
		 * 1в.В класа Student създаваме  конструктор Student() и на първи ред извикваме конструктора на класа родител
		 * 		с параметри, които за нас ще означават студент по подразбиране.Пример:super("Student",18,true);
		 * 2в.В класа Person създаваме конструктор Person() и задаваме полетата на класа по подразбиране.Например:
		 * 		this("Person",0,true);
		 * 		Сега може да създадем конструктор по подразбиране в Student.
		 * 
		 * Има и други варианти, но на този етап считам тези като достатъчни за решение на зададения проблем ;)
		 */
		
	}
}
