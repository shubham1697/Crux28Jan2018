package lec14mar18;

public class RecursionPrint {

	public static void main(String[] args) {

		// System.out.println(nQueen(new boolean[4][4], 0, ""));
		NKnights(new boolean[2][2], 0, 0, "", 0);
		// int[] arr = { 1, 3, 5, 7, 0 };

		// splitArray(arr, 0, 0, 0, "", "");

	}

	public static int nQueen(boolean[][] board, int row, String asf) {

		if (row == board.length) {
			System.out.println(asf);
			return 1;
		}

		int count = 0;

		for (int col = 0; col < board[0].length; col++) {

			if (isitSafe(board, row, col)) {
				board[row][col] = true;
				count += nQueen(board, row + 1, asf + "{" + row + "," + col + "}");
				board[row][col] = false;
			}
		}
		return count;
	}

	public static boolean isitSafe(boolean[][] board, int row, int col) {

		int r = row;
		int c = col;

		// Vertical
		while (r >= 0) {
			if (board[r][c] == true)
				return false;
			r--;
		}

		// leftDiagonal
		r = row;
		c = col;
		while (r >= 0 && c >= 0) {
			if (board[r][c] == true)
				return false;
			r--;
			c--;
		}

		// rightDiagonal
		r = row;
		c = col;
		while (r >= 0 && c < board[0].length) {
			if (board[r][c] == true)
				return false;
			r--;
			c++;
		}
		return true;
	}

	public static void NKnights(boolean[][] board, int row, int col, String asf, int kpsf) {

		if (kpsf == board.length) {
			System.out.println(asf);
			return;
		}

		for (int c = col; c < board[0].length; c++) {
			if (isitSafeKnight(board, row, c)) {
				board[row][c] = true;
				NKnights(board, row, c + 1, asf + "{" + row + ", " + c + "}", kpsf + 1);
				board[row][c] = false;
			}
		}

		for (int r = row + 1; r < board.length; r++) {
			for (int c = 0; c < board[0].length; c++) {
				if (isitSafeKnight(board, r, c)) {
					board[r][c] = true;
					NKnights(board, r, c + 1, asf + "{" + r + ", " + c + "}", kpsf + 1);
					board[r][c] = false;
				}
			}
		}
	}

	public static boolean isitSafeKnight(boolean[][] board, int r, int c) {
		if (r - 1 >= 0 && c - 2 >= 0 && board[r - 1][c - 2]) {
			return false;
		}

		if (r - 1 >= 0 && c + 2 < board.length && board[r - 1][c + 2]) {
			return false;
		}

		if (r - 2 >= 0 && c - 1 >= 0 && board[r - 2][c - 1]) {
			return false;
		}

		if (r - 2 >= 0 && c + 1 < board.length && board[r - 2][c + 1]) {
			return false;
		}

		return true;
	}

	public static void splitArray(int[] arr, int vidx, int g1Sum, int g2Sum, String g1asf, String g2asf) {

		if (vidx == arr.length) {
			if (g1Sum == g2Sum)
				System.out.println(g1asf + "and " + g2asf);
			return;
		}

		splitArray(arr, vidx + 1, g1Sum + arr[vidx], g2Sum, g1asf + arr[vidx] + " ", g2asf);
		splitArray(arr, vidx + 1, g1Sum, g2Sum + arr[vidx], g1asf, g2asf + arr[vidx] + " ");

	}
}
