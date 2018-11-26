package lec7feb24;

import java.util.ArrayList;

public class RecursionDemo {
	static int flag = 0;

	public static void main(String[] args) {

//		 PD(5);
//		 PI(5);
//		 PDI(5);
//		 PDIwithSkips(5);
		 System.out.println(factorial(3));
		// System.out.println(power(3, 4));
		// System.out.println(fibonacci(8));
//		int[] arr = { 300, 50, 6, 8, 96, 34, 8, 8, 6, 90 };
		// displayArray(arr,0);
		// displayREVArray(arr, 0);
		// System.out.println(maxArray(arr, 0));
		// System.out.println(findBoolean(arr, 0, 6));
		// System.out.println(findFirstIndex(arr, 0, 6));
//		 System.out.println(findLastIndex(arr, 0, 8));
//		int[] val = findAllIndex(arr, 0, 8, 0);
		
//		for(int i:val) {
//			System.out.println(i);
//		}

	}

	public static void PD(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PD(n - 1);

	}

	public static void PI(int n) {
		if (n == 0) {
			return;
		}

		PI(n - 1);
		System.out.println(n);
	}

	public static void PDI(int n) {
		if (n == 0) {
			return;
		}

		System.out.println(n);
		PDI(n - 1);
		System.out.println(n);
	}

	public static void PDIwithSkips(int n) {
		if (n == 0) {
			return;
		}

		if (n % 2 != 0)
			System.out.println(n);

		PDIwithSkips(n - 1);

		if (n % 2 == 0)
			System.out.println(n);
	}

	public static int factorial(int n) {
		if (n == 0) {
			return 1;
		}

		int fac = n * factorial(n - 1);
		return (fac);
	}

	public static int power(int x, int n) {

		if (n == 0) {
			return 1;
		}

		int num = x * power(x, n - 1);

		return num;
	}

	public static int fibonacci(int n) {

		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}

		int fib = fibonacci(n - 1) + fibonacci(n - 2);

		return fib;
	}

	public static void displayArray(int[] arr, int vidx) {

		if (vidx == arr.length) {
			return;
		}

		System.out.println(arr[vidx]);
		displayArray(arr, vidx + 1);

	}

	public static void displayREVArray(int[] arr, int vidx) {
		if (vidx == arr.length) {
			return;
		}

		displayREVArray(arr, vidx + 1);
		System.out.println(arr[vidx]);
	}

	public static int maxArray(int[] arr, int vidx) {

		if (vidx == arr.length)
			return 0;

		int m = maxArray(arr, vidx + 1);
		if (m < arr[vidx])
			m = arr[vidx];

		return m;
	}

	public static boolean findBoolean(int[] arr, int vidx, int item) {

		if (vidx == arr.length)
			return false;

		if (findBoolean(arr, vidx + 1, item))
			return true;
		else {

			if (arr[vidx] != item)
				return false;
			else
				return true;
		}

	}

	public static int findFirstIndex(int[] arr, int vidx, int item) {

		if (vidx == arr.length)
			return -1;

		if (arr[vidx] == item) {
			return vidx;
		}

		int rv = findFirstIndex(arr, vidx + 1, item);
		return rv;

	}

	public static int findLastIndex(int[] arr, int vidx, int item) {
		if (vidx == arr.length)
			return -1;

		int rv = findLastIndex(arr, vidx + 1, item);

		if (flag == 1) {
			return rv;
		}

		if (arr[vidx] == item) {
			flag = 1;
			return vidx;
		} else
			return -1;

	}

	public static int[] findAllIndex(int[] arr, int vidx, int item, int count) {

		if (vidx == arr.length) {
			int[] arr1 = new int[count];
			return arr1;
		}

		if (arr[vidx] == item) {
			int[] re = findAllIndex(arr, vidx + 1, item, count + 1);
			re[count] = vidx;
			return re;
		} else {
			int[] re = findAllIndex(arr, vidx + 1, item, count);
			return re;
		}

	}

}
