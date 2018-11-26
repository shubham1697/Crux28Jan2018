package lec26apr29.Trie;

public class Trie_Client {

	public static void main(String[] args) {

		Trie t = new Trie();

		t.addWord("an");
		t.addWord("and");
		t.addWord("ant");
		t.addWord("be");
		t.addWord("bea");
		t.addWord("been");

		t.display();
		System.out.println();
//		t.displayTrie();
		
		System.out.println(t.search("be"));
		t.remove("been");
		t.display();
		
	}

}
