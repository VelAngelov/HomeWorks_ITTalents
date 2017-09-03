package imoti.classes;

import java.util.Random;

public final class Validator {

	private Validator() {

	}

	public static boolean validateString(String str) {
		return str != null && !str.isEmpty();
	}

	public static int rnd(int from, int to) {
		return from + new Random().nextInt(to);
	}

	public static String generateTelNumber() {
		StringBuilder nomer = new StringBuilder("08");
		for (int i = 0; i < 8; i++) {
			nomer.append(rnd(0, 10));
		}
		return nomer.toString();
	}
}
