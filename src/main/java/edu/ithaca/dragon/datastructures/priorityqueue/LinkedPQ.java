package edu.ithaca.dragon.datastructures.priorityqueue;

import java.util.LinkedList;
import java.util.List;
import java.util.NoSuchElementException;

public class LinkedPQ<T> implements PriorityQueue<T> {

    private List<PrioritizedItem<T>> myList;

    public LinkedPQ(){
        myList = new LinkedList<>();
    }
    
    @Override
    public void offer(T item, int priority) {
        myList.add(0, new PrioritizedItem<T>(item, priority));
    }

    @Override
    public T poll() {
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        else {
            PrioritizedItem<T> bestItem = myList.get(0);
            for (int i=0; i<myList.size(); i++){
                if (myList.get(i).getPriority() < bestItem.getPriority()){
                    bestItem = myList.get(i);
                }
            }
            myList.remove(bestItem);
            return bestItem.getItem();
        }
    }

    @Override
    public boolean isEmpty() {
        return myList.size()==0;
    }

    @Override
    public void makeEmpty() {
       myList.clear();
    }
    
}
