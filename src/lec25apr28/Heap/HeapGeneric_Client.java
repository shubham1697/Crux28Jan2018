package lec25apr28.Heap;

import java.lang.reflect.Array;
import java.util.ArrayList;

import lec23apr21.Cars;

public class HeapGeneric_Client {

	public static void main(String[] args) {

		HeapGeneric<Cars> h = new HeapGeneric<>();

		// Cars[] cars = new Cars[5];
		// cars[0] = new Cars("A", 256, 2000);
		// cars[1] = new Cars("B", 300, 1500);
		// cars[2] = new Cars("C", 500, 500);
		// cars[3] = new Cars("D", 250, 1000);
		// cars[4] = new Cars("E", 350, 1800);
		//
		// h.add(cars[0]);
		// h.add(cars[1]);
		// h.add(cars[2]);
		// h.add(cars[3]);
		// h.add(cars[4]);

		// System.out.println(h.remove());
		// System.out.println(h.remove());
		// System.out.println(h.remove());
		// System.out.println(h.remove());
		// System.out.println(h.remove());

		// ArrayList<ArrayList<Integer>> list = new ArrayList<>();
		//
		// list.add(new ArrayList<>());
		// list.add(new ArrayList<>());
		// list.add(new ArrayList<>());
		//
		// list.get(0).add(2);
		// list.get(0).add(5);
		// list.get(0).add(8);
		// list.get(0).add(10);
		// list.get(0).add(15);
		//
		// list.get(1).add(10);
		// list.get(1).add(30);
		// list.get(1).add(50);
		// list.get(1).add(80);
		//
		// list.get(2).add(1);
		// list.get(2).add(3);
		// list.get(2).add(7);
		// list.get(2).add(8);
		// list.get(2).add(9);
		//
		// System.out.println(mergekSortedList(list));

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

	}

	public static class Pair implements Comparable<Pair> {

		int data;
		int listno;
		int idxno;

		public Pair(int data, int listno, int idxno) {
			this.data = data;
			this.listno = listno;
			this.idxno = idxno;
		}

		@Override
		public int compareTo(Pair other) {
			// TODO Auto-generated method stub
			return other.data - this.data;
		}

	}

	public static ArrayList<Integer> mergekSortedList(ArrayList<ArrayList<Integer>> list) {

		ArrayList<Integer> ans = new ArrayList<>();

		HeapGeneric<Pair> heap = new HeapGeneric<>();

		for (int i = 0; i < list.size(); i++) {
			Pair np = new Pair(list.get(i).get(0), i, 0);
			heap.add(np);
		}
		while (!(heap.size() == 0)) {
			Pair rp = heap.remove();
			ans.add(rp.data);

			rp.idxno++;
			if (rp.idxno < list.get(rp.listno).size()) {
				rp.data = list.get(rp.listno).get(rp.idxno);
				heap.add(rp);
			}
		}

		return ans;

	}

	public static ArrayList<Integer> kelements(ArrayList<Integer> list, int k) {

		ArrayList<Integer> ans = new ArrayList<>();
		HeapGeneric<Integer> heap = new HeapGeneric<>();

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
