package lec9mar3;

import java.util.Arrays;
import java.util.Scanner;

public class ques {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		//
		// System.out.println("x: ");
		// int x = sc.nextInt();
		// System.out.println("n: ");
		// int n = sc.nextInt();

		// String str = sc.nextLine();

		// polynomial(x,n);

		// System.out.println(power(x, n));
		// soe(n);

		// System.out.println(countPalindromeSS(str));

		incrementArr();

	}

	public static void polynomial(int x, int n) {
		int sum = 0;
		int power = x;
		for (int i = n; i > 0; i--) {
			sum = sum + i * power;
			power = power * x;
			i--;
		}
		System.out.println(sum);
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int ans = 0;
		int p = power(x, n / 2);
		if (n % 2 == 0) {
			ans = p * p;
		} else {
			ans = x * p * p;
		}
		return ans;
	}

	public static int countPalindromeSS(String str) {
		int count = 0;

		// odd
		for (int axis = 0; axis < str.length(); axis++) {
			for (int orbit = 0; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt(axis + orbit) == str.charAt(axis - orbit)) {
					count++;
				} else {
					break;
				}
			}
		}

		// even
		for (double axis = 0.5; axis < str.length(); axis++) {
			for (double orbit = 0.5; axis - orbit >= 0 && axis + orbit < str.length(); orbit++) {
				if (str.charAt((int) (axis + orbit)) == str.charAt((int) (axis - orbit))) {
					count++;
				} else {
					break;
				}
			}
		}

		return count;
	}

	public static void soe(int n) {
		boolean[] primes = new boolean[n + 1];
		Arrays.fill(primes, true);

		primes[0] = false;
		primes[1] = false;

		for (int table = 2; table * table <= n; table++) {
			if (primes[table] == true) {
				for (int multiplier = 2; multiplier * table <= n; multiplier++) {
					primes[table * multiplier] = false;
				}
			}
		}
		for (int i = 0; i < primes.length; i++) {
			if (primes[i]) {
				System.out.println(i);
			}
		}
	}

	public static void incrementArr() {

		int[] arr = { 0, 0, 0, 0, 0, 0 };
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		System.out.println("values for k,m: ");

		int k = sc.nextInt();
		int m = sc.nextInt();

		for (int i = 0; i < m; i++) {
			System.out.println("values for a,b: ");
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int j = a; j <= b; j++) {
				arr[j] = arr[j] + k;
			}
		}

		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}

		System.out.println();

		int max = Integer.MIN_VALUE;
		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("max: " + max);
	}
}
