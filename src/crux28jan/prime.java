package crux28jan;

import java.util.Scanner;

public class prime {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int flag = 0;
		
		int i = 2 ;
		while (i < n) {
			if(n%i==0)
			{
				System.out.println("Not Prime");
				flag=1;
				break;
				}
			
			i++;
		}
		
		if(flag==0)
		{
			System.out.println("Prime");
		}
	
	}

}
