package lec13mar17;

public class RecursionPrint {

	public static void main(String[] args) {

//		 System.out.println(printSS("abc", ""));;
//		 printSSwithAscii("abc", "");
		// System.out.println(KPC("123", ""));
		// System.out.println(permutation("aabc", ""));
		// lexicalCount(0, 1000);
		// remDuplicates("aabc", "");
		 lexPermutation("bac", "",false);
		// coin(3, "");
		// coinNoConsecutiveHeads(3, "", 0);
		// System.out.println(boardPath(0, 10, ""));
		// System.out.println(mazePath(0, 0, 2, 2, ""));
//		System.out.println(mazePathDiagonal(0, 0, 2, 2, ""));
//		System.out.println(mazePathmultiMoves(0, 0, 2, 2, ""));

		// mazePathDiagonal(0, 0, 2, 2, "");
		// mazePathmultiMoves(0, 0, 2, 2, "");

	}

	public static int printSS(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		int no = printSS(ros, ans);
		int yes = printSS(ros, ans + ch);

		return no + yes;
	}

	public static int printSSwithAscii(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}
		char ch = ques.charAt(0);
		String ros = ques.substring(1);

		int no = printSSwithAscii(ros, ans);
		int yes = printSSwithAscii(ros, ans + ch);

		int asc = printSSwithAscii(ros, ans + (int) ch);

		return no + yes + asc;

	}

	public static String getCode(char ch) {

		if (ch == '1')
			return "abc";
		else if (ch == '2')
			return "def";
		else if (ch == '3')
			return "ghi";
		else if (ch == '4')
			return "jk";
		else if (ch == '5')
			return "lmno";
		else if (ch == '6')
			return "pqr";
		else if (ch == '7')
			return "st";
		else if (ch == '8')
			return "uv";
		else if (ch == '9')
			return "wx";
		else if (ch == '0')
			return "yz";
		else
			return "";

	}

	public static int KPC(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		char ch = ques.charAt(0);

		String ros = ques.substring(1);

		String code = getCode(ch);
		int count = 0;

		for (int i = 0; i < code.length(); i++) {

			char ch1 = code.charAt(i);
			count += KPC(ros, ans + ch1);

		}

		return count;
	}

	public static int permutation(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return 1;
		}

		int res = 0;

		for (int i = 0; i < ques.length(); i++) {

			char ch = ques.charAt(i);
			String roq = ques.substring(0, i) + ques.substring(i + 1);

			res += permutation(roq, ans + ch);

		}

		return res;

	}

	public static void lexicalCount(int curr, int end) {

		if (curr > end) {
			return;
		}
		System.out.println(curr);
		for (int i = 0; i <= 9; i++) {
			if (curr == 0 && i == 0) {
				i = i + 1;
			}
			lexicalCount(curr * 10 + i, end);

		}

	}

	public static void remDuplicates(String ques, String ans) {

		if (ques.length() == 0) {
			System.out.println(ans);
			return;
		}

		for (int i = 0; i < ques.length(); i++) {
			int flag = 0;
			char ch = ques.charAt(i);
			for (int j = i + 1; j < ques.length(); j++) {
				if (ch == ques.charAt(j)) {
					flag = 1;
				}
			}

			String roq = ques.substring(0, i) + ques.substring(i + 1);

			if (flag == 0)
				permutation(roq, ans + ch);

		}

		return;
	}

	public static void lexPermutation(String ques, String ans, boolean isLarger) {

		if (ques.length() == 0) {
			if (isLarger)
				System.out.println(ans);
			return;
		}

		if (isLarger) {
			for (int i = 0; i < ques.length(); i++) {
				char ch = ques.charAt(i);

				String roq = ques.substring(0, i) + ques.substring(i + 1);
				lexPermutation(roq, ans + ch, true);
			}
		}

		else {

			for (int i = 0; i < ques.length(); i++) {

				char ch = ques.charAt(i);

				String roq = ques.substring(0, i) + ques.substring(i + 1);

				if (ch > ques.charAt(0))
					lexPermutation(roq, ans + ch, true);
				else if (ch < ques.charAt(0)) {
				} else
					lexPermutation(roq, ans + ch, false);
			}
		}
	}

	public static void coin(int n, String ans) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		coin(n - 1, ans + "H");
		coin(n - 1, ans + "T");

	}

	public static void coinNoConsecutiveHeads(int n, String ans, int flag) {

		if (n == 0) {
			System.out.println(ans);
			return;
		}

		if (flag != 1) {
			coinNoConsecutiveHeads(n - 1, ans + "H", 1);
		}
		coinNoConsecutiveHeads(n - 1, ans + "T", 0);

	}

	public static int boardPath(int curr, int end, String ans) {

		if (curr == end) {
			System.out.println(ans);
			return 1;
		}

		if (curr > end) {
			return 0;
		}
		int count = 0;
		for (int dr = 1; dr <= 6; dr++) {
			count += boardPath(curr + dr, end, ans + dr);

		}
		return count;
	}

	public static int mazePath(int cr, int cc, int er, int ec, String ans) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}
		int count = 0;

		count += mazePath(cr, cc + 1, er, ec, ans + "H");
		count += mazePath(cr + 1, cc, er, ec, ans + "V");

		return count;

	}

	public static int mazePathDiagonal(int cr, int cc, int er, int ec, String ans) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		count += mazePathDiagonal(cr, cc + 1, er, ec, ans + "H");
		count += mazePathDiagonal(cr + 1, cc, er, ec, ans + "V");
		count += mazePathDiagonal(cr + 1, cc + 1, er, ec, ans + "D");

		return count;
	}

	public static int mazePathmultiMoves(int cr, int cc, int er, int ec, String ans) {

		if (cr > er || cc > ec) {
			return 0;
		}

		if (cr == er && cc == ec) {
			System.out.println(ans);
			return 1;
		}

		int count = 0;

		for (int i = 1; i <= er; i++) {
			count += mazePathmultiMoves(cr + i, cc, er, ec, ans + "H" + i);
		}
		for (int i = 1; i <= ec; i++) {
			count += mazePathmultiMoves(cr, cc + i, er, ec, ans + "V" + i);
		}
		for (int i = 1; i <= er && i <= ec; i++) {
			count += mazePathmultiMoves(cr + i, cc + i, er, ec, ans + "D" + i);
		}

		return count;

	}
	
	public static void cutTheRod(int n, int[] larr,int[] parr) {
		
	}

}
