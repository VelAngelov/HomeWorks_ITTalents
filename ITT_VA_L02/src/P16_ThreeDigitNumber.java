import java.util.Scanner;

public class P16_ThreeDigitNumber {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three digits number:");
		int myNumber = input.nextInt();
		input.close();
		int a1 = (myNumber / 100) % 10;
		int a2 = (myNumber / 10) % 10;
		int a3 = myNumber % 10;

		boolean isEqual = (a1 == a2) && (a2 == a3);
		boolean areAscending = a1 <= a2 && a2 <= a3;
		boolean areDecreasing = a1 >= a2 && a2 >= a3;

		if (isEqual) {
			System.out.println("The digits of the number are equlas!");
		} else if (areAscending) {
			System.out.println("The digits of the number are ascending!");
		} else if (areDecreasing) {
			System.out.println("The digits of the number are decreasing!");
		}
	}
}
