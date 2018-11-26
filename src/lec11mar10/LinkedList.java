package lec11mar10;

public class LinkedList {

	private class Node {
		int data;
		Node next;
	}

	private Node head;
	private Node tail;
	private int size;

	public int size() {
		return this.size;
	}

	public boolean isEmpty() {
		return this.size == 0;
	}

	// O(1)
	public int getFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.head.data;
	}

	// O(1)
	public int getLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		return this.tail.data;
	}

	// O(n)
	public int getAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp.data;
	}

	// O(n)
	private Node getNodeAt(int idx) throws Exception {

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		Node temp = this.head;
		for (int i = 0; i < idx; i++) {
			temp = temp.next;
		}

		return temp;
	}

	// O(1)
	public void addLast(int item) {

		// create a new node
		Node nn = new Node();

		// update
		nn.data = item;
		nn.next = null;

		// attach
		if (this.size > 0)
			this.tail.next = nn;

		// summary update
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.tail = nn;
			this.size++;
		}
	}

	// O(1)
	public void addFirst(int item) {

		// new node
		Node nn = new Node();

		// update
		nn.data = item;
		nn.next = null;

		// attach
		nn.next = this.head;

		// update summary
		if (this.size == 0) {
			this.head = nn;
			this.tail = nn;
			this.size++;
		} else {
			this.head = nn;
			this.size++;
		}

	}

	// O(n)
	public void addAt(int item, int idx) throws Exception {

		if (idx < 0 || idx > this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			addFirst(item);
		} else if (idx == this.size) {
			addLast(item);
		} else {
			// new node
			Node nn = new Node();

			// update
			nn.data = item;
			nn.next = null;

			// attach
			Node nm1 = getNodeAt(idx - 1);
			Node np1 = nm1.next;

			nm1.next = nn;
			nn.next = np1;

			this.size++;
		}

	}

	// O(n)
	public void display() {

		System.out.println("------------------------");

		Node temp = this.head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}

		System.out.println(".");
		System.out.println("------------------------");
	}

	// O(1)
	public int removeFirst() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node temp = this.head;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			this.head = this.head.next;
			this.size--;
		}

		return temp.data;
	}

	// O(n)
	public int removeLast() throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		Node temp = this.tail;

		if (this.size == 1) {
			this.head = null;
			this.tail = null;
			this.size = 0;
		} else {
			Node sm2 = getNodeAt(this.size - 2);
			this.tail = sm2;
			this.tail.next = null;
			this.size--;
		}

		return temp.data;
	}

	// O(n)
	public int removeAt(int idx) throws Exception {

		if (this.size == 0) {
			throw new Exception("LL is Empty.");
		}

		if (idx < 0 || idx >= this.size) {
			throw new Exception("Invalid Index.");
		}

		if (idx == 0) {
			return this.removeFirst();
		} else if (idx == this.size - 1) {
			return this.removeLast();
		} else {
			Node nm1 = getNodeAt(idx - 1);
			Node n = nm1.next;
			Node np1 = n.next;

			nm1.next = np1;

			this.size--;
			return n.data;

		}
	}

	public void revDataIteratively() throws Exception {
		for (int i = 0, j = this.size() - 1; i < this.size() / 2; i++, j--) {
			Node a = this.getNodeAt(i);
			Node b = this.getNodeAt(j);
			int temp = a.data;
			a.data = b.data;
			b.data = temp;

		}
	}

	public void revPointerIteratively() {
		Node prev = null;
		Node curr = this.head;

		while (curr != null) {
			Node next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		Node temp = this.head;
		this.head = this.tail;
		this.tail = temp;
		this.tail.next = null;
	}

	public void revPointerRec() {
		revPointerRec(null, this.head);
	}

	private void revPointerRec(Node prev, Node curr) {
		if (curr == null) {
			Node temp = this.head;
			this.head = this.tail;
			this.tail = temp;
			return;
		}
		Node next = curr.next;
		curr.next = prev;
		revPointerRec(curr, next);
	}

	public void revDataRec() throws Exception {
		HeapMover mover = new HeapMover();
		mover.left = this.head;
		revDataRec(mover, this.head, 0);
	}

	public void revDataRec(HeapMover mover, Node right, int count) throws Exception {

		if (right == null) {
			return;
		}

		revDataRec(mover, right.next, count + 1);

		if (count >= this.size() / 2) {
			int temp = mover.left.data;
			mover.left.data = right.data;
			right.data = temp;
		}

		mover.left = mover.left.next;
	}

	public void revDataRecrt() throws Exception {
		revDataRecrt(this.head, this.head, 0);
	}

	public Node revDataRecrt(Node left, Node right, int count) throws Exception {

		if (right == null) {
			return left;
		}

		Node nl = revDataRecrt(left, right.next, count + 1);

		if (count >= this.size() / 2) {
			int temp = nl.data;
			nl.data = right.data;
			right.data = temp;
		}

		return nl.next;
	}

	private class HeapMover {
		Node left;
	}

	public void fold() {

		HeapMover mover = new HeapMover();
		mover.left = this.head;
		fold(mover, this.head, 0);

	}

	public void fold(HeapMover mover, Node right, int count) {
		if (right == null) {
			return;
		}

		fold(mover, right.next, count + 1);

		if (count > this.size() / 2) {
			Node temp = mover.left.next;
			mover.left.next = right;
			right.next = temp;
			mover.left = temp;
		}
		if (count == this.size() / 2) {
			this.tail = right;
			this.tail.next = null;
		}
	}

	public Node midNode() {

		Node left = this.head;
		Node right = this.head;
		while (right.next != null) {
			if (right.next.next != null) {
				left = left.next;
				right = right.next.next;
			} else {
				right = right.next;
			}
		}
		return left;
	}

	public void kthfromLast(int k) {
		Node temp = this.head;
		Node temp2 = this.head;

		for (int count = 0; count < k; count++) {
			temp = temp.next;
		}

		while (temp != null) {
			temp2 = temp2.next;
			temp = temp.next;
		}
		System.out.println(temp2.data);
	}

	public LinkedList mergeTwoSortedLL(LinkedList other) {

		Node temp = this.head;
		Node otemp = other.head;
		LinkedList rv = new LinkedList();

		while (temp != null && otemp != null) {
			if (temp.data > otemp.data) {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			} else {
				rv.addLast(temp.data);
				temp = temp.next;
			}
		}

		if (temp == null) {
			while (otemp != null) {
				rv.addLast(otemp.data);
				otemp = otemp.next;
			}
		}
		if (otemp == null) {
			while (temp != null) {
				rv.addLast(temp.data);
				temp = temp.next;
			}
		}

		return rv;

	}

	public void mergeSort() {

		if (this.size == 1) {
			return;
		}

		Node mid = this.midNode();
		Node midn = mid.next;

		LinkedList fh = new LinkedList();
		fh.head = this.head;
		fh.tail = mid;
		fh.tail.next = null;
		fh.size = (this.size + 1) / 2;

		LinkedList sh = new LinkedList();
		sh.head = midn;
		sh.tail = this.tail;
		sh.tail.next = null;
		sh.size = this.size / 2;

		fh.mergeSort();
		sh.mergeSort();

		LinkedList merged = fh.mergeTwoSortedLL(sh);
		this.head = merged.head;
		this.tail = merged.tail;

	}

	public void kReverse(int k) throws Exception {

		LinkedList prev = null;
		LinkedList curr = null;

		while (this.size != 0) {
			curr = new LinkedList();

			for (int i = 0; i < k; i++) {
				curr.addFirst(this.removeFirst());
			}

			if (prev == null) {
				prev = curr;
			} else {
				prev.tail.next = curr.head;
				prev.tail = curr.tail;
				prev.size += curr.size;
			}
		}
		this.head = prev.head;
		this.tail = prev.tail;
	}

}