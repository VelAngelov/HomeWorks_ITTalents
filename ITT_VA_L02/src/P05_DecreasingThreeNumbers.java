import java.util.Scanner;

public class P05_DecreasingThreeNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three numbers");
		int a = input.nextInt();
		int b = input.nextInt();
		int c = input.nextInt();
		input.close();
		// creating a<b<c:
		int temp;
		if (a > b) {
			temp = a;
			a = b;
			b = temp;
		}
		if (a > c) {
			temp = a;
			a = c;
			c = temp;
		}
		if (b > c) {
			temp = b;
			b = c;
			c = temp;
		}
		System.out.println("[ " + a + ", " + b + ", " + c + " ]");
	}
}
