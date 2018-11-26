package lec6feb18;

import java.util.ArrayList;
import java.util.Scanner;

public class StringDemo {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str = sc.nextLine();

		System.out.println(isPalindrome(str));
		subStrings(str);
		printPalindromeSS(str);

	}

	public static boolean isPalindrome(String str) {

		for (int i = 0, j = str.length() - 1; i < str.length() / 2; i++, j--) {
			if (str.charAt(i) != str.charAt(j))
				return false;

		}

		return true;

	}

	public static void subStrings(String str) {

		for (int i = 0; i <= str.length(); i++) {
			for (int j = 0; j < i; j++) {
				System.out.println(str.substring(j, i));
			}
			System.out.println();
		}

	}

	public static void printPalindromeSS(String str) {

		for (int i = 0; i <=str.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (isPalindrome(str.substring(j, i))) {
					System.out.println(str.substring(j, i));
				}
			}

		}

	}
}
