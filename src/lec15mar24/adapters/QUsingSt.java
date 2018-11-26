package lec15mar24.adapters;

import lec15mar24.Dynamic_Stack.DynamicStack;

public class QUsingSt {

	DynamicStack prStack;

	public QUsingSt() {
		prStack = new DynamicStack();
	}

	public void enqueue(int item) throws Exception {
		try {
			prStack.push(item);
		} catch (Exception e) {
			throw new Exception("Queue is full");
		}
	}

	public int dequeue() throws Exception {

		DynamicStack helper = new DynamicStack();

		try {
			while (prStack.size() != 1) {
				helper.push(prStack.pop());
			}
			int val = prStack.pop();
			while (!helper.isEmpty()) {
				prStack.push(helper.pop());
			}
			return val;

		} catch (Exception e) {
			throw new Exception("Stack is Full");
		}

	}

	public void display() throws Exception {
		if (prStack.isEmpty()) {
			return;
		}
		int val = prStack.pop();
		display();
		prStack.push(val);
		System.out.println(val);

	}

	public int size() {
		return prStack.size();
	}
	
	public boolean isEmpty() {
		return prStack.isEmpty();
	}

	public void getFirst() throws Exception {
		if(prStack.size()==1) {
			int val = prStack.pop();
			System.out.println(val);
			prStack.push(val);
			return;
		}
		int val = prStack.pop();
		getFirst();
		prStack.push(val);
	}
}
