package com.company;

import List.LinkedList;
import Queue.PiorityQueue;
import SortAlgorithms.CountingSort;
import SortAlgorithms.QuickSort;
import Comparator.NaturalComparator;
import SortAlgorithms.ShellSort;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        ArrayList list = new ArrayList();
        CountingSort countingSort = new CountingSort();
        QuickSort quickSort = new QuickSort(new NaturalComparator());
        ShellSort shellSort = new ShellSort(new NaturalComparator());
        PiorityQueue<Integer> piorityQueue = new PiorityQueue<>();
        piorityQueue.enqueue(1,5);
        piorityQueue.enqueue(3,7);
        piorityQueue.enqueue(6,2);
        piorityQueue.enqueue(10,4);
        piorityQueue.enqueue(2,2);
        piorityQueue.enqueue(9,1);
        piorityQueue.enqueue(3,5);
        System.out.println(piorityQueue);

        list.add(9);
        list.add(4);
        list.add(3);
        list.add(7);
        list.add(2);
        list.add(7);
        list.add(1);
        list.add(3);
        list.add(8);
        list.add(5);
        //shellSort.sort(list);
        //System.out.println(countingSort.sort(list));
    }
}
