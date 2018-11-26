package crux28jan;

import java.util.Scanner;

public class allprimes {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		if(n==2)
		{
			System.out.println(n);
		}
		
		else
		{
		int a=2;
		 while(a<=n)
		 {
				int i=2;
				 int flag=0;

			 while(i<a)
			 {
				
				 if(a%i==0)
				 {
					 flag=1;
				 }
				 i++;
						 
			 }
			 if(flag==0)
			 {
				 System.out.println(a);
			 }
			 a++;
			 
		 }
		
		}
	}

}
