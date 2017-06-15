import java.util.Scanner;

public class P09_SumOfSquaresNumbers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter A:");
		int a=input.nextInt();
		System.out.println("Enter B:");
		int b=input.nextInt();
		if(a>b){
			int temp=a;
			a=b;
			b=temp;
		}
		input.close();
		
		int sum=0;
		for (int i = a; i <= b; i++) {
			if(sum>200){
				break;
			}
			if(i%3==0){
				System.out.printf(" skip %d,", i);
				continue;
			}
			System.out.printf(" %d,",i*i);
			sum+=i*i;
		}
	}
}
