package crux28jan;

import java.util.Scanner;

public class sum_even_odd {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int evenSum = 0;
		int oddSum = 0;

		while (n > 0) {
			int rem = n % 10;
			oddSum = oddSum + rem;
			n = n/10;
			rem = n%10;
			evenSum = evenSum + rem;
			n = n/10;
		}
		System.out.println(oddSum);
		System.out.println(evenSum);

	}

}
