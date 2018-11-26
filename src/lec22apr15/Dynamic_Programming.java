package lec22apr15;

public class Dynamic_Programming {

	public static void main(String[] args) {
		int n = 50;

		long clkstart = System.currentTimeMillis();

		 System.out.println(fibonacciDPRec(n, new int[n + 1]));
		 System.out.println(fibonacciDPit(n));
		 System.out.println(fibonaciDPitSlider(n));
		// System.out.println(boardPathDPRec(0, 10, new int[11]));
		// System.out.println(boardPathDPite(10));
		// System.out.println(boardPathDPitSlider(10));
		// System.out.println(strangeMonetorySys(10000000));
		// System.out.println(mazePathDPRec(0, 0, 2, 2, new int[3][3]));
		// System.out.println(mazePathDPit(3, 4));
		// System.out.println(mazePathDPitSlider(2, 2));
		// System.out.println(mazePathDiagonalDP(2, 2));

//		System.out.println(longestCommonSub("Saturday", "Sunday"));
//		System.out.println(lCSDPite("Saturday", "Sunday"));
		

		//
		// long clkend = System.currentTimeMillis();
		// System.out.println(clkend - clkstart);

	}

	public static int fibonacciDPRec(int n, int[] strg) {

		if (n == 0 || n == 1) {
			return n;
		}

		if (strg[n] != 0) {
			return strg[n];
		}

		int fb1 = fibonacciDPRec(n - 1, strg);
		int fb2 = fibonacciDPRec(n - 2, strg);

		int fn = fb1 + fb2;
		strg[n] = fn;

		return strg[n];
	}

	public static int fibonacciDPit(int n) {

		int[] strg = new int[n + 1];
		strg[0] = 0;
		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			strg[i] = strg[i - 1] + strg[i - 2];
		}

		return strg[n];
	}

	public static int fibonaciDPitSlider(int n) {
		int[] strg = new int[2];
		strg[0] = 0;
		if (n == 0) {
			return strg[0];
		}

		strg[1] = 1;

		for (int i = 2; i <= n; i++) {
			int temp = strg[0] + strg[1];

			strg[0] = strg[1];
			strg[1] = temp;
		}
		return strg[1];
	}

	public static int strangeMonetorySys(int n) {
		if (n == 0 || n == 1) {
			return n;
		}
		int n1 = 0, n2 = 0, n3 = 0;

		if ((float) n / 2 == n / 2)
			n1 = strangeMonetorySys(n / 2);
		if ((float) n / 3 == n / 3)
			n2 = strangeMonetorySys(n / 3);
		if ((float) n / 4 == n / 4)
			n3 = strangeMonetorySys(n / 4);

		return Math.max(n, n1 + n2 + n3);
	}

	public static int boardPathDPRec(int curr, int end, int[] strg) {

		if (curr == end) {
			return 1;
		}

		if (curr > end) {
			return 0;
		}
		if (strg[curr] != 0) {
			return strg[curr];
		}
		int count = 0;
		for (int dr = 1; dr <= 6; dr++) {
			count += boardPathDPRec(curr + dr, end, strg);
		}
		strg[curr] = count;
		return count;
	}

	public static int boardPathDPite(int n) {

		int[] strg = new int[n + 6];

		strg[n] = 1;

		for (int i = n - 1; i >= 0; i--) {
			strg[i] = strg[i + 1] + strg[i + 2] + strg[i + 3] + strg[i + 4] + strg[i + 5] + strg[i + 6];
		}

		return strg[0];
	}

	public static int boardPathDPitSlider(int n) {
		int[] strg = new int[6];
		strg[0] = 1;

		for (int i = n - 1; i >= 0; i--) {
			int sum = strg[0] + strg[1] + strg[2] + strg[3] + strg[4] + strg[5];

			strg[5] = strg[4];
			strg[4] = strg[3];
			strg[3] = strg[2];
			strg[2] = strg[1];
			strg[1] = strg[0];
			strg[0] = sum;
		}
		return strg[0];
	}

	public static int mazePathDPRec(int cr, int cc, int er, int ec, int[][] strg) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cr == er && cc == ec) {

			return 1;
		}
		if (strg[cr][cc] != 0) {
			return strg[cr][cc];
		}

		int ch = mazePathDPRec(cr, cc + 1, er, ec, strg);
		int cv = mazePathDPRec(cr + 1, cc, er, ec, strg);

		strg[cr][cc] = ch + cv;
		return strg[cr][cc];

	}

	// O(n^2)
	public static int mazePathDPit(int er, int ec) {
		int cc = 0;
		int cr = 0;
		int[][] strg = new int[er + 1][ec + 1];

		strg[er][ec] = 1;

		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er || j == ec)
					strg[i][j] = 1;
				else
					strg[i][j] = strg[i + 1][j] + strg[i][j + 1];
			}
		}
		return strg[0][0];
	}

	// O(n)
	public static int mazePathDPitSlider(int er, int ec) {

		int cc = 0;
		int cr = 0;

		int[] strg = new int[ec + 1];

		strg[ec] = 1;

		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er || j == ec) {
					strg[j] = 1;
				} else
					strg[j] = strg[j + 1] + strg[j];
			}
		}

		return strg[0];

	}

	public static int mazePathDiagonalDP(int er, int ec) {

		int cc = 0;
		int cr = 0;
		int[] strg = new int[ec + 1];

		strg[ec] = 1;
		int diag = 0;

		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er || j == ec) {
					strg[j] = 1;
					diag = 1;
				} else {
					int val = strg[j + 1] + strg[j] + diag;
					diag = strg[j];
					strg[j] = val;
				}
			}
		}
		return strg[0];

	}

	public static int longestCommonSub(String s1, String s2) {

		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}

		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);

		String ros1 = s1.substring(1);
		String ros2 = s2.substring(1);

		int ans = 0;

		if (ch1 == ch2) {
			ans = longestCommonSub(ros1, ros2) + 1;
		} else {
			int c1 = longestCommonSub(s1, ros2);
			int c2 = longestCommonSub(ros1, s2);

			ans = Math.max(c1, c2);
		}
		return ans;
	}

	public static int lCSDPite(String s1, String s2) {

		int[][] strg = new int[s1.length() + 1][s2.length() + 1];

		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {

				if (s1.charAt(i) == s2.charAt(j)) {
					strg[i][j] = strg[i + 1][j + 1] + 1;
				} else {
					int c1 = strg[i + 1][j];
					int c2 = strg[i][j + 1];

					strg[i][j] = Math.max(c1, c2);
				}
			}

		}
		return strg[0][0];

	}

}
