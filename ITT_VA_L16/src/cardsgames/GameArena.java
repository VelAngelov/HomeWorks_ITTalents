package cardsgames;

public class GameArena {
	public static void main(String[] args) {

		Player vilio = new Player("Vilio");
		Player krasi = new Player("Krasi");
		Player desi = new Player("Desi");
		Player maria = new Player("Maria");
		// Vilio vs Krasi
		GameWar game = new GameWar(vilio, krasi);
		do {
			game.beginNewGame();

		} while (!isWinner(vilio.getWins(), krasi.getWins()));
		Player winner1 = vilio.getWins() > krasi.getWins() ? vilio : krasi;
		// Desi vs Maria
		game = new GameWar(desi, maria);
		do {
			game.beginNewGame();
		} while (!isWinner(desi.getWins(), maria.getWins()));
		
		Player winner2 = desi.getWins() > maria.getWins() ? desi : maria;
		//Winner1 vs Winner2
		game = new GameWar(winner1, winner2);
		do {
			game.beginNewGame();
		} while (!isWinner(winner1.getWins()-2, winner2.getWins()-2));
		Player totalWinner = winner1.getWins() > winner2.getWins() ? winner1 : winner2;
		System.out.printf("%nThe total winnar is: %s with %d wins", totalWinner.getName(), totalWinner.getWins());
	}

	static int max(int a, int b) {
		return a > b ? a : b;
	}

	static boolean isWinner(int a, int b) {
		if (max(a, b) < 2 || a == b) {
			return false;
		}
			return true;
	}
}
