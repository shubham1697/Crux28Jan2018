package lec24apr22.HashMaps;

import java.util.ArrayList;
import java.util.HashMap;

public class HashMapsDemo {

	public static void main(String[] args) {

		int[] arr1 = { 1, 2, 3, 0, 1, 7, 8, 1, 2, 7, 7 };
		int[] arr2 = { 1, 1, 2, 2, 2, 3, 3, 3 };

		// ArrayList<Integer> list1 = findDuplicates(arr1, arr2);
		// System.out.println(list1);

		int[] arr = { 2, 12, 9, 16, 10, 5, 3, 20, 25, 11, 1, 8, 9 };
		ArrayList<Integer> list2 = longestConsecutiveNo(arr);
		System.out.println(list2);

	}

	public static ArrayList<Integer> findDuplicates(int[] arr1, int[] arr2) {

		ArrayList<Integer> list = new ArrayList<>();

		HashMap<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < arr1.length; i++) {
			if (!map.containsKey(arr1[i])) {
				map.put(arr1[i], 1);
			} else {
				int val = map.get(arr1[i]);
				map.put(arr1[i], val + 1);
			}
		}

		for (int i = 0; i < arr2.length; i++) {
			if (map.containsKey(arr2[i]) && map.get(arr2[i]) > 0) {
				list.add(arr2[i]);
				int val = map.get(arr2[i]);
				map.put(arr2[i], val - 1);
			}
		}
		return list;

	}

	public static ArrayList<Integer> longestConsecutiveNo(int[] arr) {

		ArrayList<Integer> list = new ArrayList<>();

		HashMap<Integer, Boolean> map = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {

			int val = arr[i];
			if (map.containsKey(val - 1)) {
				map.put(arr[i], false);
			} else {
				map.put(arr[i], true);
			}

			if (map.containsKey(val + 1)) {
				map.put(val + 1, false);
			}

		}

		int mcount = Integer.MIN_VALUE;
		int seqStart = 0;

		for (int i = 0; i < arr.length; i++) {

			int count = 0;

			if (map.get(arr[i])) {
				while (map.containsKey(arr[i] + count)) {
					count++;
				}
			}
			if (count > mcount) {
				mcount = count;
				seqStart = arr[i];
			}

		}

		for (int i = 0; i < mcount; i++) {
			list.add(seqStart + i);
		}
		return list;
	}
}
