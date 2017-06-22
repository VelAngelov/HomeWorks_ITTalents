package HomeworkRecursion;

import java.util.Scanner;

/*Задача 3:
Да �?е �?ъ�?тави програма, ко�?то провер�?ва дали въведено е�?те�?твено
чи�?ло е про�?то.
Пример: 101
Изход: просто
*/
public class P03_isPrime {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter number n>0");
		int n = in.nextInt();
		System.out.println(isPrime(2, n) ? "prime" : "not Prime");
	}

	public static boolean isPrime(int i, int n) {
		if( i*i > n) {
			return true;
		}
		return (n % i != 0)&&isPrime(i+1, n);
	}

}
