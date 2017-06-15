import java.util.Scanner;

public class P06_SwitchThreeNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter three numbers");
		int a1 = input.nextInt();
		int a2 = input.nextInt();
		int a3 = input.nextInt();
		input.close();
		System.out.printf("You have entered a1=%d,a2=%d,a3=%d%n", a1, a2, a3);
		// switching:
		a1 = a1 + a2 + a3;
		a2 = a1 - a2 - a3;
		a3 = a1 - a2 - a3;
		a1 = a1 - a2 - a3;
		System.out.printf("You have entered a1=%d,a2=%d,a3=%d", a1, a2, a3);
		// lesno se izvyrshva s bufer
	}
}
