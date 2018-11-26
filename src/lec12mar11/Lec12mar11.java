package lec12mar11;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Lec12mar11 {

	public static void main(String[] args) {

//		 System.out.println(getSS("abc"));
		 System.out.println(getSSwAscii("ab"));
//
//		Scanner sc = new Scanner(System.in);
//		 String s = sc.nextLine();
//		 System.out.println(KPC("140"));
//
//		 System.out.println(Permutation("abc"));
//		 ArrayList<String> mr = BoardPath(0, 10);
//		 System.out.println(mr.size());
//		 System.out.println(mr);
//		 System.out.println(MazePath(0, 0, 2, 2));
//		System.out.println(MazePathwithDiagonal(0, 0, 2, 2));
//		System.out.println(MazePathDiagonalwithmultimoves(0, 0, 2,2));

	}

	public static ArrayList<String> getSS(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSS(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs);
			mr.add(ch + rrs);
		}

		return mr;
	}

	public static ArrayList<String> getSSwAscii(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);
		String ros = str.substring(1);

		ArrayList<String> rr = getSSwAscii(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			mr.add(rrs);
			mr.add(ch + rrs);
			mr.add((int) ch + rrs);

		}
		return mr;
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

	public static ArrayList<String> KPC(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		ArrayList<String> rr = KPC(ros);

		ArrayList<String> mr = new ArrayList<>();

		String code = getCode(ch);

		for (int i = 0; i < code.length(); i++) {
			for (String rrs : rr) {
				mr.add(code.charAt(i) + rrs);
			}
		}

		return mr;

	}

	public static ArrayList<String> Permutation(String str) {

		if (str.length() == 0) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		char ch = str.charAt(0);

		String ros = str.substring(1);

		ArrayList<String> rr = Permutation(ros);

		ArrayList<String> mr = new ArrayList<>();

		for (String rrs : rr) {
			for (int i = 0; i <= rrs.length(); i++) {
				mr.add(rrs.substring(0, i) + ch + rrs.substring(i));
			}
		}

		return mr;
	}

	public static ArrayList<String> BoardPath(int curr, int end) {

		if (curr > end) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		if (curr == end) {
			ArrayList<String> br = new ArrayList<>();
			br.add("\n");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();
		for (int dr = 1; dr <= 6; dr++) {
			ArrayList<String> rr = BoardPath(curr + dr, end);

			for (String rrs : rr) {
				mr.add(dr + "" + rrs);
			}
		}

		return mr;

	}

	public static ArrayList<String> MazePath(int cr, int cc, int er, int ec) {

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rr1 = MazePath(cr, cc + 1, er, ec);
		for (String rrs : rr1) {
			mr.add("H" + rrs);
		}
		ArrayList<String> rr2 = MazePath(cr + 1, cc, er, ec);
		for (String rrs : rr2) {
			mr.add("V" + rrs);
		}

		return mr;
	}

	public static ArrayList<String> MazePathwithDiagonal(int cr, int cc, int er, int ec) {

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		ArrayList<String> rr1 = MazePathwithDiagonal(cr, cc + 1, er, ec);
		for (String rrs : rr1) {
			mr.add("H" + rrs);
		}
		ArrayList<String> rr2 = MazePathwithDiagonal(cr + 1, cc, er, ec);
		for (String rrs : rr2) {
			mr.add("V" + rrs);
		}
		ArrayList<String> rr3 = MazePathwithDiagonal(cr + 1, cc + 1, er, ec);
		for (String rrs : rr3) {
			mr.add("D" + rrs);
		}

		return mr;
	}

	public static ArrayList<String> MazePathDiagonalwithmultimoves(int cr, int cc, int er, int ec) {

		if (cr > er || cc > ec) {
			ArrayList<String> br = new ArrayList<>();
			return br;
		}

		if (cr == er && cc == ec) {
			ArrayList<String> br = new ArrayList<>();
			br.add("");
			return br;
		}

		ArrayList<String> mr = new ArrayList<>();

		for (int i = 1; i <= ec; i++) {
			ArrayList<String> rr1 = MazePathDiagonalwithmultimoves(cr, cc + i, er, ec);
			for (String rrs : rr1) {
				mr.add("H"+i + rrs);
			}
		}
		for (int i = 1; i <= er; i++) {
			ArrayList<String> rr2 = MazePathDiagonalwithmultimoves(cr + i, cc, er, ec);
			for (String rrs : rr2) {
				mr.add("V"+i + rrs);
			}
		}
		for (int i = 1; i <= er && i <= ec; i++) {
			ArrayList<String> rr3 = MazePathDiagonalwithmultimoves(cr + i, cc + i, er, ec);
			for (String rrs : rr3) {
				mr.add("D" +i+ rrs);
			}
		}

		return mr;
	}

}
