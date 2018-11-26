+
package lec3feb10;

import java.util.Scanner;

public class Functions {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter 1st no.: ");
		int ul = sc.nextInt();
		System.out.print("Enter 2nd no.: ");
		int ll = sc.nextInt();
		System.out.println("");

		System.out.println("1.Find Prime nos.");
		System.out.println("2.Print Armstrong nos.");
		System.out.println("3.Find n^n");
		System.out.println("Enter ur Choice");

		int no = sc.nextInt();

		if (no == 1) {
			printallPrimes(ll, ul);
		}

		else if (no == 2) {
			printAllArmstrong(ll, ul);
		}

		else if (no == 3) {
			int num = Power(ul, ll);
			System.out.println(ul + " ^ " + ll + " = " + num);
		}

		else
			System.out.println("Invalid Choice");

		int t = ul;

	}

	public static void printallPrimes(int ll, int ul) {
		System.out.println("Primes nos. between " + ll + " and " + ul + " are: ");

		for (int i = ll; i <= ul; i++) {

			if (isPrime(i)) {
				System.out.println(i);
			}

		}

	}

	public static boolean isPrime(int ul) {
		int flag = 0;

		if (ul == 0 || ul == 1) {
			flag = 1;
		}

		for (int i = 2; i < ul; i++) {

			if (ul % i == 0) {
				flag = 1;
			}
		}

		if (flag == 0) {
			return true;
		} else
			return false;

	}

	public static void printAllArmstrong(int ll, int ul) {
		System.out.println("Armstrong nos. between " + ll + "and" + ul + "are");

		for (int i = ll; i < ul; i++) {

			if (isArmstrong(i)) {
				System.out.println(i);
			}
		}
	}

	public static boolean isArmstrong(int num) {
		int sumOfCube = 0;
		int temp = num;
		int rem = 0;
		int noOfDig = 0;

		for (int t = num; t > 0; noOfDig++) {
			t = t / 10;
		}

		for (int i = 0; temp != 0; i++) {
			rem = temp % 10;
			int p = Power(rem, noOfDig);
			// int p = (int) Math.pow(rem, noOfDig);
			sumOfCube = sumOfCube + p;
			temp = temp / 10;
		}
		if (sumOfCube == num) {
			return true;

		} else {
			return false;
		}

	}

	public static int Power(int num, int pow) {
		int temp = num;
		int power = pow;

		if (pow == 0) {
			num = 1;
		}

		else {
			for (; pow >= 2; pow--) {
				num = num * temp;
			}
		}

		return num;
	}
}
