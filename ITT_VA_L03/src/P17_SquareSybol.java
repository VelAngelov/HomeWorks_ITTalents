import java.util.Scanner;

public class P17_SquareSybol {
	public static void main(String[] args) {
		System.out.println("Enter square length:");
		Scanner input = new Scanner(System.in);
		int n = input.nextInt();
		if (n < 1) {
			System.out.println("not a length!");
			return;
		}
		System.out.println("Enter symbol");
		String s = Character.toString(input.next().charAt(0));
		input.close();
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || i == n - 1 || j == 0 || j == n - 1) {
					System.out.print("*");
				} else {
					System.out.print(s);
				}
			}
			System.out.println();
		}
	}
}
