package studenti;

import java.util.Random;

public class College {
	public static void main(String[] args) {
		StudentGroup mathTeam = new StudentGroup("Mathematica Team");
		// Competition:
		while (mathTeam.getFreePlaces() != 0) {
			Student candidate = randomStudent();
			if (candidate.getGrade() > 5) {
				mathTeam.addStudent(candidate);
			}
		}
		// 2 years in learning:
		int years = 2;
		for (int i = 0; i < years; i++) {
			for (int j = 0; j < 5; j++) {
				mathTeam.getStudent(j).upYear();
			}
		}
		// printing info:
		mathTeam.printStudentsInGroup();
		System.out.println("The best in the team is:");
		System.out.println(mathTeam.theBestStudent());
	}

	static Student randomStudent() {
		String[] namePool = { "Ivan", "Hristo", "Velichko", "Daniel", "Krasimir", "Maria", "Desislava", "Snejana",
				"Simona", "Ani" };
		double[] grades = { 5.15, 4.92, 6, 5.15, 5.45, 5.8, 3.95, 4.80, 4.50 };
		String[] subjectPool = { "Structural Engineering", "Architecture", "Software Engineering",
				"Artificial Inteligence" };
		double[] initialRewards = { 2000, 586.23, 215.15, 3000, 20000, 0, 0, 0, 0, 0, 0, 0 };
		String name = namePool[new Random().nextInt(namePool.length)];
		String subject = subjectPool[new Random().nextInt(subjectPool.length)];
		double grade = grades[new Random().nextInt(grades.length)];
		int yearInCollege = new Random().nextInt(4);
		int age = 18 + yearInCollege + new Random().nextInt(10);
		boolean isDegree = false;
		double money = initialRewards[new Random().nextInt(initialRewards.length)];
		Student student = new Student(name, subject, grade, yearInCollege, age, isDegree, money);
		return student;
	}
}
