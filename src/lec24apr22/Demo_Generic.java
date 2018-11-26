package lec24apr22;

import lec23apr21.Cars;

public class Demo_Generic {

	public static void main(String[] args) {
		
		Genericpair<String , Integer> gp = new Genericpair<>();
		
		Genericpair<Genericpair<String, Integer>, Genericpair<Integer,String>> gp2 = new Genericpair<>();
		
		gp2.a = new Genericpair<>();
		gp2.a.a = "abc";
		gp2.a.b = 10;
		
		gp2.b = new Genericpair<>();
		gp2.b.a = 20;
		gp2.b.b = "def";
		
		GenericLinkedList<Cars> l1 = new GenericLinkedList<>();
		Cars[] cars = new Cars[5];

		cars[0] = new Cars("A", 256, 2000);
		cars[1] = new Cars("B", 300, 1500);
		cars[2] = new Cars("C", 500, 500);
		cars[3] = new Cars("D", 250, 1000);
		cars[4] = new Cars("E", 350, 1800);
		
		l1.addLast(cars[0]);
		
		l1.display();
	}

}
