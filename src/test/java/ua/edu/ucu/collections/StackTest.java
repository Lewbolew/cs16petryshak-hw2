package ua.edu.ucu.collections;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class StackTest {
    private Stack stackCreator() {
        Stack stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        return stack;
    }
    @Test
    public void testPop() {
        Stack stack = stackCreator();
        stack.pop();
        int actual = stack.getSize();
        int expected = 2;
        assertEquals(actual, expected);
    }

    @Test
    public void testPush() {
        Stack stack = stackCreator();
        stack.push(10);
        int actual = stack.getSize();
        int expected = 4;
        assertEquals(actual, expected);
    }

}
