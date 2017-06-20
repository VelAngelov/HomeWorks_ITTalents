import java.util.Scanner;

/*
 Задача 3:
Да се състави програма, чрез която се въвеждат последователно две
редици от символи без интервали.
Програмата да извежда съобщение за резултата от сравнението им по
позиции.
Пример: хипопотам, хипопотук
Изход:
Двата низа са с равна дължина.
Разлика по позиции:
8 а-у
9 м-к

 */
public class P03_Diference {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two words:");
		String text1 = in.next();
		String text2 = in.next();
		if(text1.equals(text2)) {
			System.out.println("the texts are the same!");
			return;
		}
		if(text1.length()==text2.length()) {
			System.out.println("The strings are with the same length");
		}else {
			System.out.println("The strings are with diferent length");
		}
		int minLength = text1.length()>text2.length()?text2.length():text1.length();
		for (int i = 0; i < minLength; i++) {
			if(text1.charAt(i)!=text2.charAt(i)) {
				
				System.out.printf("%d %c-%c%n",i,text1.charAt(i),text2.charAt(i));
			}
		}
	}
}
