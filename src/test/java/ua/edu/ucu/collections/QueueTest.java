package ua.edu.ucu.collections;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueueTest {
    private Queue queueCreator() {
        Queue queue = new Queue();
        queue.enqueue(1);
        queue.enqueue(2);
        queue.enqueue(3);
        queue.enqueue(4);
        queue.enqueue(5);
        return queue;
    }

    @Test
    public void testEnqueue() {
        Queue queue = new Queue();
        queue.enqueue(1);
        int expected = 1;
        int actual = queue.getSize();
        assertEquals(actual, expected);
    }

    @Test
    public void testDeque() {
        Queue queue = queueCreator();
        queue.dequeue();
        int actual = queue.getSize();
        int expected = 4;
        assertEquals(actual, actual);
    }
}
