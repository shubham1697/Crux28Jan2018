package crux28jan;

import java.util.Scanner;

public class fib {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int a = 0;
		int b = 1;
		int s = 0;

		while (a <= n) {
			System.out.println(a);
			s = a + b;
			a = b;
			b = s;
		}

	}

}
