package SortAlgorithms;

import java.util.*;

public class CountingSort {

    public List sort(List<Integer> base){
        ArrayList<Integer> results = new ArrayList<>();
        results.addAll(Arrays.asList(countingSort(base)));
        return results;
    }

    private Integer[] countingSort(List<Integer> base){
        Integer[] count = new Integer[findMax(base)];
        Integer[] results = new Integer[base.size()];
        counting(base,count);
        for(int j = 0; j < count.length;j++)
            System.out.println(count[j]);
        for(int i = 0; i < (base.size());i++) {
            results[count[base.get(i) - 1]-1] = base.get(i);
            count[base.get(i)-1] -=1;
        }
        return results;
    }

    private void counting(List<Integer> base,Integer[] count){
        Iterator<Integer> iterator = base.iterator();
        while(iterator.hasNext()){
            int pos = iterator.next();
            count[pos-1] = count[pos-1]+1;
        }
        addingPreviosPos(count);
    }

    private void addingPreviosPos(Integer[] count){
        for(int i = 1; i < count.length;i++){
            int temp = count[i];
            count[i] = count[i-1]+temp;
        }
    }

    private int findMax(List<Integer> list){
        Iterator<Integer> iterator = list.iterator();
        int max = list.get(0);

        while (iterator.hasNext()){
            int temp = iterator.next();
            if(temp > max)
                max=temp;
        }
        return max;
    }
}
