package lec15mar24;

public class TOH {

	public static void main(String[] args) {

		toh(3, "T1", "T2", "T3");

	}

	public static void toh(int n, String src, String helper, String dst) {

		if (n == 0) {
			return;
		}

		toh(n - 1, src, dst, helper);
		System.out.println("MOVE DISK " + n + " FROM " + src + " TO " + dst);
		toh(n - 1, helper, src, dst);

	}

}
