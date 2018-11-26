package lec25apr28.Heap;

import java.util.ArrayList;

import lec25apr28.Heap.HeapGeneric_Client.Pair;

public class HeapGeneric<T extends Comparable<T>> {

	ArrayList<T> data = new ArrayList<>();

	public void add(T item) {
		data.add(item);
		upHeapify(this.data.size() - 1);

	}

	private void upHeapify(int ci) {

		int pi = (ci - 1) / 2;

		if (isLarger(data.get(ci), data.get(pi)) > 0) {

			swap(pi, ci);
			upHeapify(pi);

		}

	}

	private void swap(int i, int j) {

		T ith = data.get(i);
		T jth = data.get(j);

		data.set(i, jth);
		data.set(j, ith);

	}

	public T get() {
		return this.data.get(0);
	}

	public void display() {
		System.out.println(data);
	}

	public int size() {
		return this.data.size();
	}

	public T remove() {

		swap(0, this.data.size() - 1);
		T rv = data.remove(data.size() - 1);
		downheapify(0);
		return rv;

	}

	private void downheapify(int pi) {

		int lci = 2 * pi + 1;
		int rci = 2 * pi + 2;

		int mini = pi;

		if (lci < this.data.size() && isLarger(data.get(lci), data.get(mini)) > 0) {
			mini = lci;
		}

		if (rci < this.data.size() && isLarger(data.get(rci), data.get(mini)) > 0) {
			mini = rci;
		}

		if (mini != pi) {
			swap(mini, pi);
			downheapify(mini);
		}

	}

	private int isLarger(T t, T v) {
//		return t.compareTo(v);
		return v.compareTo(t);
	}
	

}
