package ua.edu.ucu.collections.immutable;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class ImmutableArrayListTest {
    static Object[] arr = {1,2,3,4,5};
    static ArrayList arrayList = new ArrayList();
    static {
        for (int i = 0; i < 10; i++) {
            arrayList.add(i);

        }
    }
    static ImmutableArrayList immutableArrayList = new ImmutableArrayList(arrayList);

    @Test
    public void testAdd() {
        ImmutableArrayList newImmutableArr = immutableArrayList.add(100500);
        int expected = 10;
        int actual = immutableArrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddIndex() {
        ImmutableArrayList newImmutableArr = immutableArrayList.add(1, 100500);
        int expected = 100500;
        Object actual = newImmutableArr.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAll() {
        ImmutableArrayList newArr = immutableArrayList.addAll(arr);
        int expected = 15;
        int actual = newArr.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testAddAllIndex() {
        ImmutableArrayList newArr =  immutableArrayList.addAll(0, arr);
        Object expected = 1;
        Object actual = newArr.get(6);
        assertEquals(expected, actual);
    }

    @Test
    public void testGet() {
        Object actual = immutableArrayList.get(1);
        Object expected = 1;
        assertEquals(actual, expected);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList newArr = immutableArrayList.remove(1);
        Object expected = 2;
        Object actual = newArr.get(1);
        assertEquals(expected, actual);
    }

    @Test
    public void testSet() {
        ImmutableArrayList newArr = immutableArrayList.set(0, 100500);
        Object expected = 100500;
        Object actual = newArr.get(0);
        assertEquals(expected, actual);
    }

    @Test
    public void testIndexOf() {
        Object expected = 5;
        Object actual = immutableArrayList.indexOf(5);
        assertEquals(expected, actual);
    }

    @Test
    public void testSize() {
        Object expected = 10;
        Object actual = immutableArrayList.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testClear() {
        ImmutableArrayList newArr = immutableArrayList.clear();
        int expected = 0;
        int actual = newArr.size();
        assertEquals(expected, actual);
    }

    @Test
    public void testIsEmpty() {
        boolean expected = false;
        boolean actual = immutableArrayList.isEmpty();
        assertEquals(actual, expected);
    }

    @Test
    public void testToArray() {
        Object[] expected = {0,1,2,3,4,5,6,7,8,9};
        Object[] actual = immutableArrayList.toArray();
        assertEquals(Arrays.equals(expected, actual), true);
    }

}
