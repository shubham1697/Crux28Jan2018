package lec10mar4.stack;

import java.util.EmptyStackException;

public class Stack {

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
