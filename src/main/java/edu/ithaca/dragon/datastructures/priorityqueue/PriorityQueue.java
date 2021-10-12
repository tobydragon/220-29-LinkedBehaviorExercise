package edu.ithaca.dragon.datastructures.priorityqueue;

import java.util.NoSuchElementException;

public interface PriorityQueue<T> {

    /**
     * puts an item into the priorityQueue with the given priority
     */
    void offer(T item, int priority);

    /**
     * removes the "most important" item (the lowest priority number, think "priority number 1")
     * If items have equal priority, any of those items may be returned
     * @return the item removed
     * @throws NoSuchElementException if the queue is empty
     */
    T poll();

    /**
     * @return true if the queue has no items, false otherwise
     */
    boolean isEmpty();

    /**
     * all items are removed, after calling this PriorityQueue is empty
     */
    void makeEmpty();
    
}
