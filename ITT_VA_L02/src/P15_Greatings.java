import java.util.Scanner;

public class P15_Greatings {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter hours:");
		byte hours = input.nextByte();
		input.close();
		String greatings;
		if (hours >= 4 && hours < 9) {
			greatings = " morning!";
		} else if (hours >= 9 && hours < 18) {
			greatings = " afternoon";
		} else if ((hours >= 18 && hours < 24) || (hours >= 0 && hours < 4)) {
			greatings = " night";
		} else {
			greatings = ", but you have entered wrong hour!";
		}
		System.out.printf("Good%s", greatings);

	}
}
