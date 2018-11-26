package lec23apr21;

import java.util.Comparator;

public class CarNameComparator implements Comparator<Cars>{

	public int compare(Cars tc, Cars oc) {
		return tc.name.compareTo(oc.name);
	}

}
