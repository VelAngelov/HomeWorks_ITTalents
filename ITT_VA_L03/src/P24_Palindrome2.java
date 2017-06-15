import java.util.Scanner;

public class P24_Palindrome2 {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number in the interval [10,30000]");
		int number=input.nextInt();
		input.close();
		if(number>30000||number<10){
			System.out.println("Invalid input!");
			return;
		}

		StringBuilder sb=new StringBuilder();
		sb.append(Integer.toString(number));
		if(sb.equals(sb.reverse())){
			System.out.println("Palindrome");
		}else{
			System.out.println("not a Palindrome");
		}
	
	}
}
