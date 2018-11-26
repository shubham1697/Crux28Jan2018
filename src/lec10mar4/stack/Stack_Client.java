package lec10mar4.stack;

public class Stack_Client {

	public static void main(String[] args) throws Exception {
		
		Stack stack = new Stack();
		
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		
		stack.display();
		System.out.println();
		
		System.out.println("Top: "+stack.top());
		System.out.println();
		
		System.out.println("Size: "+stack.size());
		System.out.println();
		
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());
		System.out.println(stack.pop());

		System.out.println();
		System.out.println(stack.isEmpty());
		
	
		
	}
	


}
