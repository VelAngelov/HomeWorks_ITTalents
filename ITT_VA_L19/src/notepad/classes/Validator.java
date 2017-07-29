package notepad.classes;

import java.util.Scanner;

public final class Validator {
	private static Scanner in = new Scanner(System.in);

	private Validator() {
	}

	public static String validateString(String text) {
		if (text == null || text.isEmpty()) {
			System.out.printf("There is a field without text.Enter text again:\n");
			text = in.nextLine();
			return validateString(text);
		}
		return text;
	}

	public static String validateWeakPassword(String password) {
		password = validateString(password);
		if (password.replaceAll("[a-z]", "").length() == password.length()) {
			System.out.println("This pasword have no litle characters!Enter new password:");
			password = in.nextLine();
			return validateWeakPassword(password);
		} else if (password.replaceAll("[A-Z]", "").length() == password.length()) {
			System.out.println("This pasword have no big characters!Enter new password:");
			password = in.nextLine();
			return validateWeakPassword(password);
		} else if (password.replaceAll("[0-9]", "").length() == password.length()) {
			System.out.println("This pasword have no digits!Enter new password:");
			password = in.nextLine();
			return validateWeakPassword(password);
		}
		return password;
	}
}
