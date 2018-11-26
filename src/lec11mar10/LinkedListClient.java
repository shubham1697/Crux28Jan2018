package lec11mar10;

public class LinkedListClient {
	
	public static void main(String[] args) throws Exception {

		LinkedList list = new LinkedList();
		list.addLast(90);
		list.addLast(20);
		list.addLast(70);
		list.addLast(40);
		list.addLast(50);
		list.addLast(60);
		list.addLast(80);
		list.addLast(10);
		list.addLast(30);
//		list.addFirst(60);
//		list.addFirst(70);

		list.display();
//		list.revDataIteratively();
//		list.revPointerIteratively();
//		list.revPointerRec();
//		list.revDataRec();
//		list.revDataRecrt();
//		list.midNode();
//		list.addAt(100, 2);
//		list.fold();
//		list.kthfromLast(5);
//		list.display();
//		list.removeFirst();
//		list.display();
//		list.removeLast();
//		list.display();
//		list.removeAt(2);
//		list.display();
//		System.out.println(list.size());
		
		list.mergeSort();
		list.display();
		list.kReverse(3);
		list.display();

	}

}
