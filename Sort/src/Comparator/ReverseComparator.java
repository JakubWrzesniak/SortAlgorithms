package Comparator;

import java.util.Comparator;

public class ReverseComparator implements Comparator {
    public final Comparator rev ;

    public ReverseComparator(Comparator _Comparator) {
        this.rev = _Comparator;
    }

    @Override
    public int compare(Object left, Object right) {
        return rev.compare(right,left);
    }
}
