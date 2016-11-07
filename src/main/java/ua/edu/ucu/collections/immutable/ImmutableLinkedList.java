package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableLinkedList implements ImmutableList {
    private final Node header;
    private int size = 0;

    public ImmutableLinkedList() {
        header = null;
    }

    public ImmutableLinkedList(Node node) {
        header = node;
    }

    private void IndexExceptionThrower(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
    }

    private Node linkedListDeepCopyXerox() { // RETURNS MUTTABLE LINKED LIST!
        Node current = header;
        Node newHeader = header.clone();
        Node newNode = newHeader;
        while (current.nextElement != null) {
            Node newNewNode = current.nextElement.clone();
            newNode.nextElement = newNewNode;
            newNode = newNewNode;
            current = current.nextElement;
        }
        return newHeader;
    }

    private Node iterator(int index, Node node) {
        for (int i = 0; i < index - 1; i++) {
            node = node.nextElement; // Here I change the node element because I need to do it, it`s not an error!
        }
        return node;
    }

    private ImmutableLinkedList NullElementAdd(Object e) {
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(new Node(e));
        newImmutable.size++;
        return newImmutable;
    }

    private void arrayAdder(Object[] c, Node newHead, int intp_size) {
        Node lastNode = iterator(intp_size, newHead);
        for (int i = 0; i < c.length; i++) {
            Node newNode = new Node(c[i]);
            lastNode.nextElement = newNode;
            lastNode = lastNode.nextElement;
        }
    }
    public String toString() {
        String result = "";
        Node current = header;
        while (current != null) {
            result += current.data + " --> ";
            current = current.nextElement;
        }
        result += "null";
        return result;
    }
    @Override
    public ImmutableLinkedList add(Object e) {
        if (header == null) {
            return NullElementAdd(e);
        }
        Node newHeader = linkedListDeepCopyXerox();
        Node lastNode = iterator(size, newHeader);
        lastNode.nextElement = new Node(e);
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
        newImmutable.size += size + 1;
        return newImmutable;
    }

    @Override
    public ImmutableLinkedList add(int index, Object e) {
        IndexExceptionThrower(index);
        Node newHeader = linkedListDeepCopyXerox();
        if (header == null) {
            return NullElementAdd(e);
        } else if (index == size()) {
            return add(e);
        } else if (index == 0) {
            Node newNode = new Node(e, newHeader);
            ImmutableLinkedList newImmutable = new ImmutableLinkedList(newNode);
            newImmutable.size++;
            return newImmutable;
        }
        Node lastNode = iterator(index, newHeader);
        Node savedNextElement = lastNode.nextElement;
        lastNode.nextElement = new Node(e, savedNextElement);
        size++;
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
        newImmutable.size = size + 1;
        return newImmutable;
    }

    @Override
    public ImmutableLinkedList addAll(Object[] c) {
        if (header == null) {
            Node newHead = new Node(c[0]);
            arrayAdder(Arrays.copyOfRange(c, 1, c.length), newHead, 1);
            ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHead);
            newImmutable.size += c.length;
            return newImmutable;
        }
        Node newHead = linkedListDeepCopyXerox();
        arrayAdder(c, newHead, size);
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHead);
        newImmutable.size = size + c.length;
        return newImmutable;
    }

    @Override
    public ImmutableLinkedList addAll(int index, Object[] c) {
        IndexExceptionThrower(index);
        if (size() == 0) {
            ImmutableLinkedList newImmutable = new ImmutableLinkedList();
            return newImmutable.addAll(c);
        } else if (size() - 1 == index) {
            return addAll(c);
        }
        Node newHead = linkedListDeepCopyXerox();
        Node indexNode = iterator(index + 1, newHead);
        Node lastList = indexNode.nextElement;
        arrayAdder(c, newHead, size() - index - 1);
        indexNode = iterator(size() - size() - index + c.length + 1, newHead);
        indexNode.nextElement = lastList;
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHead);
        newImmutable.size = size + c.length;
        return newImmutable;
    }

    @Override
    public Object get(int index) {
        IndexExceptionThrower(index);
        return iterator(index + 1, header);
    }

    @Override
    public ImmutableLinkedList remove(int index) {
        IndexExceptionThrower(index);
        Node newHeader = linkedListDeepCopyXerox();
        if (index == 0) {
            newHeader = newHeader.nextElement;
            ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
            newImmutable.size = size - 1;
            return newImmutable;
        } else if (index == size() - 1) {
            Node beforeLast = iterator(index, newHeader);
            beforeLast.nextElement = null;
            ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
            newImmutable.size = size - 1;
            return newImmutable;
        }
        Node beforeNecessaryEl = iterator(index, newHeader);
        Node restList = beforeNecessaryEl.nextElement.nextElement;
        beforeNecessaryEl.nextElement = restList;
        ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
        newImmutable.size = size - 1;
        return newImmutable;
    }

    @Override
    public ImmutableLinkedList set(int index, Object e) {
        IndexExceptionThrower(index);
        Node newHeader = linkedListDeepCopyXerox();
        if (index == size() - 1) {
            Node penultimateNode = iterator(index, newHeader);
            penultimateNode.nextElement = new Node(e);
            ImmutableLinkedList newImmutable = new ImmutableLinkedList(newHeader);
            return newImmutable;
        } else if (index == 0) {
            Node newNode = new Node(e, newHeader.nextElement);
            return new ImmutableLinkedList(newNode);
        }
        Node beforeIndexEl = iterator(index, newHeader);
        Node restList = beforeIndexEl.nextElement.nextElement;
        beforeIndexEl.nextElement = new Node(e, restList);
        return new ImmutableLinkedList(newHeader);

    }

    @Override
    public int indexOf(Object e) {
        int index = 0;
        Node currentElement = header;
        while (index < size()) {
            if (currentElement.data == e) {
                return index;
            }
            currentElement = currentElement.nextElement;
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return this.size;
    }

    @Override
    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    @Override
    public boolean isEmpty() {
        if (size == 0) {
            return true;
        }
        return false;
    }

    @Override
    public Object[] toArray() {
        Object[] resultArr = new Object[size()];
        Node currentNode = header;
        for (int i = 0; i < size(); i++) {
            resultArr[i] = currentNode;
            currentNode = currentNode.nextElement;
        }
        return resultArr;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(size(), e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size - 1);
    }

    static final class Node {
        private final Object data;
        private Node nextElement;

        private Node() {
            data = null;
            nextElement = null;
        }

        private Node(Object data, Node nextElement) {
            this.data = data;
            this.nextElement = nextElement;
        }

        private Node(Object data) {
            this.data = data;
            this.nextElement = null;
        }

        public Object getData() {
            return data;
        }

        @Override
        public Node clone() {
            Node newNode = new Node(data);
            return newNode;
        }
        @Override
        public String toString() {
            return "" + data;
        }
    }

}
