package lec10mar4.queue;

public class Queue_Client {

	public static void main(String[] args) throws Exception {
		
		Queue queue = new Queue();
		
		queue.enqueue(10);
		queue.enqueue(20);
		queue.enqueue(30);
		queue.enqueue(40);
		queue.enqueue(50);
		
//		queue.enqueue(60);
		
		queue.display();
		
		queue.dequeue();
		queue.dequeue();
		
		queue.display();
		
		System.out.println("First: "+ queue.getFirst());
		System.out.println("Size: "+queue.size());
		System.out.println();
		
		queue.enqueue(60);
		queue.enqueue(70);
		
		System.out.println("First: "+ queue.getFirst());
		System.out.println("Size: "+queue.size());
		System.out.println(queue.isEmpty());
		
		queue.display();
		
	}

}
