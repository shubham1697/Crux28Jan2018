package lec4feb11;

import java.util.Scanner;

public class Array {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		// int[] array = takeInput();
		int[] array = { 5, 4, 3, 2, 1 };
		display(array);
		// int max = maximum(array);
		// int n = sc.nextInt();

		// int pos = linearSearch(array, n);
		// System.out.println(pos);

		// int[] rev = reverseArr(array);
		// display(rev);

		// int[] inv = inverseArr(array);
		// display(inv);

		// int[] rot = rotate(array, 3);
		// display(rot);

		// int bSR = binarySearch(array, 4);
		// System.out.println(bSR);

		// bubbleSort(array);

//		selectionSort(array);
		 insertionSort(array);
		 display(array);
	}

	public static int[] takeInput() {
		int n = sc.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return arr;
	}

	public static void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println(" ");
	}

	public static int maximum(int[] arr) {
		int max = Integer.MIN_VALUE;

		for (int i = 0; i < arr.length; i++) {
			if (max < arr[i]) {
				max = arr[i];
			}
		}
		System.out.println("maximum in array: " + max);
		return max;
	}

	public static int linearSearch(int[] arr, int n) {
		System.out.println("enter no. to be searched: ");

		for (int i = 0; i < arr.length; i++) {
			if (n == arr[i]) {
				return i;
			}
		}

		return -1;
	}

	public static int[] reverseArr(int[] arr) {

		int i, j = arr.length - 1, temp;

		for (i = 0; i < (arr.length - 1) / 2; i++, j--) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}

		return arr;
	}

	public static int[] inverseArr(int[] arr) {
		int[] inv = new int[arr.length];
		int i = 0;
		for (; i < arr.length; i++) {
			inv[arr[i]] = i;

		}
		return inv;
	}

	public static int[] rotate(int[] arr, int k) {

		int[] rot = new int[arr.length];

		k = k % arr.length;

		if (k < 0) {
			k = k + arr.length;
		}

		for (int i = 0; i < rot.length; i++) {
			if (i < k) {
				rot[i] = arr[i + rot.length - k];
			} else {
				rot[i] = arr[i - k];
			}
		}
		return rot;

	}

	public static int[] subsetArr(int[] arr) {

		return arr;
	}

	public static int binarySearch(int[] arr, int item) {

		int left = 0;
		int right = arr.length - 1;

		while (left <= right) {
			int mid = (left + right) / 2;

			if (item < arr[mid]) {
				right = mid - 1;
			} else if (item > arr[mid]) {
				left = mid + 1;
			} else
				return mid;
		}
		return -1;

	}

	public static void bubbleSort(int[] arr) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		display(arr);
	}

	public static void selectionSort(int[] arr) {

		for (int counter = 0; counter < arr.length - 1; counter++) {
			int min = counter;

			for (int j = counter + 1; j <= arr.length - 1; j++) {
				if (arr[j] < arr[min]) {
					min = j;
				}

				if (min != counter) {
					int temp = arr[counter];
					arr[counter] = arr[min];
					arr[min] = temp;
				}
			}
		}
		display(arr);

	}

	public static void insertionSort(int[] arr) {

		for (int counter = 1; counter <= arr.length - 1; counter++) {
			int val = arr[counter];
			int j = counter - 1;

			while (j >= 0 && arr[j] > val) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = val;
		}

	}
}
