package SortAlgorithms;

import List.List;
import List.ListSorter;

import java.util.Comparator;

public class HeapSort implements ListSorter {
    final Comparator comparator;

    public HeapSort(Comparator comparator) {
        this.comparator = comparator;
    }

    @Override
    public List sort(List base) {
        heapSort(base,base.size());
        return base;
    }

    private void heapSort(List heap,int n){
        heapAdjustment(heap,n);
        for(int i=n-1;i>0;i--){
            swap(heap,i,0);
            sink(heap,0,i);
        }
    }

    private void sink(List heap,int idx,int n){
        int indexOfBigger = 2*idx+1;
        Object valu = heap.get(idx);
        if(indexOfBigger<n){
            if(indexOfBigger+1 < n && comparator.compare(heap.get(indexOfBigger),heap.get(indexOfBigger+1))<0)
                indexOfBigger++;
            if(comparator.compare(heap.get(idx),heap.get(indexOfBigger))<0){
                swap(heap,idx,indexOfBigger);
                sink(heap,indexOfBigger,n);
            }
        }
    }

    private void heapAdjustment(List heap, int n){
        for(int i=(n-1)/2;i>=0 ;i--){
            sink(heap, i, n);
        }
    }

    public void swap(List list, int left, int right){
        Object temp = list.get(left);
        list.set(left,list.get(right));
        list.set(right,temp);
    }
}
