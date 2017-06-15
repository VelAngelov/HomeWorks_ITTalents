package L_04;

import java.util.Scanner;

public class Task7 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter positive number A:");
		int a = input.nextShort();
		System.out.println("Enter positive number B,C<=7");
		int b = input.nextByte();
		int c = input.nextByte();
		input.close();
		System.out.println(Integer.toBinaryString(a));
		int mask = 1;
		int temp = (a >> (b - 1)) & mask;
		if (temp == 0) {
			mask = 1 << (b - 1);
			a = a | mask;
		} else {
			if (b != 1) {
				mask = 1 << (b - 1);
				mask = ~mask;
				mask = mask >> 1;
				mask = mask << 1;
				mask = mask | 1;
				a = a & mask;
			} else {
				a = a >> 1;
				a = a << 1;
			}
		}
		System.out.println("After converting with b:");
		System.out.println(Integer.toBinaryString(a));
		// again with c:
		mask = 1;
		temp = (a >> (c - 1)) & mask;
		if (temp == 0) {
			mask = 1 << (c - 1);
			a = a | mask;
		} else {
			if (c != 1) {
				mask = 1 << (c - 1);
				mask = ~mask;
				mask = mask >> 1;
				mask = mask << 1;
				mask = mask | 1;
				a = a & mask;
			} else {
				a = a >> 1;
				a = a << 1;
			}
		}
		System.out.println("After converting with c:");
		System.out.println(Integer.toBinaryString(a));

	}
}
