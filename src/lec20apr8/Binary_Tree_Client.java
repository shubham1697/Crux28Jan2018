package lec20apr8;

public class Binary_Tree_Client {

	public static void main(String[] args) {
		
		// 10 true 20 true 50 false false true 60 false false true 30 true 40 false false false
		// 500 true 40 true 30 true 15 false false true 35 false false true 45 true 42 false false true 47 false false true 60 true 55 false false true 65 false false
		
		Binary_Trees bt = new Binary_Trees();
		
//		int[] pre = {10,20,50,60,30,40};
//		int[] in = {50,20,60,10,40,30};

//		int[] pre = {500,40,30,15,35,45,42,47,60,55,65};
//		int[] in = {15,30,25,40,42,45,47,500,55,60,65};
//		
//		Binary_Trees bt = new Binary_Trees(pre,in);
		
//		bt.display();
//		System.out.println(bt.size2());
//		System.out.println(bt.max());
//		System.out.println(bt.find(70));
//		System.out.println(bt.height());
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameterPair());
//		System.out.println(bt.isBalanced());
//		bt.preOrderIterative();
//		bt.postOrderIterative();
//		bt.inOrderIterative();
//		bt.preOrderRec();
//		bt.postOrderRec();
//		bt.inOrderRec();
//		bt.LargestBST();
		bt.levelOrderLineW();
	
		
	}

}
