package lec2feb3;

import java.util.Scanner;

public class binarytodecimal {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int binary = sc.nextInt();

		int power = 1;
		int decimal = 0;

		while (binary != 0) {

			int rem = binary % 10;

			decimal = decimal + rem * power;
			power = power * 2;
			binary = binary / 10;
//			System.out.println(decimal);

		}
		System.out.println(decimal);

	}

}
