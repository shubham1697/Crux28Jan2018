package lec24apr22.HashMaps;

import java.util.LinkedList;

public class HashMap<k, v> {

	public class HMNode {
		k key;
		v value;

		public HMNode(k key, v value) {
			this.key = key;
			this.value = value;
		}
	}

	private LinkedList<HMNode>[] bucketArray;
	private int size;

	public HashMap() {
		this(5);
	}

	public HashMap(int cap) {
		bucketArray = new LinkedList[cap];
		this.size = 0;

		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<>();
		}

	}

	public int hashFunction(k key) {
		int hc = key.hashCode();

		int hi = Math.abs(hc) % bucketArray.length;

		return hi;
	}

	public int findInBucket(LinkedList<HMNode> bucket, k key) {

		for (int i = 0; i < bucket.size(); i++) {
			HMNode node = bucket.get(i);
			if (node.key.equals(key))
				;
			return i;
		}
		return -1;

	}

	public void put(k key, v value) {
		int bi = hashFunction(key);
		int si = findInBucket(bucketArray[bi], key);
		LinkedList<HMNode> bucket = bucketArray[bi];

		if (si == -1) {
			HMNode nn = new HMNode(key, value);
			bucket.add(nn);
			this.size++;
		} else {
			HMNode ntbr = bucket.get(si);
			ntbr.value = value;
		}

		double avgsize = 1.0 * this.size / bucketArray.length;

		if (avgsize > 2.0) {
			reHash();
		}
	}

	public v get(k key) {
		int bi = hashFunction(key);
		int si = findInBucket(bucketArray[bi], key);
		LinkedList<HMNode> bucket = bucketArray[bi];

		if (si == -1) {
			return null;
		} else {
			HMNode nn = bucket.get(si);
			return nn.value;
		}
	}

	public boolean containsKey(k key) {
		int bi = hashFunction(key);
		LinkedList<HMNode> bucket = bucketArray[bi];

		for (int i = 0; i < bucket.size(); i++) {
			HMNode node = bucket.get(i);
			if (node.key.equals(key))
				return true;
		}
		return false;
	}

	public v remove(k key) {
		int bi = hashFunction(key);
		int si = findInBucket(bucketArray[bi], key);
		v val = null;

		LinkedList<HMNode> bucket = bucketArray[bi];

		for (int i = 0; i < bucket.size(); i++) {
			HMNode node = bucket.get(i);
			if (node.key.equals(key)) {
				HMNode nn = bucket.get(si);
				val = nn.value;
				bucket.remove(si);
				this.size--;
			}
		}
		return val;
	}

	public void reHash() {

		LinkedList<HMNode>[] olbA = this.bucketArray;
		this.bucketArray = new LinkedList[2 * olbA.length];
		this.size = 0;

		for (int i = 0; i < bucketArray.length; i++) {
			bucketArray[i] = new LinkedList<>();
		}

		for (int i = 0; i < bucketArray.length; i++) {

			LinkedList<HMNode> bucket = bucketArray[i];

			for (int j = 0; j < bucket.size(); j++) {

				HMNode node = bucket.get(i);
				this.put(node.key, node.value);
			}

		}

	}

	public void display() {
		for (int i = 0; i < bucketArray.length; i++) {
			System.out.print("Bucket " + i + ": ");
			LinkedList<HMNode> bucket = bucketArray[i];

			for (int j = 0; j < bucket.size(); j++) {
				System.out.println(bucket.get(j).key + "@" + bucket.get(j).value + " ");
			}

		}
	}
}
