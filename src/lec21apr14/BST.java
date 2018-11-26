package lec21apr14;

public class BST {

	private class Node {

		int data;
		Node left;
		Node right;
	}

	private Node root;
	private int size;

	public BST(int[] in) {
		this.root = construct(in, 0, in.length - 1);
	}

	private Node construct(int[] in, int ilo, int ihi) {

		if (ilo > ihi) {
			return null;
		}

		Node nn = new Node();

		int mid = (ihi + ilo) / 2;

		nn.data = in[mid];

		nn.left = construct(in, ilo, mid - 1);
		nn.right = construct(in, mid + 1, ihi);

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

		if (node.right == null) {
			return node.data;
		}
		return max(node.right);
	}

	public int min() {
		int min = min(this.root);
		return min;
	}

	private int min(Node node) {
		if (node.left == null) {
			return node.data;
		}
		return min(node.left);
	}

	public boolean find(int item) {
		return find(item, this.root);
	}

	private boolean find(int item, Node node) {
		if (node == null) {
			return false;
		}

		if (item > node.data) {
			return find(item, node.right);
		} else if (item < node.data) {
			return find(item, node.left);
		} else {
			return true;
		}

	}

	public void displayDecreasing() {
		displayDecreasing(this.root);
		System.out.println();
	}

	private void displayDecreasing(Node node) {

		if (node == null) {
			return;
		}

		displayDecreasing(node.right);
		System.out.print(node.data + " ");
		displayDecreasing(node.left);

	}

	public void printRange(int ll, int ul) {
		printRange(this.root, ll, ul);
	}

	private void printRange(Node node, int ll, int ul) {

		if (node == null) {
			return;
		}

		if (ll > node.data) {
			printRange(node.right, ll, ul);
		} else if (ul < node.data) {
			printRange(node.left, ll, ul);
		} else {
			printRange(node.left, ll, ul);
			System.out.println(node.data);
			printRange(node.right, ll, ul);
		}

	}

	private class Sum {
		int sum;
	}

	public void replaceWithSumLarger() {

		replaceWithSumLarger(this.root, new Sum());
	}

	private void replaceWithSumLarger(Node node, Sum s) {

		if (node == null) {
			return;
		}

		replaceWithSumLarger(node.right, s);
		int rd = node.data;
		node.data = s.sum;
		s.sum = s.sum + rd;
		replaceWithSumLarger(node.left, s);

	}

	public void kthLargest(int kth) {
		kMover km = new kMover();
		km.k = kth;
		kthLargest(this.root, km);
	}

	private class kMover {
		int k;
	}

	private void kthLargest(Node node, kMover km) {

		if (node == null || km.k <= 0) {
			return;
		}

		kthLargest(node.right, km);

		if (km.k == 1) {
			System.out.println(node.data);
		}

		km.k = km.k - 1;
		kthLargest(node.left, km);
	}

	public void addNode(int n) {
		addNode(this.root, n);
	}

	private void addNode(Node node, int n) {

		if (n > node.data) {
			if (node.right == null) {
				Node nn = new Node();
				nn.data = n;
				node.right = nn;
			} else {
				addNode(node.right, n);
			}
		} else if (n <= node.data) {
			if (node.left == null) {
				Node nn = new Node();
				nn.data = n;
				node.left = nn;
			} else {
				addNode(node.left, n);
			}
		}

	}

	public void delNode(int n) {
		delNode(null, this.root, false, n);
	}

	public void delNode(Node parent, Node node, boolean iLc, int n) {

		if (n > node.data) {
			delNode(node, node.right, false, n);
		} else if (n < node.data) {
			delNode(node, node.left, true, n);
		} else {
			if (iLc) {
				if (node.left == null && node.right == null) {
					parent.left = null;
				} else if (node.left == null && node.right != null) {
					parent.left = node.right;
				} else if (node.left != null && node.right == null) {
					parent.left = node.left;
				} else {
					node.data = this.max(node.left);
					delNode(node, node.left, true, node.data);
				}
			} else {
				if (node.left == null && node.right == null) {
					parent.right = null;
				} else if (node.left == null && node.right != null) {
					parent.right = node.right;
				} else if (node.left != null && node.right == null) {
					parent.right = node.left;
				} else {
					node.data = this.min(node.right);
					delNode(node, node.right, false, node.data);
				}
			}
		}
	}

	// public void delNode(int n) {
	// delNode(this.root, null, n);
	// }
	//
	// private void delNode(Node node, Node parent, int n) {
	// if (node == null) {
	// return;
	// }
	// if (n > node.data) {
	// delNode(node.right, node, n);
	//
	// } else if (n < node.data) {
	// delNode(node.left, node, n);
	// } else {
	//
	// if (parent.right.data == n) {
	// if (node.left == null && node.right == null) {
	// parent.right = null;
	// } else if (node.left == null && node.right != null) {
	// parent.right = node.right;
	// } else if (node.left != null && node.right == null) {
	// parent.right = node.left;
	// } else {
	// parent.right.data = this.max(node.right);
	// delNode(node, node.right, this.max(node));
	// }
	// } else {
	// if (node.left == null && node.right == null) {
	// parent.left = null;
	// } else if (node.left == null && node.right != null) {
	// parent.left = node.right;
	// } else if (node.left != null && node.right == null) {
	// parent.left = node.left;
	// } else {
	// parent.left.data = this.max(node.left);
	// delNode(node, node.left, this.max(node.left));
	// }
	// }
	// }
	// }

	
	
}
