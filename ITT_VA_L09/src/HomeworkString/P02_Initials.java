package HomeworkString;

import java.util.Scanner;

public class P02_Initials {
	public static void main(String[] args) {
		System.out.println("Enter your names devide by \" \"");
		Scanner in = new Scanner(System.in);
		String[] names = in.nextLine().split(" ");
		printInitials(names);
	}
	public static void printInitials(String[] names) {
		StringBuilder initials = new StringBuilder();
		for (int i = 0; i < names.length; i++) {
			initials.append(names[i].charAt(0));			
		}
		System.out.println("Initials of the names are:");
		System.out.println(initials.toString().toUpperCase());
	}
}
