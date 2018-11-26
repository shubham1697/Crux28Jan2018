package lec5feb17;

import java.util.ArrayList;

public class ArrayListDemo {

	public static void main(String[] args) {
		
		ArrayList<Integer> list = new ArrayList<>();
		
		System.out.println(list);
		list.add(10);
		list.add(20);
		list.add(30);
		list.add(40);
		System.out.println(list);
		
		System.out.println(list.get(0));
		System.out.println(list.get(1));
		System.out.println(list.get(2));
		System.out.println(list.get(3));
		
		list.set(0, 1);
		list.set(1, 11);
		list.set(2, 22);
		list.set(3, 33);
		System.out.println(list);
		
		list.add(2, 16);
		System.out.println(list);
		
		
	}

}
