package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList queue = new ImmutableLinkedList();
    private int size = 0;

    public int getSize() {
        return size;
    }
    public Object peek() {
        return queue.get(0);
    }

    public Object dequeue() {
        Object removedElemet = queue.get(0);
        queue = queue.remove(0);
        size -= 1;
        return removedElemet;
    }

    public void enqueue(Object e) {
        queue = queue.add(e);
        size += 1;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < queue.size(); i++) {
            result += queue.get(i) + ", ";
        }
        result += "]";
        return result;
    }
}
