package lec2feb3;

import java.util.Scanner;

public class decimaltobinary {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int decimal = sc.nextInt();
		
		int power = 1;
		int binary = 0;
		
		while(decimal != 0) {
			int rem = decimal%2;
			binary = binary + rem * power;
			power = power * 10;
			decimal = decimal / 2;
//			System.out.println(binary);
		}
		System.out.println(binary);
		
	}

}
