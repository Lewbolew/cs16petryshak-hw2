package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ImmutableLinkedListTest {
    static Object[] arr = {1,2,3,4,5};
    private ImmutableLinkedList immutableListCreator() {
        ImmutableLinkedList immutableLinkedList = new ImmutableLinkedList();
        immutableLinkedList = immutableLinkedList.addAll(arr);
        immutableLinkedList = immutableLinkedList.add("Bohdan");
        return immutableLinkedList;
    }
    @Test
    public void testAdd() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.add(300500);
        Object actual = newImm.size();
        Object expected = 7;
        assertEquals(expected, actual);
    }

    @Test
    public void testAddIndex() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.add(1, "kik");
        Object actual = newImm.get(1).toString();
        Object expected = "kik";
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.addAll(arr);

        int expected = 11;
        int actual = newImm.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        ImmutableLinkedList newImm = immutableListCreator();
        Object actual = newImm.get(5).toString();
        Object expected = "Bohdan";
        assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.remove(3);
        Object expected = 5;
        Object actual = newImm.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testSet() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.set(0, "lol");
        Object expected = "lol";
        Object actual = newImm.get(0).toString();
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOf() {
        ImmutableLinkedList newImm = immutableListCreator();
        Object expected = 5;
        Object actual = newImm.indexOf("Bohdan");
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        ImmutableLinkedList newImm = immutableListCreator();
        Object expected = 6;
        Object actual = newImm.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList newImm = immutableListCreator();
        newImm = newImm.clear();
        Object expected = 0;
        Object actual = newImm.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        ImmutableLinkedList newImm = immutableListCreator();
        boolean expected = false;
        boolean actual = newImm.isEmpty();
        assertEquals(actual, expected);
    }

    @Test
    public void testToArray() {
        ImmutableLinkedList newImm = immutableListCreator();
        Object[] expected = {1, 2, 3, 4, 5, "Bohdan"};
        Object[] actual = newImm.toArray();
        assertEquals(Arrays.equals(expected, actual), false);
    }

}
