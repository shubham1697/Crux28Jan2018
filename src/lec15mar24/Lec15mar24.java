package lec15mar24;

import java.util.EmptyStackException;

public class Lec15mar24 {

	public static void main(String[] args) throws Exception {

		int[] arr = { 10, 5, 7, 6, 11, 9 };
		int[] span = StockSpan(arr);
		for (int i = 0; i < span.length; i++) {
			System.out.println(span[i]);
		}

	}

	public static int[] StockSpan(int[] price) throws Exception {

		Lec15mar24 sc = new Lec15mar24();
		Stack stack = sc.new Stack(price.length);

		int[] span = new int[price.length];
		stack.push(0);
		span[0] = 1;

		for (int i = 1; i < price.length; i++) {
			while (!stack.isEmpty() && price[i] > price[stack.top()]) {
				stack.pop();
			}
			if (stack.isEmpty()) {
				span[i] = i + 1;
			} else {
				span[i] = i - stack.top();
			}
			stack.push(i);
		}

		return span;
	}
	

	

	private class Stack {

		protected int tos;
		protected int[] data;

		public Stack() {
			this(5);
		}

		public Stack(int cap) {
			
			this.tos = -1;
			this.data = new int[cap];
		}
		
		public void push(int item) throws Exception {
			if(this.tos==this.data.length) {
				throw new IndexOutOfBoundsException("Stack is full");
			}
			this.tos++;
			this.data[tos] = item;
		}
		
		public int pop() throws Exception{
			if(this.tos == -1) {
				throw new Exception("Stack is Empty");
			}
			int val = this.data[tos];
			this.data[tos] = 0;
			this.tos--;
			return val;
		}
		
		public int top() {
			return this.data[tos];
		}
		
		public boolean isEmpty() {
			return this.tos==-1;
		}
		
		public int size() {
			return this.tos+1;
		}
		
		public void display(){
			System.out.println("--------------");
			
			for(int i=tos;i>=0;i--) {
				System.out.print(this.data[i]+" ");
			}
			System.out.println();
			System.out.println("--------------");
		}

	}

}
