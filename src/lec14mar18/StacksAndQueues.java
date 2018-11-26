package lec14mar18;

import lec10mar4.queue.Queue;
import lec10mar4.stack.Stack;

public class StacksAndQueues {

	public static void main(String[] args) throws Exception {
		//
		// Stack stack = new Stack();
		// stack.push(10);
		// stack.push(20);
		// stack.push(30);
		// stack.push(40);
		// stack.push(50);
		//
		// stack.display();
		// displayRevStack(stack);
		// stack.display();
		//
		// Stack s1 = new Stack();
		// revStack(stack,s1);
		// stack.display();

		Queue queue = new Queue();
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		queue.display();
		
//		 revQueue(queue);
		displayRevQueue(0, queue);
		 queue.display();

	}

	public static void displayRevStack(Stack s) throws Exception {

		if (s.isEmpty()) {
			return;
		}
		int val = s.pop();
		displayRevStack(s);
		s.push(val);

		System.out.println(val);

	}

	public static void revStack(Stack s, Stack s1) throws Exception {

		if (s.isEmpty()) {
			if (s1.isEmpty()) {
				return;
			}
			int val = s1.pop();
			revStack(s, s1);
			s.push(val);
			return;
		}

		int val = s.pop();

		s1.push(val);
		revStack(s, s1);

	}

	public static void displayRevQueue(int n,Queue q) throws Exception {
		
		if(n==q.size()) {
			return;
		}
		int val = q.dequeue();
		q.enqueue(val);
		displayRevQueue(n+1,q);
		System.out.println(val);
		
	}

	public static void revQueue(Queue q) throws Exception {
		if (q.isEmpty()) {
			return;
		}
		int val = q.dequeue();
		System.out.println(val);
		revQueue(q);
		q.enqueue(val);

	}
}
