package Comparator;

import java.util.Comparator;

public class NaturalComparator implements Comparator {
    public static final Comparator base = new NaturalComparator();

    @Override
    public int compare(Object left, Object right) throws ClassCastException {
        return ((Comparable)left).compareTo(right);
    }
}
