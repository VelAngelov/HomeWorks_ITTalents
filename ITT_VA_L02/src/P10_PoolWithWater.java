import java.util.Scanner;

public class P10_PoolWithWater {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter number between[10..9999]:");
		int waterInThePool = input.nextInt();
		input.close();
		byte remainder = (byte) (waterInThePool % 5);
		short bucket2 = (short) (waterInThePool / 5);
		short bucket3 = bucket2;
		switch (remainder) {
		case 0:
			break;
		case 1:
			bucket2--;
			bucket3++;
			break;
		case 2:
			bucket2++;
			break;
		case 3:
			bucket3++;
			break;
		case 4:
			bucket2 += 2;
			break;
		default:
			break;
		}
		System.out.printf("%d buckets with 3 lt and %d buckets with 2 lt", bucket3, bucket2);
	}
}
