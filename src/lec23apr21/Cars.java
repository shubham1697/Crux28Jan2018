package lec23apr21;

public class Cars implements Comparable<Cars> {

	String name;
	int speed;
	int price;

	public Cars(String name, int speed, int price) {
		this.name = name;
		this.speed = speed;
		this.price = price;
	}

	public String toString() {
		return "N: " + this.name + " S: " + this.speed + " P: " + this.price;
	}

	@Override
	public int compareTo(Cars other) {

		// return this.speed - other.speed;
		// return other.price - this.price;
		return other.name.compareTo(this.name);
	}

}
