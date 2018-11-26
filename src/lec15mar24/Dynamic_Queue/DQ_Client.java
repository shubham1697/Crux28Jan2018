package lec15mar24.Dynamic_Queue;

public class DQ_Client {

	public static void main(String[] args) throws Exception {

		Dynamic_Queue dq = new Dynamic_Queue();

		dq.enqueue(1);
		dq.enqueue(2);
//		dq.dequeue();
		dq.enqueue(3);
		dq.enqueue(5);
//		dq.dequeue();
		dq.enqueue(6);
		dq.enqueue(7);
		dq.dequeue();
		dq.dequeue();
		dq.enqueue(8);
		dq.enqueue(90);

		dq.display();

	}

}
