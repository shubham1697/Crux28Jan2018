package lec10mar4.queue;

public class Queue {

	protected int front,size;
	protected int[] data;
	
	public Queue() {
		this(5);
	}
	
	public Queue(int cap) {
		this.front = 0;
		this.size = 0;
		this.data = new int[cap];
	}
	
	public void enqueue(int item) throws Exception {
		
		if(size == this.data.length) {
			throw new Exception("Queue is full");
		}
		
		int n1 = (this.front + this.size) % this.data.length;
		this.data[n1] = item;
		this.size++;
	}
	
	public int dequeue() throws Exception {
		
		if(size == 0) {
			throw new Exception("Queue is Empty");
		}
		
		int rv = this.data[this.front];
		
		this.data[this.front] = 0;
		this.front = (this.front + 1) % this.data.length;
		this.size--;
		return rv;
	}
	
	public int getFirst() throws Exception {
		
		if(size == 0) {
			throw new Exception("Queue is Empty");
		}
		
		return this.data[this.front];
	}
	
	public int size() {
		return this.size;
	}
	
	public boolean isEmpty() {
		return this.size == 0;
	}
	
	public void display() {
		System.out.println("--------------");
		for(int i =0;i<size;i++) {
			int m = (this.front + i) % this.data.length;
			System.out.print(this.data[m] + " ");
		}
		System.out.println();
		System.out.println("--------------");
	}

}
