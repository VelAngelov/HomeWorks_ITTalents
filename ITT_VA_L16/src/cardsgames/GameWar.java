package cardsgames;

public class GameWar {
	private Player player1;
	private Player player2;
	private static String priorityStrength = "23456789TJQKA";
	private static String priorityColor = "";

	/**
	 * Create new game with two players
	 * 
	 * @param player1
	 * @param player2
	 */
	GameWar(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	/**
	 * create a new game with two players
	 */
	void beginNewGame() {
		// create begining of the game:
		printStart();
		player1.emptyTheWinDeck();
		player2.emptyTheWinDeck();
		distributeCardsFromNewDeck(player1, player2);
		while (this.player1.getNumberOfCardsInTheDeck() > 0 && this.player2.getNumberOfCardsInTheDeck() > 0) {
			playOneRound(new Deck(52), false);
		}
		System.out.println("\n=============END~OF~THE~GAME=============");
		if (player1.getNumberOfWinCards() > player2.getNumberOfWinCards()) {
			// player 1 wins the game!
			System.out.printf("Winner is %s with %d win cards%n", player1.getName(), player1.getNumberOfWinCards());
			player1.addWin();
		} else if (player1.getNumberOfWinCards() < player2.getNumberOfWinCards()) {
			// player 2 wins the game!
			System.out.printf("Winner is %s with %d win cards%n", player2.getName(), player2.getNumberOfWinCards());
			player2.addWin();
		} else {
			// nobody wins
			System.out.printf("There is no winner! %d:%d %n", player1.getNumberOfWinCards(),
					player2.getNumberOfWinCards());
		}
	}

	/**
	 * distribute one new Deck to the Players
	 * 
	 * @param player1
	 * @param player2
	 */
	private void distributeCardsFromNewDeck(Player player1, Player player2) {
		// get newDeck and distribute cards to the players:
		new Deck().distributeCards(player1, player2);
	}

	/**
	 * Recursive function
	 * 
	 * @param thrownCards-empty
	 *            deck (new Deck(52))
	 * @param wasWar
	 *            = false
	 */
	void playOneRound(Deck thrownCards, boolean wasWar) {
		if (this.player1.getNumberOfCardsInTheDeck() > 0 && this.player2.getNumberOfCardsInTheDeck() > 0) {
			Card cardFromPlayer1 = new Card();
			Card cardFromPlayer2 = new Card();
			System.out.println();
			cardFromPlayer1 = this.player1.throwCardFromDeck();
			cardFromPlayer2 = this.player2.throwCardFromDeck();
			thrownCards.addCardInDeck(cardFromPlayer1);
			thrownCards.addCardInDeck(cardFromPlayer2);
			if (calculateCardPower(cardFromPlayer1) > calculateCardPower(cardFromPlayer2)) {
				printPlayedCards(cardFromPlayer1, cardFromPlayer2);
				System.out.printf("          %s win %s", player1.getName(),
						wasWar ? " the war!!!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" : "");
				this.player1.addWinCards(thrownCards);
			} else if (calculateCardPower(cardFromPlayer1) < calculateCardPower(cardFromPlayer2)) {
				printPlayedCards(cardFromPlayer1, cardFromPlayer2);
				System.out.printf("          %s win %s", player2.getName(),
						wasWar ? " the war!!!\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~" : "");
				this.player2.addWinCards(thrownCards);
			} else if (!wasWar) {
				printPlayedCards(cardFromPlayer1, cardFromPlayer2);
				if (player1.getNumberOfCardsInTheDeck() > 1 && player2.getNumberOfCardsInTheDeck() > 1) {
					System.out.println("~~~~~~~~~~~~~~WAR~~~~~~~~~~~~~~");
					wasWar = true;
					cardFromPlayer1 = this.player1.throwCardFromDeck();
					thrownCards.addCardInDeck(cardFromPlayer1);
					cardFromPlayer2 = this.player2.throwCardFromDeck();
					thrownCards.addCardInDeck(cardFromPlayer2);
					printPacedCards(cardFromPlayer1, cardFromPlayer2);
					cardFromPlayer1 = this.player1.throwCardFromDeck();
					thrownCards.addCardInDeck(cardFromPlayer1);
					cardFromPlayer2 = this.player2.throwCardFromDeck();
					thrownCards.addCardInDeck(cardFromPlayer2);
					printPacedCards(cardFromPlayer1, cardFromPlayer2);
				}
				playOneRound(thrownCards, wasWar);
			} else {
				playOneRound(thrownCards, wasWar);
			}
		} else {
			System.out.println(
					"The game is not finished but there is no more cards ,and this war will not count in the results!");
		}
	}

	/**
	 * calculate power of the card according to the rules of the game
	 */
	private int calculateCardPower(Card card) {
		if (priorityStrength == null || priorityColor == null) {
			System.out.println("Cards have no priority, and have equivalent power = -1!");
			return -1;
		}
		int powerStrength = priorityStrength.indexOf(card.getName().charAt(0)) * 4;
		if (powerStrength < 0) {
			powerStrength = -1;
		}
		int powerColor = priorityColor.indexOf(card.getName().charAt(1));
		if (powerColor < 0) {
			powerColor = 0;
		}
		return powerStrength + powerColor;
	}

	/**
	 * Print the start of the game
	 */
	void printStart() {
		StringBuilder sb = new StringBuilder();
		while (sb.length() < 15 - this.player1.getName().length()) {
			sb.append("=");
		}
		sb.append(this.player1.getName());
		sb.append("|");
		sb.append(this.player2.getName());
		while (sb.length() - 16 < 15) {
			sb.append("=");
		}
		System.out.println(sb.toString());
	}

	/**
	 * print played cards
	 * 
	 * @param card1
	 * @param card2
	 */
	void printPlayedCards(Card card1, Card card2) {
		StringBuilder sb = new StringBuilder();
		sb.append("             ");
		sb.append(card1.getName());
		sb.append("|");
		sb.append(card2.getName());
		sb.append("             ");
		System.out.println(sb.toString());
	}

	/**
	 * Print placed on board cards
	 * 
	 * @param card1
	 * @param card2
	 */
	void printPacedCards(Card card1, Card card2) {
		StringBuilder sb = new StringBuilder();
		sb.append("             ");
		sb.append(card1.getName());
		sb.append("~");
		sb.append(card2.getName());
		sb.append("             ");
		System.out.println(sb.toString());
	}
}
