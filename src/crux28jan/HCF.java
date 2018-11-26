package crux28jan;

import java.util.Scanner;

public class HCF {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n1 = scn.nextInt();
		int n2 = scn.nextInt();
		int counter = 0;

		int i = 1;
		while (i <= n1 && i <= n2) {
			if (n1 % i == 0 && n2 % i == 0) {
				counter = i;
			}
			i++;

		}
		System.out.println(counter);

	}

}
