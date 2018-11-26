package lec2feb3;

import java.util.Scanner;

public class inverse {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();

		int inv = 0;

		for (int i = 1; num > 0; i++) {

			int rem = num % 10;
			num = num / 10;
			inv = inv + i * (int) Math.pow(10, rem - 1);
//			System.out.println(inv);

		}
		System.out.println(inv);

	}

}
