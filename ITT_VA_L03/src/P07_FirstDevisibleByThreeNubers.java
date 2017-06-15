import java.util.Scanner;

public class P07_FirstDevisibleByThreeNubers {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.println("Enter n>=1:");
		int n=input.nextInt();
		input.close();
		
		//validation of input:
		if(n<1){
			throw new IllegalArgumentException("Bad input!You have entered n<1!");
		}
		
		System.out.printf("%d", 3);
		for (int i = 2; i <= n; i++) {
			System.out.printf(",%d",3*i );
		}
	}
}
