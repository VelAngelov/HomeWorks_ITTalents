package cardsgames;

public class Player {
	private String name;
	private int wins;
	private int playedGames;
	private Deck playerDeck;
	private Deck winCards;
	private static int count = 0;

	private Player() {
		count++;
	}

	Player(String name) {
		this();
		if (name != null && !name.isEmpty()) {
			name = name.replaceAll("[\\W]", "");
			if (name != null && !name.isEmpty() && name.length() < 15) {
				this.name = name;
			} else {
				System.out.println("Invalid name entered,or too long name!");
				this.name = "Player" + count;
			}
		} else {
			System.out.println("Invalid name entered!");
			this.name = "Player" + count;
		}
		this.playerDeck = new Deck(26);
		this.winCards = new Deck(52);
	}

	void addWin() {
		wins++;
	}

	void startNewGame() {
		playedGames++;
	}

	void addCardInPlayingDeck(Card newCard) {
		this.playerDeck.addCardInDeck(newCard);
	}

	void addWinCards(Deck winCards) {
		this.winCards.addDeckToThisDeck(winCards);
	}

	Card throwCardFromDeck() {
		Card thrownCard = playerDeck.getLastCardFromDeck();
		return thrownCard;
	}

	void emptyTheWinDeck() {
		this.winCards = new Deck(52);
	}

	// ==============GETTERS and SETTERS===================:
	String getName() {
		return name;
	}

	void setName(String name) {
		this.name = name;
	}

	int getWins() {
		return wins;
	}

	int getPlayedGames() {
		return playedGames;
	}

	int getNumberOfCardsInTheDeck() {
		return this.playerDeck.getNumberOfCards();
	}

	int getNumberOfWinCards() {
		return this.winCards.getNumberOfCards();
	}

}
