import java.util.Scanner;

/*
Задача 6:
Да се състави програма, чрез която се въвежда изречение с отделни
думи.
Като резултат на екрана да се извежда същия текст, но всяка отделна
дума да започва с главна буква, а следващите я букви да са малки.
Пример: супер яката задача
Изход: Супер Яката Задача

 */
public class P06_Sentence {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter sentence");
		String text = in.nextLine().toLowerCase();
		String[] words = text.split(" ");
		for (int i = 0; i < words.length; i++) {
			char firstLetter = Character.toUpperCase(words[i].charAt(0));
			words[i]=firstLetter + words[i].substring(1);
		}
		String sentence = String.join(" ", words);
		System.out.println(sentence);
	}
}
