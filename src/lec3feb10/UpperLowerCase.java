package lec3feb10;

import java.util.Scanner;

public class UpperLowerCase {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		char ch = sc.nextLine().charAt(0);
		
		if(ch >= 'a' && ch<='z')
		{
			System.out.println("lowercase");
		}
		else if(ch >= 'A' && ch<='Z')
		{System.out.println("UPPERCASE");
		
		}
		else {
			System.out.println("Invalid");
		}

	}

}
