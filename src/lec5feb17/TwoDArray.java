package lec5feb17;

import java.util.Scanner;

public class TwoDArray {

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		int[][] arr1 = { { 1, 2, 3 }, { 4, 5, 6 } };
		int[][] arr2 = { { 2, 3 }, { 3, 4 }, { 4, 5 } };
		int[][] arr = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 1, 2, 3 }, { 4, 5, 6, 7 } };
		// takeInput();
		 display(arr);
//		 verticalDisplay(arr);
		 waveDisplay(arr);
//		 spiralDisplay(arr);
//		mulArr(arr1, arr2);
	}

	public static int[][] takeInput() {

		System.out.print("No. Of Rows: ");
		int row = sc.nextInt();
		int[][] arr = new int[row][];

		for (int i = 0; i < arr.length; i++) {
			System.out.println("Col in" + i + "th row: ");
			int col = sc.nextInt();
			arr[i] = new int[col];

			for (int j = 0; j < arr[i].length; j++) {
				System.out.println("val for [" + i + "," + j + "]");
				arr[i][j] = sc.nextInt();
			}
		}
		return arr;

	}

	public static void display(int[][] arr) {
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[i].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}

	}

	public static void verticalDisplay(int[][] jarr) {
		int rows = jarr.length;
		int col = jarr[0].length;

		for (int i = 0; i < col; i++) {
			for (int j = 0; j < rows; j++) {
				System.out.print(jarr[j][i] + " ");
			}
			System.out.println();
		}
	}

	public static void waveDisplay(int[][] jarr) {

		int rows = jarr.length;
		int col = jarr[0].length;

		for (int i = 0; i < col; i++) {

			if (i % 2 == 0) {
				for (int j = 0; j < rows; j++) {
					System.out.print(jarr[j][i] + " ");
				}
			} else {
				for (int j = rows - 1; j >= 0; j--) {
					System.out.print(jarr[j][i] + " ");
				}
			}

			System.out.println();
		}

	}

	public static void spiralDisplay(int[][] jarr) {

		int row_min = 0, col_min = 0;
		int row_max = jarr.length - 1;
		int col_max = jarr[0].length - 1;

		int nel = jarr.length * jarr[0].length;
		int counter = 0;
		while (counter < nel) {
			int j = col_min;
			for (int i = row_min; counter < nel && i <= row_max; i++) {
				System.out.print(jarr[i][col_min] + " ");
				counter++;
			}

			col_min++;

			int i = row_max;
			for (j = col_min; counter < nel && j <= col_max; j++) {
				System.out.print(jarr[row_max][j] + " ");
				counter++;
			}
			row_max--;

			j = col_max;
			for (i = row_max; counter < nel && i >= row_min; i--) {
				System.out.print(jarr[i][col_max] + " ");
				counter++;
			}
			col_max--;

			i = row_min;
			for (j = col_max; counter < nel && j >= col_min; j--) {
				System.out.print(jarr[row_min][j] + " ");
				counter++;
			}
			row_min++;

		}
	}

	public static void mulArr(int[][] arr1, int[][] arr2) {

		int r1 = arr1.length;
		int c1 = arr1[0].length;
		int r2 = arr2.length;
		int c2 = arr2[0].length;
		int cf = c1;

		int[][] mul = new int[r1][c2];

		if (c1 != r2) {

		} else {
			for (int i = 0; i < mul.length; i++) {
				for (int j = 0; j < mul[0].length; j++) {
					int sum = 0;
					for (int k = 0; k < cf; k++) {

						sum = sum + arr1[i][k] * arr2[k][j];

					}
					mul[i][j] = sum;
				}

			}
			display(mul);
		}

	}

}
