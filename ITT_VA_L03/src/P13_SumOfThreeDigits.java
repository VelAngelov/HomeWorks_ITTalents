import java.util.Scanner;

public class P13_SumOfThreeDigits {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer sum in the interval [2,27]:");
		int sum=input.nextInt();
		input.close();
		if(sum>27||sum<2){
			System.out.println("Bad input!");
			return;
		}
		for (int i = 101; i < 1000; i++) {
			if(sum==((i/100)%10+(i/10)%10+i%10)){
				System.out.println(i);
			}
		}

	}
}
