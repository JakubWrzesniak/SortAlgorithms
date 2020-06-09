package SortAlgorithms;

import List.*;

import java.util.Comparator;

public class BubbleSort implements ListSorter {
    final Comparator<Object> comparator;
    int comparisons; //ilosc porównań
    int swaps; //ilosc zamian

    public BubbleSort(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        int range = base.size();
        comparisons = 0;
        swaps = 0;
        for(int pass = 1; pass<range; pass++){
            for(int left = 0; left<(range-pass); left++){
                int right = left+1;
                comparisons++;
                if(comparator.compare(base.get(left),base.get(right))>0) {
                    swaps++;
                    swap(base,left,right);
                }
            }
        }
        return base;
    }
    private void swap(List list, int left, int right){
        Object temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }

    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
