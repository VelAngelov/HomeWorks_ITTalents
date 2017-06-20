import java.util.Scanner;

/*
Задача 10
Да се състави програма, която по даден низ връща друг,
символите, на който са получени като към всеки код на символ
от ASCII таблицата е добавеното числото 5 и е записан
новополучения символ.
Пример :
Вход: Hello
Изход: Mjqqt
 */
public class P10_CaesarCrypt {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String text = in.next();
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < text.length(); i++) {
			char c =text.charAt(i);
			c+=5;
			sb.append(c);
		}
		System.out.println(sb.toString());
	}
}
