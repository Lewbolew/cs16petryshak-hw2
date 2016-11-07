package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList stack = new ImmutableLinkedList();
    private int size = 0;

    public int getSize() {
        return size;
    }
    public Object peek() {
        return stack.get(stack.size() - 1);
    }

    public Object pop() {
        Object popedEl = stack.get(stack.size());
        stack = stack.remove(stack.size() - 1);
        size -= 1;
        return popedEl;
    }

    public void push(Object el) {
        stack = stack.add(el);
        size += 1;
    }

    public String toString() {
        String result = "[";
        for (int i = 0; i < stack.size(); i++) {
            result += stack.get(i) + ", ";
        }
        result += "]";
        return result;
    }
}
