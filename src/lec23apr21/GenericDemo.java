/**
 * 
 */
package lec23apr21;

import java.util.Comparator;

/**
 * @author uChiHA_itACHi
 *
 */
public class GenericDemo {
	public static void main(String[] args) {
		Cars[] cars = new Cars[5];
		cars[0] = new Cars("A", 256, 2000);
		cars[1] = new Cars("B", 300, 1500);
		cars[2] = new Cars("C", 500, 500);
		cars[3] = new Cars("D", 250, 1000);
		cars[4] = new Cars("E", 350, 1800);
		bubbleSort(cars, new CarSpeedComparator());
		display(cars);
	}

	public static <T> void display(T[] arr) {
		for (T val : arr) {
			System.out.println(val);
		}
	}

	public static <T> void bubbleSort(T[] arr, Comparator<T> comparator) {
		for (int counter = 0; counter < arr.length - 1; counter++) {
			for (int j = 0; j < arr.length - 1 - counter; j++) {
				if (comparator.compare(arr[j + 1], (arr[j])) > 0) {
					T temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		display(arr);
	}
}
