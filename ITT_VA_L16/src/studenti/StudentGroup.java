package studenti;

public class StudentGroup {
	private String groupSubject;
	private Student[] students;
	private int freePlaces;

	StudentGroup() {
		emptyGroup();
	}

	StudentGroup(String subject) {
		this();
		this.groupSubject = subject;
	}

	void addStudent(Student student) {
		if (this.freePlaces > 0) {
			students[this.students.length - this.freePlaces] = student;
			this.freePlaces--;
		} else {
			System.out.println("There is no free places in this student group!");
		}
	}

	void emptyGroup() {
		this.students = new Student[5];
		this.freePlaces = this.students.length;
	}

	String theBestStudent() {
		if (this.freePlaces == 5) {
			System.out.println("There is no students in this group!");
			return null;
		} else {
			Student bestStudent = this.students[0];
			for (int i = 1; i < this.students.length - this.freePlaces; i++) {
				if (bestStudent.getGrade() < this.students[i].getGrade()) {
						bestStudent = this.students[i];
				}
			}
			return bestStudent.getName();
		}
	}

	void printStudentsInGroup() {
		System.out.printf("Student group: %s%n", this.groupSubject);
		for (int i = 0; i < this.students.length - this.freePlaces; i++) {
			System.out.println(this.students[i].getInfo());
		}
	}

	public int getFreePlaces() {
		return freePlaces;
	}

	public Student getStudent(int n) {
		if (n >= 0 && n < this.students.length - this.freePlaces) {
			return this.students[n];
		}
		return new Student();
	}
}
