import java.util.Scanner;

public class P16_NumbersFormNToM {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter integer N,M in the interval [10,5555]");
		int n=input.nextInt();
		int m=input.nextInt();
		input.close();
		if(n<10||n>5555){
			System.out.println("Bad input for n!");
			return;
		}else if(m<10||m>5555){
			System.out.println("Bad input for m!");
		}
		if(n>m){
			int temp=n;
			n=m;
			m=temp;
		}
		for (int i = m; i >= n; i--) {
			if(i%50==0){
				System.out.println(i);
				i-=49;
			}
		}
	}
}
