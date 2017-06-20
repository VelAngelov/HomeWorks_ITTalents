import java.util.Scanner;

/*
Задача 5:
Да се състави програма, чрез която се въвеждат 2 редици от знаци
(думи).
Ако в двете редици участва един и същи знак, да се изведе на екрана
първата редица хоризонтално, а втората вертикално, така че да се
пресичат в общия си знак.
Ако редиците нямат общ знак да се изведе само уведомително
съобщение.
Пример :
м
а
шапка
и
н
а
 */
public class P05_CrossWords {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two words");
		String firstString = in.next();
		String secondString = in.next();
		int i = 0;
		int j = 0;
		outerloop: for (i = 0; i < secondString.length(); i++) {
						for (j = 0; j < firstString.length(); j++) {
							if (firstString.charAt(j) == secondString.charAt(i)) {
								break outerloop;
							}
						}
		}
		
		StringBuilder sb = new StringBuilder();
		while(i>0) {
			sb.append(" ");
			i--;
		}
		if(j==firstString.length()) {
			System.out.println("no matches");
		}else {
			for (int count = 0; count < firstString.length(); count++) {
				if (count == j) {
					System.out.println(secondString);
				}else {
					System.out.println(sb.toString()+firstString.charAt(count));
				}
			}
		}			
	}
}
