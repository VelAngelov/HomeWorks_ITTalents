import java.util.Scanner;

public class P03_SwapValues {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter a,b:");
		int a = input.nextInt();
		int b = input.nextInt();
		input.close();
		// swap values with buffer:
		int c = a;
		a = b;
		b = c;
		System.out.printf("a:%d%nb:%d%n", a, b);
		// swap values without buffer:
		a = a + b;
		b = a - b;
		a = a - b;
		System.out.printf("After swap again:%na:%d%nb:%d%n", a, b);
	}
}
