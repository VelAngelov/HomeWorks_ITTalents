package cardsgames;

public class Card {
	private String name;
	boolean isCard;

	Card() {
	}

	/**
	 * Create a Card with strength and color
	 * 
	 * @param strength
	 * @param color
	 */
	Card(char strength, char color) {
		if (isValid(strength, color)) {
			this.name = Character.toString(strength).concat(Character.toString(color));
			this.isCard = true;
		} else {
			return;
		}
	}

	/**
	 * create card by name String
	 * 
	 * @param name
	 */

	Card(String name) {
		this(name.charAt(0), name.charAt(1));
	}

	/**
	 * isValid check the card:
	 * 
	 * @param strength
	 *            for example 7,J or A;
	 * @param color
	 *            c,d,h or s;
	 * @return boolean
	 */
	private boolean isValid(char strength, char color) {
		String cardsStrength = "2,3,4,5,6,7,8,9,T,J,Q,K,A";
		String cardsColors = "c,d,h,s";
		boolean isValidStrength = cardsStrength.indexOf(strength) != -1;
		boolean isValidColor = cardsColors.indexOf(color) != -1;
		return isValidColor && isValidStrength;
	}

	// ==============GETTERS and SETTERS===================:

	String getName() {
		return name;
	}

	boolean getIsCard() {
		return isCard;
	}
}
