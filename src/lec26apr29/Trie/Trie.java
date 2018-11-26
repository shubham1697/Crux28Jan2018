package lec26apr29.Trie;

import java.util.ArrayList;
import java.util.HashMap;

public class Trie {

	private class Node {
		char ch;
		boolean eow;

		HashMap<Character, Node> table;

		public Node(char ch) {
			this.ch = ch;
			this.eow = false;
			this.table = new HashMap<>();
		}

	}

	private Node root = new Node('*');

	// public Trie() {
	// this.root = new Node('*');
	// }

	public void addWord(String word) {
		this.addWord(this.root, word);
	}

	private void addWord(Node parent, String word) {
		if (word.length() == 0) {
			parent.eow = true;

			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = parent.table.get(ch);
		if (child == null) {

			child = new Node(ch);
			parent.table.put(ch, child);
			addWord(child, row);
		} else {
			addWord(child, row);
		}

	}

	public void display() {

		display(this.root, "");
	}

	private void display(Node node, String asf) {

		if (node.eow) {
			System.out.println(asf);
		}
		ArrayList<Character> keys = new ArrayList<>(node.table.keySet());
		for (Character ch : keys) {
			display(node.table.get(ch), asf + ch);
		}

	}

	public void displayTrie() {
		displayTrie(this.root);
	}

	private void displayTrie(Node node) {

		ArrayList<Character> keys = new ArrayList<>(node.table.keySet());

		String str = node.ch + " => ";

		for (char ch : keys) {
			str += " " + ch;
		}
		str = str + ".";
		System.out.println(str);

		for (char ch : keys) {
			displayTrie(node.table.get(ch));
		}
	}

	public boolean search(String n) {
		return search(this.root, n);
	}

	private boolean search(Node parent, String word) {

		if (word.length() == 0) {
			return parent.eow;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = parent.table.get(ch);
		if (child == null) {
			return false;
		} else {
			search(parent.table.get(ch), row);
		}

		return true;

	}

	public void remove(String word) {
		remove(this.root, word);
	}

	private void remove(Node parent, String word) {

		if (word.length() == 0) {
			parent.eow = false;
			return;
		}

		char ch = word.charAt(0);
		String row = word.substring(1);

		Node child = parent.table.get(ch);
		if (child == null) {
			return;
		} else {
			remove(parent.table.get(ch), row);

			if (child.table.size() == 0 && !child.eow) {
				parent.table.remove(ch);
			}
		}

	}

}
