package lec23apr21;

import java.util.Comparator;

public class CarPriceComparator implements Comparator<Cars> {

	@Override
	public int compare(Cars tc, Cars oc) {
		return oc.price-tc.price;
	}
}
