package HomeworkString;

import java.util.Scanner;

public class P05_Anagrams {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter text1:");
		String text1 = in.next();
		System.out.println("Enter text2:");
		String text2 = in.next();
		System.out.println(isEquals(countLowerCaseInArrayFromText(text1),
				countLowerCaseInArrayFromText(text2))?"anagrams":"not anagrams");
	}
	public static int[] countLowerCaseInArrayFromText(String text) {
		text = text.toLowerCase();
		//clear text from other characters:
		text = text.replaceAll("[^a-z]+", "");
		int[] arr = new int[26];
		char c;
		for (int i = 0; i < text.length(); i++) {
			c = text.charAt(i);
			c -= 'a';
			arr[c]++;
		}
		return arr;
	}
	public static boolean isEquals(int[] arr1,int[] arr2) {
		if(arr1.length!=arr2.length) {
			return false;
		}
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i]!=arr2[i]) {
				return false;
			}
		}
		return true;
	}
}
