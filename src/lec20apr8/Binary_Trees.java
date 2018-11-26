package lec20apr8;

import java.util.LinkedList;
import java.util.Scanner;

import hb.trees.BT_levelOrder.Binary_Trees.Node;

/**
 * @author uChiHA_itACHi
 *
 */
public class Binary_Trees {

	private class Node {

		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public Binary_Trees() {
		this.root = construct(new Scanner(System.in), this.root, false);
	}

	private Node construct(Scanner sc, Node parent, boolean iLC) {

		if (parent == null) {
			System.out.println("Enter the data for root node: ");
		} else {
			if (iLC) {
				System.out.println("Enter the data for left child of " + parent.data + ": ");
			} else {
				System.out.println("Enter the data for right child of " + parent.data + ": ");
			}
		}

		Node nn = new Node();
		this.size++;
		nn.data = sc.nextInt();

		System.out.println("does " + nn.data + " have a left child: ");
		boolean lc = sc.nextBoolean();

		if (lc) {
			nn.left = construct(sc, nn, true);
		}

		System.out.println("does " + nn.data + " have a right child: ");
		boolean rc = sc.nextBoolean();

		if (rc) {
			nn.right = construct(sc, nn, false);
		}

		return nn;

	}

	public Binary_Trees(int[] pre, int[] in) {
		this.root = construct(pre, 0, pre.length - 1, in, 0, in.length - 1);
	}

	private Node construct(int[] pre, int plo, int phi, int[] in, int ilo, int ihi) {

		if (plo > phi) {
			return null;
		}

		Node nn = new Node();
		nn.data = pre[plo];

		int si = -1;
		int i = ilo;
		while (i <= ihi) {
			if (in[i] == pre[plo]) {
				si = i;
				break;
			}
			i++;
		}

		int nel = si - ilo;

		nn.left = construct(pre, plo + 1, plo + nel, in, ilo, si - 1);
		nn.right = construct(pre, plo + nel + 1, phi, in, si + 1, ihi);

		return nn;
	}

	public void display() {
		display(this.root);
	}

	private void display(Node node) {

		if (node == null) {
			return;
		}

		String str;

		if (node.left != null) {
			str = "" + node.left.data;
		} else {
			str = ".";
		}

		str = str + "-->" + node.data + "<--";

		if (node.right != null) {
			str = str + node.right.data;
		} else {
			str = str + ".";
		}

		System.out.println(str);

		display(node.left);
		display(node.right);

	}

	public int size2() {
		int s = size2(this.root);
		return s;
	}

	private int size2(Node node) {

		if (node == null) {
			return 0;
		}

		int lc = size2(node.left);
		int rc = size2(node.right);

		return lc + rc + 1;
	}

	public int max() {
		int max = max(this.root);
		return max;
	}

	private int max(Node node) {

		if (node == null) {
			return Integer.MIN_VALUE;
		}

		int max = node.data;
		int lm = max(node.left);
		int rm = max(node.right);

		return Math.max(max, Math.max(lm, rm));
	}

	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {
		if (node == null) {
			return false;
		}

		if (find(item, node.left) || find(item, node.right)) {
			return true;
		} else {
			if (node.data == item) {
				return true;
			} else {
				return false;
			}
		}

	}

	public int height() {
		int ht = height(this.root);
		return ht;
	}

	private int height(Node node) {

		if (node == null) {
			return -1;
		}

		int lht = height(node.left);
		int rht = height(node.right);

		return Math.max(lht, rht) + 1;
	}

	public int diameter() {
		int d = diameter(this.root);
		return d;
	}

	private int diameter(Node node) {
		if (node == null) {
			return 0;
		}

		int ld = diameter(node.left);
		int rd = diameter(node.right);
		int sd = height(node.left) + height(node.right) + 2;

		return Math.max(ld, Math.max(rd, sd));

	}

	private class Pair {
		int height;
		int diameter;
		boolean flag = true;
	}

	public int diameterPair() {
		Pair pair = diameterPair(this.root);
		return pair.diameter;
	}

	private Pair diameterPair(Node node) {

		if (node == null) {
			Pair br = new Pair();
			br.diameter = 0;
			br.height = -1;
			return br;
		}

		Pair mr = new Pair();

		Pair lr = diameterPair(node.left);
		Pair rr = diameterPair(node.right);
		int ld = lr.diameter;
		int rd = rr.diameter;

		int sp = lr.height + rr.height + 2;

		mr.diameter = Math.max(ld, Math.max(rd, sp));
		mr.height = Math.max(lr.height, rr.height) + 1;

		return mr;
	}

	public boolean isBalanced() {
		Pair pair = isBalanced(this.root);
		return pair.flag;
	}

	private Pair isBalanced(Node node) {

		if (node == null) {
			Pair br = new Pair();
			br.diameter = 0;
			br.height = -1;
			br.flag = true;
			return br;
		}
		Pair mr = new Pair();

		Pair lr = isBalanced(node.left);
		Pair rr = isBalanced(node.right);
		int lh = lr.height;
		int rh = rr.height;
		int r = lh - rh;

		if ((r != 0 && r != 1 && r != -1) || (lr.flag == false) || rr.flag == false) {
			mr.flag = false;
		}

		mr.height = Math.max(lh, rh) + 1;

		return mr;

	}

	public void preOrderRec() {
		preOrderRec(this.root);
	}

	private void preOrderRec(Node node) {
		if (node == null) {
			return;
		}
		System.out.println(node.data);
		preOrderRec(node.left);
		preOrderRec(node.right);

	}

	public void postOrderRec() {
		postOrderRec(this.root);
	}

	private void postOrderRec(Node node) {
		if (node == null) {
			return;
		}
		postOrderRec(node.left);
		postOrderRec(node.right);
		System.out.println(node.data);

	}

	public void inOrderRec() {
		inOrderRec(this.root);
	}

	private void inOrderRec(Node node) {
		if (node == null) {
			return;
		}
		inOrderRec(node.left);
		System.out.println(node.data);
		inOrderRec(node.right);

	}

	private class OrderPair {
		Node node;
		boolean selfDone;
		boolean leftDone;
		boolean rightDone;
	}

	public void preOrderIterative() {

		LinkedList<OrderPair> stack = new LinkedList<>();

		OrderPair tp = new OrderPair();

		tp.node = this.root;
		stack.addFirst(tp);

		while (!stack.isEmpty()) {
			tp = stack.getFirst();

			if (tp.selfDone == false) {
				System.out.println(tp.node.data);
				tp.selfDone = true;
			} else if (tp.leftDone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);
				}
				tp.leftDone = true;
			} else if (tp.rightDone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightDone = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	public void inOrderIterative() {

		LinkedList<OrderPair> stack = new LinkedList<>();

		OrderPair tp = new OrderPair();

		tp.node = this.root;
		stack.addFirst(tp);

		while (!stack.isEmpty()) {
			tp = stack.getFirst();

			if (tp.leftDone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);
				}
				tp.leftDone = true;
			} else if (tp.selfDone == false) {
				System.out.println(tp.node.data);
				tp.selfDone = true;
			}

			else if (tp.rightDone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightDone = true;
			} else {
				stack.removeFirst();
			}

		}

	}

	public void postOrderIterative() {

		LinkedList<OrderPair> stack = new LinkedList<>();

		OrderPair tp = new OrderPair();

		tp.node = this.root;
		stack.addFirst(tp);

		while (!stack.isEmpty()) {
			tp = stack.getFirst();

			if (tp.leftDone == false) {
				if (tp.node.left != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.left;
					stack.addFirst(np);

				}
				tp.leftDone = true;
			} else if (tp.rightDone == false) {
				if (tp.node.right != null) {
					OrderPair np = new OrderPair();
					np.node = tp.node.right;
					stack.addFirst(np);
				}
				tp.rightDone = true;
			} else if (tp.selfDone == false) {
				System.out.println(tp.node.data);
				tp.selfDone = true;
			}

			else {
				stack.removeFirst();
			}

		}
	}

	private class bstPair {
		Node largestBstNode;
		boolean isBST;
		int size;
		int min;
		int max;

	}

	public void LargestBST() {

		System.out.println(largestBST(this.root).largestBstNode.data);

	}

	private bstPair largestBST(Node node) {

		if (node == null) {
			bstPair br = new bstPair();
			br.isBST = true;
			br.max = Integer.MIN_VALUE;
			br.min = Integer.MAX_VALUE;
			br.size = 0;
			return br;
		}

		bstPair right = largestBST(node.right);
		bstPair left = largestBST(node.left);

		bstPair mr = new bstPair();

		mr.max = Math.max(node.data, Math.max(left.max, right.max));
		mr.min = Math.min(node.data, Math.min(left.min, right.min));

		if (left.isBST && right.isBST && node.data < right.min && node.data > left.max) {
			mr.isBST = true;
			mr.largestBstNode = node;
			mr.size = left.size + right.size + 1;
		} else {
			mr.isBST = false;
			if (left.size > right.size) {
				mr.largestBstNode = left.largestBstNode;
				mr.size = left.size;
			} else {
				mr.largestBstNode = right.largestBstNode;
				mr.size = right.size;
			}

		}
		return mr;

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
			if (n1.left != null)
				ll2.addLast(n1.left);
			if (n1.right != null)
				ll2.addLast(n1.right);

			if (ll.isEmpty()) {
				System.out.println();

				LinkedList<Node> temp = ll;
				ll = ll2;
				ll2 = temp;
			}
		}

	}
}
