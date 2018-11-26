package lec6feb18;

import java.util.ArrayList;

public class ArrayListD {

	public static void main(String[] args) {

		int[] one = { 1,2,3,1,2,4,1 };
		int[] two = { 2,1,3,1,5,2,2 };

		System.out.println(intersection(one, two));

		int[] arr1 = { 8, 6, 7, 5 };
		int[] arr2 = { 9, 5, 4, 1, 9 };

		System.out.println(sum(arr1, arr2));
		
		int[] arr3 = {0,1,0,2,2,1,1,2,0,0,1,0,2,0};

	}

	public static ArrayList<Integer> intersection(int[] one, int[] two) {

		ArrayList<Integer> ins = new ArrayList<>();

		int i = 0;
		int j = 0;

		while (i < one.length && j < two.length) {

			if (one[i] == two[j]) {
				ins.add(two[j]);
				i++;
				j++;
			} else if (one[i] < two[j]) {
				i++;
			} else
				j++;
		}
		return ins;
	}

	public static ArrayList<Integer> sum(int[] arr1, int[] arr2) {

		ArrayList<Integer> sum = new ArrayList<>();
		int carry=0;
		int i=arr1.length-1;
		int j=arr2.length-1;
		
		while(i>=0 || j>=0) {
			int s = carry;
			
			if(i>=0)
				s +=arr1[i];
			
			if(j>=0)
				s +=arr2[j];
			
			int rem = s%10;
			sum.add(0,rem);
			carry = s/10;
			
			i--;
			j--;
		}
		if(carry!=0) {
			sum.add(0,carry);
		}
		
		return sum;
	}

	public static void sort(int[] arr3) {

		
	
	}
	
	
	
}
