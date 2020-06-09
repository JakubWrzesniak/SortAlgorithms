package SortAlgorithms;

import List.List;
import List.ListSorter;

import java.util.Comparator;
import java.util.Random;

public class QuickSort implements ListSorter {
    private final Comparator comparator;
    int comparisons; //ilosc porównań
    int swaps; //ilosc zamian

    public QuickSort(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        quickSort(base, 0, base.size());
        return base;
    }

    private void quickSort(List list, int startIndex, int endIndex){
        comparisons = 0;
        swaps = 0;
        if(endIndex-startIndex >1){
            int partition = partition(list,startIndex,endIndex);
            quickSort(list, startIndex, partition);
            quickSort(list,partition+1, endIndex);
        }
    }

    private int partition(List list, int nFrom, int nTo){
        Random random = new Random();
        int rPos = nFrom + random.nextInt(nTo-nFrom);
        swap(list,nFrom,rPos);
        Object pValue = list.get(nFrom);
        int biggerIndex = nFrom + 1;
        int lowerIndex = nTo - 1;
        do {
            comparisons++;
            while (biggerIndex <= lowerIndex && comparator.compare(list.get(biggerIndex), pValue) <= 0) {
                comparisons++;
                biggerIndex++;
            }
            comparisons++;
            while(comparator.compare(list.get(lowerIndex),pValue)>0) {
                comparisons++;
                lowerIndex--;
            }
            comparisons++;
            if(biggerIndex<lowerIndex)
                swap(list, biggerIndex, lowerIndex);
        }while(biggerIndex<lowerIndex);
        swap(list,lowerIndex,nFrom);
        return lowerIndex;
    }
    public void swap(List list, int left, int right){
        swaps++;
        Object temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }
}
