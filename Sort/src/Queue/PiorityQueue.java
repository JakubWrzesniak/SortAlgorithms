package Queue;

import java.util.Comparator;
import java.util.Iterator;

import Comparator.NaturalComparator;

public class PiorityQueue<E> {
    private Element head;
    public PiorityQueue(){
        clear();
    }

    private class Element<E> implements Comparable<Element<Integer>>{
        private E value;
        private int priority;
        private Element nextElem;

        public Element(E value, int priority) {
            this.value = value;
            this.priority = priority;
            nextElem = null;
        }

        public Element getNextElem() {
            return nextElem;
        }

        public void setNextElem(Element nextElem) {
            this.nextElem = nextElem;
        }

        public E getValue() {
            return value;
        }

        public void setValue(E value) {
            this.value = value;
        }

        public int getPriority() {
            return priority;
        }

        @Override
        public String toString() {
            return "{" +
                    "value=" + value +
                    ", priority=" + priority +
                    '}';
        }


        @Override
        public int compareTo(Element<Integer> o) {
            if(this.getPriority()==o.getPriority())
                return 0;
            else if(this.getPriority()>o.getPriority())
                return 1;
            else
                return -1;
        }
    }

    public void clear(){
        head = null;
    }
    public int size(){
        if (head == null) return 0;
        int counter = 0;
        Element tail = head;
        while(tail.getNextElem()!= null){
            tail = tail.getNextElem();
            counter++;
        }
        return counter;
    }

    public void enqueue(E value, int piority){
        Element<E> newElem = new Element(value,piority);
        if (head == null) head = newElem;
        else{
            if(newElem.compareTo(head)==-1){
                newElem.setNextElem(head);
                head= newElem;
            }else {
                Element tail = head;
                while (tail.getNextElem() != null) {
                    if (newElem.compareTo(tail.getNextElem()) < 0) {
                        Element<E> temp = tail.getNextElem();
                        tail.setNextElem(newElem);
                        newElem.setNextElem(temp);
                        return;
                    }
                    tail = tail.getNextElem();
                }
                tail.setNextElem(newElem);
            }
        }
    }

    public E Dequeue(){
        E returnVlaue = (E) head.getValue();
        head = head.getNextElem();
        return returnVlaue;
    }
    public String toString() {
        StringBuffer buf = new StringBuffer();
        buf.append("[\n");
        Element e = head;
        while (e != null) {
            buf.append(e.toString());
            buf.append("\n");
            e = e.getNextElem();
        }
        buf.append("]\n");
        return buf.toString();
    }
}
