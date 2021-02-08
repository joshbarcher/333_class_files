package comparators.examples.sorters;

import comparators.examples.Rectangle;

import java.util.Comparator;

public class HeightComparator implements Comparator<Rectangle> {
	@Override
	public int compare(Rectangle first, Rectangle second) {
		if (first.getHeight() < second.getHeight()) {
			return -1;
		}
		else if (first.getHeight() > second.getHeight()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

