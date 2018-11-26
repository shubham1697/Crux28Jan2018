package lec23apr21;

import java.util.Scanner;

public class DynProg {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		String str1 = "Saturday";
		String str2 = "Sunday";

		// System.out.println(editDistance(str1, str2));
		// System.out.println(editDistanceDPBU(str1, str2));
		// int[] arr = { 1, 2, 3, 4 };
		// System.out.println(MatrixMultiplcation(arr, 0, arr.length - 1));
		// System.out.println(MatrixMultiplcationDPTD(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// System.out.println(MatrixMultiplicationDPBU(arr));

		int[] wt = { 1, 3, 4, 5, 7 };
		int[] price = { 1, 4, 5, 7, 7 };
		int cap = 7;
		System.out.println(knapSack(wt, price, 0, cap));
		System.out.println(knapSackDPTD(wt, price, 0, 7, new int[price.length][cap + 1]));
		System.out.println(knapSackDPBU(wt, price, 7));
	}

	public static int editDistance(String str1, String str2) {

		if (str1.length() == 0 && str2.length() == 0) {
			return 0;
		}
		if (str1.length() == 0) {
			return str2.length();
		}
		if (str2.length() == 0) {
			return str1.length();
		}

		char ch1 = str1.charAt(0);
		char ch2 = str2.charAt(0);

		String ros1 = str1.substring(1);
		String ros2 = str2.substring(1);

		int ans;

		if (ch1 == ch2) {
			ans = editDistance(ros1, ros2);
		} else {
			int ins = editDistance(ros1, str2);
			int del = editDistance(str1, ros2);
			int rpl = editDistance(ros1, ros2);

			ans = Math.min(ins, Math.min(del, rpl)) + 1;
		}

		return ans;

	}

	public static int editDistanceDPBU(String str1, String str2) {

		int[][] strg = new int[str1.length() + 1][str2.length() + 1];

		for (int row = str1.length(); row >= 0; row--) {

			for (int col = str2.length(); col >= 0; col--) {

				if (row == str1.length()) {
					strg[row][col] = str2.length() - col;
					continue;
				}
				if (col == str2.length()) {
					strg[row][col] = str1.length() - row;
					continue;
				}

				if (str1.charAt(row) == str2.charAt(col)) {
					strg[row][col] = strg[row + 1][col + 1];
				} else {
					int ins = strg[row + 1][col];
					int del = strg[row][col + 1];
					int rep = strg[row + 1][col + 1];

					strg[row][col] = Math.min(ins, Math.min(del, rep)) + 1;
				}
			}
		}
		return strg[0][0];

	}

	public static int MatrixMultiplcation(int[] arr1, int si, int ei) {

		if (si + 1 == ei) {
			return 0;
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k < ei; k++) {

			int fh = MatrixMultiplcation(arr1, si, k);
			int sh = MatrixMultiplcation(arr1, k, ei);
			int oh = arr1[si] * arr1[k] * arr1[ei];

			int ta = fh + sh + oh;

			if (ta < min) {
				min = ta;
			}
		}

		return min;

	}

	public static int MatrixMultiplcationDPTD(int[] arr1, int si, int ei, int[][] strg) {

		if (si + 1 == ei) {
			return 0;
		}

		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}

		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k < ei; k++) {

			int fh = MatrixMultiplcation(arr1, si, k);
			int sh = MatrixMultiplcation(arr1, k, ei);
			int oh = arr1[si] * arr1[k] * arr1[ei];

			int ta = fh + sh + oh;

			if (ta < min) {
				min = ta;
			}
		}

		strg[si][ei] = min;

		return min;

	}

	public static int MatrixMultiplicationDPBU(int[] arr1) {

		int n = arr1.length;
		int[][] strg = new int[n][n];

		for (int slide = 2; slide < n; slide++) {
			for (int si = 0; si < n - slide; si++) {

				int ei = si + slide;
				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k < ei; k++) {
					int fh = strg[si][k];
					int sh = strg[k][ei];
					int oh = arr1[si] * arr1[k] * arr1[ei];

					int ta = fh + sh + oh;

					if (ta < min) {
						min = ta;
					}
				}
				strg[si][ei] = min;
			}
		}
		return strg[0][n - 1];
	}

	public static int knapSack(int[] wt, int[] price, int vidx, int cap) {

		if (vidx == price.length) {
			return 0;
		}

		int include = 0;
		int exclude = 0;

		if (wt[vidx] <= cap)
			include = price[vidx] + knapSack(wt, price, vidx + 1, cap - wt[vidx]);

		exclude = knapSack(wt, price, vidx + 1, cap);

		return Math.max(include, exclude);
	}

	public static int knapSackDPTD(int[] wt, int[] price, int vidx, int cap, int[][] strg) {

		if (vidx == price.length) {
			return 0;
		}

		if (strg[vidx][cap] != 0) {
			return strg[vidx][cap];
		}

		int include = 0;
		int exclude = 0;

		if (wt[vidx] <= cap)
			include = price[vidx] + knapSack(wt, price, vidx + 1, cap - wt[vidx]);

		exclude = knapSack(wt, price, vidx + 1, cap);

		strg[vidx][cap] = Math.max(include, exclude);

		return Math.max(include, exclude);
	}

	public static int knapSackDPBU(int[] wt, int[] price, int cap) {

		int nr = wt.length + 1;
		int nc = price.length + 1;

		int[][] strg = new int[nr][nc];

		for (int row = 1; row < nr; row++) {
			for (int col = 1; col < nc; col++) {
				int include = 0;
				int exclude = 0;
				if (wt[row - 1] >= cap) {
					// if(col - wt[row - 1] >= 0)
					exclude = strg[row - 1][col];

				} else {

					include = price[row - 1] + strg[row - 1][col - wt[row - 1]];
					exclude = strg[row - 1][col];

				}

				strg[row][col] = Math.max(include, exclude);
			}
		}

		return strg[nr - 1][nc - 1];

	}
}
