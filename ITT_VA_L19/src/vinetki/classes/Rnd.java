package vinetki.classes;

import java.util.Random;

public final class Rnd {
	private Rnd() {

	}

	private static Random rnd = new Random();

	public static int rnd(int from, int to) {
		if (from < to) {
			return from + rnd.nextInt(to - from);
		}
		return from;
	}
}
