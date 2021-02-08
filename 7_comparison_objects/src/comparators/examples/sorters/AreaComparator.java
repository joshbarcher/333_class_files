package comparators.examples.sorters;

import comparators.examples.Rectangle;

import java.util.Comparator;

public class AreaComparator implements Comparator<Rectangle> {
	@Override
	public int compare(Rectangle first, Rectangle second) {
		double areaFirst = first.getWidth() * first.getHeight();
		double areaSecond = second.getWidth() * second.getHeight();
		
		if (areaFirst < areaSecond) {
			return -1;
		}
		else if (areaFirst > areaSecond) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

