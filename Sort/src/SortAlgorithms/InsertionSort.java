package SortAlgorithms;

import List.*;

import java.util.Comparator;

public class InsertionSort implements ListSorter {
    private final Comparator<Object> comparator;
    int comparison; //ilosc porównań
    int swaps; //ilosc zamian

    public InsertionSort(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        comparison = 0;
        swaps = 0;
        final List result = new LinkedList();
        Iterator it = base.iterator();
        for(it.first(); !it.isDone();it.next()){
            int slot = result.size();
            while(slot>0){
                comparison++;
                if(comparator.compare(it.current(),result.get(slot-1))>=0)
                    break;
                slot--;
            }
            swaps++;
            result.insert(slot,it.current());
        }
        return result;
    }
    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }
}
