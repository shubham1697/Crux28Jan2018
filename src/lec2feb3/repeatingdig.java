package lec2feb3;

import java.util.Scanner;

public class repeatingdig {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int temporary = num / 10;
		int r1 = 0;
		int r2;
		int flag = 0;

		while (num > 0) {
			r1 = num % 10;
			while (temporary > 0) {
				r2 = temporary % 10;
				if (r2 == r1) 
					flag=1;
					
				temporary = temporary / 10;
			}
			num = num / 10;

		}

	
		if(flag==1)
			System.out.println("repeating");
		else
			System.out.println("no");
	}
}
