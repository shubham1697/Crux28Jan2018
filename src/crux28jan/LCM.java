package crux28jan;

import java.util.Scanner;

public class LCM {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();

		int i = 2;
		int lcm = 1;

		while (i <= n1 || i <= n2) {
			while (n1 % i == 0 || n2 % i == 0) {
				lcm = lcm * i;
				if (n1 % i == 0) {
					n1 = n1 / i;
				}
				if (n2 % i == 0) {
					n2 = n2 / i;
				}
			}
			i++;
		}
		System.out.println(lcm);
	}

}
