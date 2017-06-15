import java.util.Scanner;

public class P05_NumbersFromNtoK {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer n:");
		int min=input.nextInt();
		System.out.println("Enter integer k:");
		int max=input.nextInt();
		input.close();
		if(min>max){
			int temp=min;
			min=max;
			max=temp;
		}
		System.out.println("Numbers:");
		for (int i = min; i <= max; i++) {
			System.out.printf("%d ",i);
		}
	}
}
