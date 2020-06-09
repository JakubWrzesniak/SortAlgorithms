package SortAlgorithms;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ShellSort {
    final Comparator comparator;

    public ShellSort(Comparator comparator) {
        this.comparator = comparator;
    }
    public List sort(List base){
        int d = (int) (base.size()/1.5);
        do{
            shellSort(base,d);
            d = d/2;
        }while(d>=1);
        return base;
    }
    private void shellSort(List base, int d){
        int pos = d;
        while (pos<base.size()){
            if(comparator.compare(base.get(pos-d),base.get(pos))>0)
                Collections.swap(base,pos-d,pos);
            pos++;
        }
    }
}
