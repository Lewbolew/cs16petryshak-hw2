package ua.edu.ucu.collections.immutable;

import java.util.ArrayList;

public final class ImmutableArrayList implements ImmutableList{
    final private ArrayList immutableArrayList;
    ImmutableArrayList() {
        immutableArrayList = new ArrayList();
    }
    ImmutableArrayList(ArrayList newArrayList) {
        immutableArrayList = newArrayList;
    }

    public String toString() {
        return immutableArrayList.toString();
    }

    private ImmutableArrayList newObjectCreator(ArrayList arrayList) {
        ImmutableArrayList newImmutableArrayList = new ImmutableArrayList(arrayList);
        return newImmutableArrayList;
    }

    private void IndexExceptionThrower(int index) {
        if (index > immutableArrayList.size()) {
            throw new IndexOutOfBoundsException();
        }
    }

    @Override
    public ImmutableArrayList add(Object e) {
        ArrayList newArrayList = new ArrayList(immutableArrayList);
        newArrayList.add(e);
        return newObjectCreator(newArrayList);
    }

    @Override
    public ImmutableArrayList add(int index, Object e) {
        if (index > immutableArrayList.size()) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList newArrayList = new ArrayList(immutableArrayList);
        newArrayList.add(index, e);
        return newObjectCreator(newArrayList);
    }

    @Override
    public ImmutableArrayList addAll(Object[] c) {
        ArrayList newArrayList = new ArrayList(immutableArrayList);
        for (int i = 0; i < c.length; i++) {
            newArrayList.add(c[i]);
        }
        return newObjectCreator(newArrayList);
    }

    @Override
    public ImmutableArrayList addAll(int index, Object[] c) {
        if (index > immutableArrayList.size()) {
            throw new IndexOutOfBoundsException();
        }
        ArrayList newArrayList = new ArrayList(immutableArrayList);

        for (int i = 0; i < c.length; i++) {
            newArrayList.add(index + i, c[i]);
        }
        return newObjectCreator(newArrayList);

    }

    @Override
    public Object get(int index) {
        ArrayList newArray = new ArrayList(immutableArrayList);
        return newArray.get(index);
    }

    @Override
    public ImmutableArrayList remove(int index) {
        ArrayList newArrayList = new ArrayList(immutableArrayList);
        newArrayList.remove(index);
        ImmutableArrayList newArray = new ImmutableArrayList(newArrayList);
        return newArray;
    }

    @Override
    public ImmutableArrayList set(int index, Object e) {
        ArrayList newArrayList = new ArrayList(immutableArrayList);
        newArrayList.set(index, e);
        return newObjectCreator(newArrayList);
    }

    @Override
    public int indexOf(Object e) {
        return immutableArrayList.indexOf(e);
    }

    @Override
    public int size() {
        return immutableArrayList.size();
    }

    @Override
    public ImmutableArrayList clear() {
        ImmutableArrayList newImmutableArrayList = new ImmutableArrayList();
        return newImmutableArrayList;
    }

    @Override
    public boolean isEmpty() {
        if (immutableArrayList.size() == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] newArray = new Object[immutableArrayList.size()];
        for (int i = 0; i < immutableArrayList.size(); i++) {
            newArray[i] = immutableArrayList.get(i);
        }
        return newArray;
    }
}
