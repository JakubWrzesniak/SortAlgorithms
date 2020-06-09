package SortAlgorithms;



import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public class MergeSort<E extends Comparable<E>>  {
    private final Comparator comparator;
    int comparisons; //ilosc porównań
    int swaps; //ilosc zamian

    public MergeSort(Comparator comparator) {
        this.comparator = comparator;
    }

    public List sort(List<E> base) {
        return mergeSort(base,0,base.size()-1);
    }

    private ArrayList<E> mergeSort(List<E> list,int startIndex, int endIndex){
        comparisons =0;
        swaps =0;
        if(startIndex == endIndex){
            comparisons++;
            ArrayList<E> results = new ArrayList<E>();
            results.add(list.get(startIndex));
            return results;
        }
        int splitIndex = startIndex + (endIndex-startIndex)/2;
        return merge(mergeSort(list,startIndex,splitIndex),mergeSort(list,splitIndex+1,endIndex));
    }

    private ArrayList<E> merge(ArrayList<E> left, ArrayList<E> right){
        ArrayList<E> result = new ArrayList<E>();
        Iterator<E> leftIterator = left.iterator();
        Iterator<E> rightIterator = right.iterator();
        E leftElem = null;
        E rightElem = null;
        boolean countLeft, countRight;
        if(countLeft=leftIterator.hasNext()) leftElem = leftIterator.next();
        if(countRight=rightIterator.hasNext()) rightElem =rightIterator.next();
        while(countLeft && countRight){
            comparisons++;
            if(comparator.compare(leftElem,rightElem)<=0){
                result.add(leftElem);
                comparisons++;
                if(countLeft=leftIterator.hasNext()) leftElem = leftIterator.next();
                else result.add(rightElem);
            }else{
                result.add(rightElem);
                comparisons++;
                if(countRight=rightIterator.hasNext()) rightElem = rightIterator.next();
                else result.add(leftElem);
            }
        }
        while(leftIterator.hasNext()) result.add(leftIterator.next());
        while(rightIterator.hasNext()) result.add(rightIterator.next());
        return result;


    }

}
