package lec25apr28.Heap;

import java.util.ArrayList;

public class Heap_client {

	public static void main(String[] args) {

		// Heap h = new Heap();
		//
		// h.add(60);
		// h.add(50);
		// h.add(40);
		// h.add(30);
		// h.add(20);
		// h.add(10);
		//
		// h.display();

		// System.out.println(h.remove());
		// System.out.println(h.remove());
		// System.out.println(h.remove());
		// System.out.println(h.size());
		// h.display();

		ArrayList<Integer> list = new ArrayList<>();
		list.add(30);
		list.add(2);
		list.add(8);
		list.add(60);
		list.add(5);
		list.add(10);
		list.add(20);
		list.add(50);
		list.add(80);

		System.out.println(kelements(list, 3));
		
		
		// h.display();
	}

	public static ArrayList<Integer> kelements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		Heap heap = new Heap();

		int i = 0;
		for (; i < k; i++) {
			heap.add(list.get(i));
		}

		while (i < list.size()) {

			if (heap.get() < list.get(i)) {
				heap.remove();
				heap.add(list.get(i));
			}
			i++;

		}

		while (heap.size() != 0) {
			ans.add(heap.remove());
		}

		return ans;

	}

}
