package lec15mar24.adapters;

public class StUsingQ_Client {

	public static void main(String[] args) throws Exception {

		StackUsingQueue sq = new StackUsingQueue();

		sq.push(1);
		sq.push(2);
		sq.push(3);
		sq.push(4);
		sq.push(5);
		sq.push(6);
		sq.push(7);
		System.out.println(sq.pop());
		System.out.println(sq.pop());
		System.out.println(sq.pop());
//		System.out.println(sq.top());
		System.out.println(sq.size());
		System.out.println(sq.isEmpty());
		sq.display();
	}

}
