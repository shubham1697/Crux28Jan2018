package lec8feb25;

public class Recursion {

	public static void main(String[] args) {

		int[] arr = { 9, 7, 4, 9, 8, 3 };
		// bubbleSort(arr, 0, arr.length - 1);
		// for (int i = 0; i < arr.length; i++) {
		// System.out.println(arr[i]);
		// }

		// printBox(1, 1, 5);
		 printStarpattern(1, 1, 5);

		// printRows(1, 5);
		// int[] merged = mergeSort(arr, 0, arr.length - 1);
		// for (int val : merged) {
		// System.out.println(val);
		// }
//		quickSort(arr, 0, arr.length - 1);
//		for (int val : arr) {
//			System.out.println(val);
//		}
	}

	public static void printRows(int rows, int n) {

		if (rows > n) {
			return;
		}

		System.out.println("*");
		printRows(rows + 1, n);
	}

	public static void printBox(int rows, int col, int n) {

		if (rows == n + 1) {
			return;
		}

		if (col == n + 1) {
			System.out.println();
			printBox(rows + 1, 1, n);
			return;
		}

		System.out.print("*");
		printBox(rows, col + 1, n);
	}

	public static void printStarpattern(int rows, int col, int n) {

		if (rows == n + 1) {
			return;
		}

		if (col == rows + 1) {
			System.out.println();
			printStarpattern(rows + 1, 1, n);
			return;
		}

		System.out.print("*");
		printStarpattern(rows, col + 1, n);

	}

	public static void printStarpatternRev(int rows, int col, int n) {

	}

	public static void bubbleSort(int[] arr, int si, int ei) {

		if (ei == 0) {
			return;
		}

		if (si == ei) {
			bubbleSort(arr, 0, ei - 1);
			return;
		}

		if (arr[si] > arr[si + 1]) {
			int temp = arr[si + 1];
			arr[si + 1] = arr[si];
			arr[si] = temp;
		}

		bubbleSort(arr, si + 1, ei);
	}

	public static int[] mergeTwoSortedArray(int[] arr1, int[] arr2) {

		int i = 0;
		int j = 0;
		int k = 0;

		int[] rv = new int[arr1.length + arr2.length];

		while (i < arr1.length && j < arr2.length) {

			if (arr1[i] < arr2[j]) {
				rv[k] = arr1[i];
				i++;
				k++;
			} else {
				rv[k] = arr2[j];
				j++;
				k++;
			}
		}
		if (i == arr1.length) {
			while (j < arr2.length) {
				rv[k] = arr2[j];
				j++;
				k++;
			}
		}
		if (j == arr2.length) {
			while (i < arr1.length) {
				rv[k] = arr1[i];
				i++;
				k++;
			}
		}

		return rv;

	}

	public static int[] mergeSort(int[] arr, int lo, int hi) {

		if (lo == hi) {
			int[] bR = new int[1];
			bR[0] = arr[lo];
			return bR;
		}

		int mid = (lo + hi) / 2;

		int[] fh = mergeSort(arr, lo, mid);
		int[] sh = mergeSort(arr, mid + 1, hi);

		int[] merged = mergeTwoSortedArray(fh, sh);

		return merged;

	}

	public static void quickSort(int[] arr, int lo, int hi) {

		if (lo >= hi) {
			return;
		}

		int left = lo;
		int right = hi;
		int mid = (left + right) / 2;
		int pivot = arr[mid + 1];

		while (left <= right) {

			while (arr[left] < pivot) {
				left++;
			}
			while (arr[right] > pivot) {
				right--;
			}

			if (left <= right) {
				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left++;
				right--;
			}

		}
		quickSort(arr, lo, right);
		quickSort(arr, left, hi);

	}

}
