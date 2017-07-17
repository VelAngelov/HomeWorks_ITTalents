package cardsgames;

public class Deck {
	private Card[] cards;
	private int numberOfCards = 0;
	private final int MAX_NUMBER_OF_CARDS = 52;

	/**
	 * creates deck from Cards arr:
	 * 
	 * @param cards-the
	 *            array from cards
	 */
	Deck(Card[] cards) {
		this.numberOfCards = cards.length;
		this.cards = cards;
	}

	/**
	 * Creates new deck with empty card slots
	 * 
	 * @param count
	 *            number of empty slots
	 */
	Deck(int count) {
		if (count > MAX_NUMBER_OF_CARDS) {
			System.out.println("Max number of cards in the Deck must be 52!Created deck from 52 cards.");
			this.numberOfCards = 0;
			this.cards = new Card[MAX_NUMBER_OF_CARDS];
		} else {
			this.numberOfCards = 0;
			this.cards = new Card[count];
		}
	}

	/**
	 * creates new shuffled deck from 52 cards
	 */
	Deck() {
		this.numberOfCards = 52;
		this.cards = new Card[numberOfCards];
		// generate all cards:
		char[] strength = { '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K', 'A' };
		char[] colors = { 's', 'h', 'd', 'c' };
		int cardNumber = 0;
		for (char str : strength) {
			for (char col : colors) {
				this.cards[cardNumber++] = new Card(str, col);
			}
		}
		shuffleCardsInDeck();
	}

	void shuffleCardsInDeck() {
		Card temp = new Card();
		for (int i = 0; i < numberOfCards; i++) {
			temp = cards[i];
			int num = (int) (Math.random() * numberOfCards);
			cards[i] = cards[num];
			cards[num] = temp;
		}
	}

	/**
	 * view card by number in the deck
	 * 
	 * @param numberInDeck
	 *            (int)
	 * @return
	 */
	Card viewCardByNum(int numberInDeck) {
		if (numberInDeck - 1 < numberOfCards) {
			return this.cards[numberInDeck - 1];
		} else {
			System.out.printf("There is no %d card in this deck.The deck is from %d cards%n", numberInDeck,
					numberOfCards);
			return new Card();
		}
	}

	/**
	 * Add new card in the deck
	 * 
	 * @param newCard
	 *            -Card
	 */
	void addCardInDeck(Card newCard) {
		if (numberOfCards < cards.length) {
			this.cards[numberOfCards] = new Card();
			this.cards[numberOfCards] = newCard;
			numberOfCards++;
		} else {
			System.out.println("The deck is full!");
		}
	}

	/**
	 * get the last card from the deck
	 * 
	 * @return Card or Null
	 */
	Card getLastCardFromDeck() {
		if (numberOfCards > 0) {
			numberOfCards--;
			Card lastCard = cards[numberOfCards];
			cards[numberOfCards] = null;
			return lastCard;
		} else {
			System.out.println("there is no more cards in the deck!");
			return new Card();
		}
	}

	/**
	 * Add to this deck a new Deck
	 * 
	 * @param cardsToAdd
	 *            (deck) to be added in the new deck
	 */
	void addDeckToThisDeck(Deck cardsToAdd) {
		int cards = cardsToAdd.numberOfCards;
		for (int i = 0; i < cards; i++) {
			Card temp = cardsToAdd.getLastCardFromDeck();
			this.addCardInDeck(temp);
		}
	}

	/**
	 * distribute cards in playing decks for players
	 * 
	 * @param players
	 *            (Player[])
	 */
	void distributeCards(Player... players) {
		int playersCount = players.length;
		Card newCard;
		if (this.numberOfCards % playersCount != 0) {
			System.out.println("distribution will be not fair");
		}
		while (this.numberOfCards != 0) {
			for (int i = 0; i < playersCount; i++) {
				if (this.numberOfCards != 0) {
					newCard = this.getLastCardFromDeck();
					players[i].addCardInPlayingDeck(newCard);
				}
			}
		}

	}

	/**
	 * 
	 * @return number of cards in this Deck
	 */
	int getNumberOfCards() {
		return numberOfCards;
	}

}
