import java.util.Scanner;

public class P21_DeckOfCards {
	public static void main(String[] args) {
		System.out.println("Enter number from the deck:");
		Scanner input = new Scanner(System.in);
		int numberFromDeck = input.nextInt();
		input.close();
		if(numberFromDeck>52||numberFromDeck<1){
			System.out.println("Bad input!");
			return;
		}

		String firstCharacter;
		String secondCharacter;
		for (int i = 2 + (numberFromDeck - 1) / 4; i <= 14; i++) { 
			if (i > 9) {
				switch (i) {
				case 11:
					firstCharacter = "Вале";
					break;
				case 12:
					firstCharacter = "Дама";
					break;
				case 13:
					firstCharacter = "Поп";
					break;
				case 14:
					firstCharacter = "Асо";
					break;
				default:
					firstCharacter = "Err";
					break;
				}
			} else {
				firstCharacter = Integer.toString(i);
			}
			for (int j = 0; j < 4; j++) {
				if(numberFromDeck%4!=0){
					j=numberFromDeck%4-1;
					numberFromDeck=0;
				}
				switch (j) {
				case 0:
					secondCharacter = "Спатия";
					break;
				case 1:
					secondCharacter = "Каро";
					break;
				case 2:
					secondCharacter = "Купа";
					break;
				case 3:
					secondCharacter = "Пика";
					break;
				default:
					secondCharacter = "Err";
					break;
				}
				System.out.println(firstCharacter + " " + secondCharacter);
			}
		}
	}
}
