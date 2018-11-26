package crux28jan;

import java.util.Scanner;

public class reverse {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		
		int rem=0, rev=0;
		while(n > 0) {
		rem = n % 10;
		rev = rev * 10 + rem;
		n = n / 10;
		}
		System.out.println(rev);
	}

}
