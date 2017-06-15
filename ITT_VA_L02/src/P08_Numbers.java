import java.util.Scanner;

public class P08_Numbers {
	public static void main(String[] args) {
		System.out.println("Enter number:");
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		input.close();
		int firstNumber = ((number / 1000) % 10) * 10 + number % 10;
		int secondNumber = ((number / 100) % 10) * 10 + ((number / 10) % 10);
		if (firstNumber < secondNumber) {
			System.out.printf("smaller (%d<%d)", firstNumber, secondNumber);
		} else if (firstNumber == secondNumber) {
			System.out.printf("equal (%d=%d)", firstNumber, secondNumber);
		} else {
			System.out.printf("bigger (%d>%d)", firstNumber, secondNumber);
		}
	}
}
