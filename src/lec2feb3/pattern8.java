package lec2feb3;

import java.util.Scanner;

public class pattern8 {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();

		int nr = 2 * n - 1;

		int nsp = 0;
		int nst = nr / 2 + 1;

		int row = 1;
		while (row <= nr) {
			int csp = 1;
			while (csp <= nsp) {
				System.out.print(" ");
				csp += 1;
			}
			int cst = 1;
			while (cst <= nst) {
				System.out.print("*");
				cst = cst + 1;
			}

			// prep

			if (row <= nr / 2) {
				nst--;
				nsp = nsp + 2;

			} else {
				nst++;
				nsp -= 2;

			}
			System.out.println("");
			row++;
		}

	}

}
