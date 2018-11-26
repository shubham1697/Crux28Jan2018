package crux28jan;

import java.util.Scanner;

public class fibonacci {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int s = 0;
		int a1 = 0;
		int a2 = 1;
		int i = 2;

		if (n == 0) {
			System.out.println("0");
		} else if (n == 1) {
			System.out.println("1");
		} else {
			
			while (i <= n) {
				s = a2 + a1;
				a1 = a2;
				a2 = s;
				i++;

			}
			System.out.println(s);
		}

	}

}
