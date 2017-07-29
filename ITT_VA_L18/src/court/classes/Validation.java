package court.classes;

import java.util.Scanner;

public final class Validation {
	private static Scanner in = new Scanner(System.in);

	private Validation() {
	}

	public static String validateString(String s) {
		if (s == null || s.isEmpty()) {
			System.err.println("Invalid text entered!Enter again:");
			s = in.nextLine();
			return validateString(s);
		}
		return s;
	}

	public static String validateName(String name) {
		name = validateString(name);
		String mask = name.replaceAll("[^a-zA-Z ]", "");
		if (!name.equals(mask)) {
			System.err.printf("\"%s\" is not a valid name, enter again the name!\n",name);
			name = in.nextLine();
			return validateName(name);
		}
		return name;
	}

	public static String validateThreeNames(String name) {
		String[] names = name.split(" ");
		if(names.length!=3) {
			System.err.printf("\"%s\" have more or less than 3 names. Please correct the names!",name);
			name = in.nextLine();
			return validateThreeNames(name);
		}
		for(String n: names) {
			n = validateName(n);
		}
		return String.join(" ", names);
	}

	public static int returnBiggerThanNumber(int myNum, int number) {
		if (myNum < number) {
			System.err.printf("You have entered %d, but this is not bigger than %d.Enter again:", myNum, number);
			myNum = in.nextInt();
			return returnBiggerThanNumber(myNum, number);
		}
		return myNum;
	}
	public static int validateAge(int age,int minAge,int maxAge) {
		if(age>maxAge||age<minAge) {
			System.err.printf("You have entered %d, but this is not valid age!Enter again:", age);
			age = in.nextInt();
			return validateAge(age, minAge, maxAge);
		}
		return age;
	}
	public static double returnPositiveNumber(double num) {
		if (num <= 0) {
			System.err.printf("You have entered %f, but this is not posivite number.Enter again:", num);
			num = in.nextInt();
			return returnPositiveNumber(num);
		}
		return num;
	}
}
