package edu.ithaca.dragon.datastructures.priorityqueue;

public class PrioritizedItem<T> {
    private int priority;
    private T item;

    public PrioritizedItem(T item, int priority){
        this.item = item;
        this.priority = priority;
    }

    public T getItem(){
        return item;
    }

    public int getPriority(){
        return priority;
    }
}
