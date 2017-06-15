import java.util.Scanner;

public class P11_DivideNumberByItsDigits {
	public static void main(String[] args) {
		System.out.println("Enter three digit number which not contain 0:");
		Scanner input = new Scanner(System.in);
		int number = input.nextShort();
		input.close();
		// the number have structure a1,a2,a3:
		int a1 = (number / 100) % 10;
		int a2 = (number / 10) % 10;
		int a3 = number % 10;
		boolean isDivisibleByItsDigits = (number % a1 == 0) && (number % a2 == 0) && (number % a3 == 0);
		if (isDivisibleByItsDigits) {
			System.out.println("Yes,the number is divisible by its digits!");
		} else {
			System.out.println("No,the number is not divisible by its digits!");
		}
	}
}
