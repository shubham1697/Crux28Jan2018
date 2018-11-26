package lec24apr22.HashMaps;

public class HashMap_Client {

	public static void main(String[] args) {
		
		
		HashMap<String, Integer> hm = new HashMap<>();
		
		hm.put("A", 100);
		hm.put("B", 211);
		hm.put("C", 300);
		hm.put("D", 400);
		hm.put("E", 500);
		hm.put("F", 600);
		
		hm.display();
		hm.put("C", 900);
		hm.remove("D");

		hm.display();

		
	}

}
