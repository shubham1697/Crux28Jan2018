package lec2feb3;

import java.util.Scanner;

public class rotation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int rot = sc.nextInt();
		rot = rot%n;

		int num = n;
		int i = 0;
		int r = 0;

		while (n != 0) {
			n = n / 10;
			i++;

		}
		for (int count = 0; count < rot; count++) {
			int rem = num % 10;
			num = num / 10;
			r = (int) (rem * Math.pow(10, i - 1) + num);
//			System.out.println(r);
			num = r;
		}
		System.out.println(num);
	}

}
