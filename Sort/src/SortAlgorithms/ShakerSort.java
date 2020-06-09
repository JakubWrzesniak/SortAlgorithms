package SortAlgorithms;

import List.*;

import java.util.Comparator;

public class ShakerSort implements ListSorter {
    final Comparator<Object> comparator;
    int comparisons; //ilosc porównań
    int swaps; //ilosc zamian

    public ShakerSort(Comparator<Object> comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        int lastSwap = base.size()-1;
        comparisons = 0;
        swaps = 0;
        while(lastSwap>0){
            int end = lastSwap;
            lastSwap =0;
            for(int left = 0 ; left< end; left++){
                comparisons++;
                if(comparator.compare(base.get(left),base.get(left+1))>0){
                    Object temp = base.get(left);
                    while(left<end && comparator.compare(temp, base.get(left+1))>0){
                        comparisons++;
                        base.set(left,base.get(++left));
                        swaps++;
                    }
                    comparisons++;
                    lastSwap = left;
                    base.set(left, temp);
                    swaps++;
                }
            }
        }
        return base;
    }


    public int getComparisons() {
        return comparisons;
    }

    public int getSwaps() {
        return swaps;
    }
}
