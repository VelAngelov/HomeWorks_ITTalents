package L_04;

import java.util.Scanner;

public class Task7v1 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter positive number A:");
		int a = input.nextShort();
		System.out.println("Enter positive number B,C<=7");
		int b = input.nextByte();
		int c = input.nextByte();
		input.close();
		a=a^(1<<(b-1));
		a=a^(1<<(c-1));
		System.out.println(a);
	}
}
