package lec17mar31.genericTree;

import java.util.Scanner;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class GenericTree_Client {

	static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {

		
		GenericTree_Client gc = new GenericTree_Client();
		GenericTree gt = gc.new GenericTree();
		int n = sc.nextInt();
		// GenericTree gt2 = new GenericTree();

		// 10 3 20 2 50 0 60 0 30 0 40 1 70 0
		// 10 3 20 2 50 0 60 2 100 0 110 0 30 1 200 0 40 3 70 0 80 2 120 0 130 0 90 0
		// System.out.println();
		// gt.display();
		// gt2.display();
		// System.out.println("Size of tree: " + gt.size());
		// System.out.println("Size of tree: " + gt.size2());
		// System.out.println("max: "+gt.max());
		// System.out.println("Height: "+gt.height());
		// int item = sc.nextInt();
		// System.out.println(gt.find(item));
		// System.out.println();
		// gt.mirrorImage();
		// gt.display();
		// System.out.println();
		// System.out.println(gt.structSimilar(gt2));

		// gt.preOrder();
		// System.out.println();
		// gt.postOrder();
//		System.out.println();

		// gt.levelOrder();
//		System.out.println();
		 gt.levelOrderLineW();
//		gt.levelOrderZZag();
//		System.out.println(gt.multiSolver(n));
//		gt.preOrderIteratively();

	}



 public class GenericTree {

		private class Node {
			int data;
			ArrayList<Node> children = new ArrayList<>();
		}

		private Node root;
		private int size = 0;

		public GenericTree() {

			this.root = construct(sc, null, -1);

		}

		private Node construct(Scanner sc, Node parent, int ith) {

			if (parent == null) {
				System.out.println("Enter data for parent node: ");
			} else {
				System.out.println("Enter data for " + ith + "th child of " + parent.data);
			}

			int val = sc.nextInt();
			Node nn = new Node();
			this.size++;
			nn.data = val;

			System.out.println("No. of children for " + nn.data + ": ");
			int noc = sc.nextInt();

			for (int i = 0; i < noc; i++) {
				Node child = construct(sc, nn, i);
				nn.children.add(child);
			}
			return nn;
		}

		public void display() {
			display(root);
		}

		private void display(Node node) {
			String str = node.data + " --> ";

			for (int i = 0; i < node.children.size(); i++) {
				str += node.children.get(i).data + ",";
			}
			str = str + ".";
			System.out.println(str);

			for (int i = 0; i < node.children.size(); i++) {
				display(node.children.get(i));
			}

		}

		public int size() {
			return this.size;
		}

		int size2() {
			int s = size2(this.root);
			return s;
		}

		private int size2(Node node) {
			int tcs = 0;

			for (Node node1 : node.children) {
				tcs += size2(node1);
			}

			return tcs + 1;
		}

		public int max() {
			int max = max(this.root);
			return max;
		}

		private int max(Node node) {
			int max = node.data;
			for (int i = 0; i < node.children.size(); i++) {
				int max1 = max(node.children.get(i));

				if (max < max1) {
					max = max1;
				}
			}
			return max;
		}

		public int height() {
			int h = height(this.root);
			return h;
		}

		private int height(Node node) {

			int h = -1;

			for (Node node1 : node.children) {
				int tcs = height(node1);
				if (h < tcs) {
					h = tcs;
				}
			}
			return h + 1;
		}

		public boolean find(int item) {
			return find(item, this.root);
		}

		private boolean find(int item, Node node) {

			if (node.data == item) {
				return true;
			}

			for (Node node1 : node.children) {
				if (find(item, node1)) {
					return true;
				}
			}
			return false;
		}

		public void mirrorImage() {
			mirrorImage(this.root);
		}

		private void mirrorImage(Node node1) {

			for (int i = 0, j = node1.children.size() - 1; i < node1.children.size() / 2; i++, j--) {
				Node temp = node1.children.get(i);
				node1.children.set(i, node1.children.get(j));
				node1.children.set(j, temp);

			}
			for (Node node : node1.children) {
				mirrorImage(node);
			}

		}

		public boolean structSimilar(GenericTree g2) {
			return structSimilar(this.root, g2.root);
		}

		private boolean structSimilar(Node node1, Node node2) {

			if (node1.children.size() != node2.children.size()) {
				return false;
			}

			for (int i = 0; i < node1.children.size(); i++) {
				if (!structSimilar(node1.children.get(i), node2.children.get(i))) {
					return false;
				}
			}
			return true;

		}

		public void preOrder() {
			preOrder(this.root);
		}

		private void preOrder(Node node) {

			System.out.println(node.data);

			for (Node node1 : node.children) {
				preOrder(node1);
			}

		}

		public void postOrder() {
			postOrder(this.root);
		}

		private void postOrder(Node node) {

			for (Node node1 : node.children) {
				postOrder(node1);
			}
			System.out.println(node.data);

		}

		public void levelOrder() {
			levelOrder(this.root);
		}

		private void levelOrder(Node node) {

			LinkedList<Node> ll = new java.util.LinkedList<>();
			ll.add(node);

			while (!ll.isEmpty()) {
				Node n1 = ll.removeFirst();
				System.out.print(n1.data + " ");
				for (Node node1 : n1.children) {
					ll.addLast(node1);
				}
			}
		}

		public void levelOrderLineW() {
			levelOrderLineW(this.root);
		}

		private void levelOrderLineW(Node node) {
			LinkedList<Node> ll = new LinkedList<>();
			ll.addLast(node);
			LinkedList<Node> ll2 = new LinkedList<>();

			while (!ll.isEmpty()) {
				Node n1 = ll.removeFirst();
				System.out.print(n1.data + " ");
				for (Node node1 : n1.children) {
					ll2.addLast(node1);
				}
				if (ll.isEmpty()) {
					System.out.println();

					LinkedList<Node> temp = ll;
					ll = ll2;
					ll2 = temp;
				}
			}
		}

		public void levelOrderZZag() {
			levelOrderZZag(this.root);
		}

		private void levelOrderZZag(Node node) {

			LinkedList<Node> ll = new LinkedList<>();
			ll.addLast(node);
			LinkedList<Node> ll2 = new LinkedList<>();
			int row = 0;

			while (!ll.isEmpty()) {
				Node n1 = ll.removeFirst();
				System.out.print(n1.data + " ");
				if (row % 2 == 0) {
					for (Node node1 : n1.children) {
						ll2.addFirst(node1);
					}
				} else {
					for (int i = n1.children.size() - 1; i >= 0; i--) {
						ll2.addFirst(n1.children.get(i));
					}

				}

				if (ll.isEmpty()) {
					System.out.println();
					row++;
					LinkedList<Node> temp = ll;
					ll = ll2;
					ll2 = temp;
				}
			}

		}

		public int multiSolver(int item) {

			heapMover mover = new heapMover();

			multiSolver(this.root, item, 0, mover);

//			System.out.println("size: " + mover.size);
//			System.out.println("max: " + mover.max);
//			System.out.println("find: " + mover.find);
//			System.out.println("height: " + mover.ht);
//			System.out.println("just larger: " + ((mover.jstLarge == null) ? null : mover.jstLarge.data));
//			System.out.println("predecessor: " + ((mover.predecessor == null) ? null : mover.predecessor.data));
//			System.out.println("successor: " + ((mover.successor == null) ? null : mover.successor.data));
			return mover.jstLarge.data;

		}

		public void multiSolver(Node node, int item, int depth, heapMover mover) {

			mover.size++;

			if (node.data > mover.max) {
				mover.max = node.data;
			}

			if (mover.find && mover.successor == null) {
				mover.successor = node;

			}

			if (node.data > item) {
				if (mover.jstLarge == null) {
					mover.jstLarge = node;
				}
				if (node.data < mover.jstLarge.data) {
					mover.jstLarge = node;
				}
			}

			if (node.data == item) {
				mover.find = true;

			}

			if (!mover.find) {
				mover.predecessor = node;
			}

			if (depth > mover.ht) {
				mover.ht = depth;
			}

			for (Node child : node.children) {
				multiSolver(child, item, depth + 1, mover);
			}
		}

		private class heapMover {

			int size;
			int max = Integer.MIN_VALUE;
			boolean find;
			int ht;
			Node predecessor;
			Node successor;
			Node jstLarge;

		}

		private class OrderPair {
			Node node;
			boolean selfDone;
			int childDone;

		}

		public void preOrderIteratively() {

			LinkedList<OrderPair> stack = new LinkedList<>();

			OrderPair tp = new OrderPair();

			tp.node = this.root;
			stack.addFirst(tp);

			while (!stack.isEmpty()) {
				tp = stack.getFirst();
				if (tp.selfDone == false) {
					System.out.println(tp.node.data);
					tp.selfDone = true;
				} else if (tp.childDone < tp.node.children.size()) {
					OrderPair np = new OrderPair();
					np.node = tp.node.children.get(tp.childDone);
					stack.addFirst(np);
					tp.childDone++;
				} else {
					stack.removeFirst();
				}

			}

		}

	}

}
