import java.util.Scanner;

public class P09_IsEven {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter two numbers :");
		short a = input.nextShort();
		short b = input.nextShort();
		input.close();
		short c = (short) (a * b);
		System.out.printf("%d => %d =>%s", c, c % 10, c % 2 == 0 ? "even" : "odd");
	}
}
