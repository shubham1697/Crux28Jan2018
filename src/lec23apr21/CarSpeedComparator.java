package lec23apr21;

import java.util.Comparator;

public class CarSpeedComparator implements Comparator<Cars> {


	@Override
	public int compare(Cars tc, Cars oc) {
		return tc.speed-oc.speed;
	}
	
}
