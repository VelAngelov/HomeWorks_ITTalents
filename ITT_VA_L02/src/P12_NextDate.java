import java.util.Scanner;

public class P12_NextDate {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter dd/MM/YYYY");
		byte dd = input.nextByte();
		byte mm = input.nextByte();
		int year = input.nextInt();
		input.close();
		boolean isBigMonth = (mm == 1) || (mm == 3) || (mm == 5) || (mm == 7) || (mm == 8) || (mm == 10) || (mm == 12);
		boolean isLeapYear = (year % 4 == 0) && (year % 100 != 0 || year % 400 == 0);
		if (isBigMonth) {
			if (mm == 12) {
				if (dd == 31) {
					dd = 1;
					mm = 1;
					year++;
				} else {
					dd++;
				}
			} else {
				if (dd == 31) {
					dd = 1;
					mm++;
				} else {
					dd++;
				}
			}
		} else {
			if (mm == 2) {
				if (isLeapYear) {
					if (dd == 29) {
						dd = 1;
						mm++;
					} else {
						dd++;
					}
				} else {
					if (dd == 28) {
						dd = 1;
						mm++;
					} else {
						dd++;
					}
				}
			} else {
				if (dd == 30) {
					dd = 1;
					mm++;
				} else {
					dd++;
				}
			}
		}
		System.out.printf("Next day is :%d/%d/%d", dd, mm, year);
	}
}
