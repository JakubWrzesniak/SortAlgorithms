package SortAlgorithms;

import List.*;

import java.util.Comparator;


public class SelectSort implements ListSorter {
    private final Comparator<Object> comparator;
    int comparison; //ilosc porównań
    int swaps; //ilosc zamian

    public SelectSort(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        comparison =0;
        swaps = 0;
        int range = base.size();
        for(int slot = 0 ; slot<= range-1; slot++){
            int chosen = slot;
            for(int current = slot+1; current<range; current ++){
                comparison++;
                if(comparator.compare(base.get(chosen),base.get(current))<0)
                    chosen = current;
            }
            swaps++;
            swap(base,slot,chosen);
        }
        return base;
    }
    private void swap(List list, int left, int right){
        Object temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

    public int getComparison() {
        return comparison;
    }

    public int getSwaps() {
        return swaps;
    }
}
