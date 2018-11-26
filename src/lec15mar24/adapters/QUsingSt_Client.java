package lec15mar24.adapters;

public class QUsingSt_Client {

	public static void main(String[] args) throws Exception {

		QUsingSt qs = new QUsingSt();

		qs.enqueue(1);
		qs.enqueue(2);
		qs.enqueue(3);
		qs.enqueue(4);
		qs.enqueue(5);
		qs.enqueue(6);
		qs.enqueue(7);
//		System.out.println(qs.dequeue());
//		System.out.println(qs.dequeue());
//		System.out.println(qs.dequeue());
		qs.display();
		System.out.println(qs.size());
		System.out.println(qs.isEmpty());
		
	}

}
