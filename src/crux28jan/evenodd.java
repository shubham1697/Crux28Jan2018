package crux28jan;

import java.util.Scanner;

public class evenodd {

	public static void main(String[] args) {

		System.out.print("Enter a number = ");

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		if (n % 2 == 0) {
			System.out.println(n + " is even");
		} else {
			System.out.println(n + " is odd");
		}
	}

}
