package comparators.examples.sorters;

import comparators.examples.Rectangle;

import java.util.Comparator;

public class WidthComparator implements Comparator<Rectangle> {
	@Override
	public int compare(Rectangle first, Rectangle second) {
		if (first.getWidth() < second.getWidth()) {
			return -1;
		}
		else if (first.getWidth() > second.getWidth()) {
			return 1;
		}
		else {
			return 0;
		}
	}
}

