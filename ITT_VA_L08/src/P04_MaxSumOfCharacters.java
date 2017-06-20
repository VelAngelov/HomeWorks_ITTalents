import java.util.Scanner;

/*
 Задача 4:
Да се състави програма, чрез която по въведени трите имена на двама
човека разделени със запетая, се извежда чие име има по-голям сбор
от ASCII кодовете на съставящите името букви.
Пример: Anna Dosewa Asenowa, Iwo Peew Peew
Изход: Anna Dosewa Asenowa

 */
public class P04_MaxSumOfCharacters {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter two names separated with \",\":");
		String text = in.nextLine();
		String[] name = text.split("[,]");
		int[] nameScore= new int[name.length];
		int indexOfMaxScoreName=0;
		for (int i = 0; i < name.length; i++) {
			name[i]=name[i].trim();
			for (int j = 0; j < name[i].length(); j++) {
				nameScore[i]+=name[i].charAt(j);
			}
			if(indexOfMaxScoreName<nameScore[i]) {
				indexOfMaxScoreName=i;
			}
		}
		System.out.println(name[indexOfMaxScoreName]);
	}
}
