package lec15mar24.adapters;

import lec15mar24.Dynamic_Queue.Dynamic_Queue;

public class StackUsingQueue {

	Dynamic_Queue primaryQueue = new Dynamic_Queue();

	// push efficient

//	public void push(int item) throws Exception {
//
//		try {
//			primaryQueue.enqueue(item);
//		} catch (Exception e) {
//			throw new Exception("Stack is Full");
//		}
//	}
//
//	public int pop() throws Exception {
//		Dynamic_Queue helper = new Dynamic_Queue();
//		try {
//			while (primaryQueue.size() != 1) {
//				helper.enqueue(primaryQueue.dequeue());
//			}
//			int val = primaryQueue.dequeue();
//			primaryQueue = helper;
//			return val;
//		} catch (Exception e) {
//			throw new
//
//			Exception("Stack is Empty");
//		}
//	}

	//pop efficient

	public void push(int item) throws Exception {
		Dynamic_Queue helper = new Dynamic_Queue();
		try {
			while (primaryQueue.size() != 0) {
				helper.enqueue(primaryQueue.dequeue());
			}

			primaryQueue.enqueue(item);

			while (helper.size() != 0) {
				primaryQueue.enqueue(helper.dequeue());
			}
		} catch (Exception e) {
			throw new Exception("Stack is full");
		}
	}

	public int pop() throws Exception {
		try {
			return primaryQueue.dequeue();
		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
	}

	public int top() throws Exception {
		Dynamic_Queue helper = new Dynamic_Queue();
		try {
			while (primaryQueue.size() != 1) {
				helper.enqueue(primaryQueue.dequeue());
			}
			int val = primaryQueue.dequeue();
			helper.enqueue(val);
			primaryQueue = helper;
			return val;
		} catch (Exception e) {
			throw new Exception("Stack is Empty");

		}
	}

	public int size() {
		return primaryQueue.size();
	}

	public boolean isEmpty() {
		return primaryQueue.isEmpty();
	}

	public void display() throws Exception {
		display(0);

	}

	public void display(int n) throws Exception {
		if (n == primaryQueue.size()) {
			return;
		}
		try {
			int val = primaryQueue.dequeue();
			primaryQueue.enqueue(val);
			display(n + 1);
			System.out.print(val + " ");
		} catch (Exception e) {
			throw new Exception("Stack is Empty");
		}
	}

}
