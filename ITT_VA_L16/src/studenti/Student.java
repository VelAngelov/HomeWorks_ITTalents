package studenti;

public class Student {
	private String name;
	private String subject;
	private double grade;
	private int yearInCollege;
	private int age;
	private boolean isDegree;
	private double money;

	Student() {
		this.grade = 4d;
		this.yearInCollege = 1;
		this.isDegree = false;
		this.money = 0;
	}

	Student(String name, String subject, double grade, int yearInCollege, int age, boolean isDegree, double money) {
		this();
		this.name = name;
		this.subject = subject;
		if (grade >= 2 && grade <= 6) {
			this.grade = grade;
		}else {
			System.out.println("Incorrect input for grade!Accepted grade 4.00");
		}
		if (yearInCollege >= 1 && yearInCollege <= 4) {
			this.yearInCollege = yearInCollege;
		}
		if (age >= 18 && age < 100) {
			this.age = age;
		} else {
			System.out.println("Incorrect age.Accepted age 23y.");
			this.age = 23;
		}
		this.isDegree = isDegree;
		if (money >= 0) {
			this.money = money;
		}
	}

	void upYear() {
		if (this.yearInCollege + 1 > 4) {
			System.out.printf("The student %s has graduated!%n",this.name);
			this.isDegree = true;
		} else {
			this.yearInCollege++;
		}
	}

	double recieveScholarship(double min, double amount) {
		if (this.grade > min && this.age <= 30) {
			if (amount >= 0) {
				this.money += amount;
			} else {
				System.out.println("Your amount for scholarship is incorrect!");
			}
		}
		return this.money;
	}

	public double getGrade() {
		return this.grade;
	}

	public String getName() {
		return name;
	}
	public String getInfo() {
		StringBuilder sb = new StringBuilder();
		if(this.name!=null) {
			sb.append(String.format("Name: %s %n", this.name));
		}
		if(this.age!=0) {
			sb.append(String.format("Age: %d %n", this.age));
		}
		if(this.subject!=null) {
			sb.append(String.format("Subject: %s %n", this.subject));
		}
		sb.append(String.format("Year in College: %d%n", this.yearInCollege));
		sb.append(this.isDegree?"Graduated\n":"Not graduated\n");		
		sb.append(String.format("Grade: %.2f%n", this.grade));
		sb.append(String.format("Money: %.2f%n", this.money));
		return sb.toString();
	}
}
