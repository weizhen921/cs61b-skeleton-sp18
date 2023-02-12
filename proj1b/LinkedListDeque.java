public class LinkedListDeque<T> implements Deque<T> {
    private int size = 0;
    private Node sentinel;

    /**
     * Constructor of LinkedListDeque
     * @param
     */
    public LinkedListDeque() {
        sentinel = new Node(null, null, null);
        sentinel.prev = sentinel;
        sentinel.next = sentinel;
        size = 0;
    }

    /**
     * Stuff Node class
     */
    private class Node {
        private Node prev;
        private T item;
        private Node next;
        private Node(Node p, T i, Node n) {
            prev = p;
            item = i;
            next = n;
        }
    }

    public void addFirst(T item) {
        sentinel.next = new Node(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size += 1;
    }

    public void addLast(T item) {
        sentinel.prev = new Node(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size += 1;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void printDeque() {
        Node pointer = sentinel.next;
        for (int i = size; i > 1; size--) {
            System.out.print(pointer.item + " ");
            pointer = pointer.next;
        }
        System.out.println(pointer.item);
    }

    public T removeFirst() {
        if (sentinel.next == sentinel) {
            return null;
        }
        Node first = sentinel.next;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        size--;
        return first.item;
    }

    public T removeLast() {
        if (sentinel.prev == sentinel) {
            return null;
        }
        Node last = sentinel.prev;
        sentinel.prev.prev.next = sentinel;
        sentinel.prev = sentinel.prev.prev;
        size--;
        return last.item;


    }

    public T get(int index) {
        if (index >= size) {
            return null;
        }
        Node pointer = sentinel.next;
        for (int i = 0; i < index; i++) {
            pointer = pointer.next;
        }
        return pointer.item;
    }

    public T getRecursive(int index) {
        if (index >= size) {
            return null;
        }
        int count = 0;
        Node pointer = sentinel.next;
        return getRecursiveHelper(index, count, pointer);
    }

    private T getRecursiveHelper(int index, int count, Node pointer) {
        if (index == count) {
            return pointer.item;
        }
        return getRecursiveHelper(index, count + 1, pointer.next);
    }

//    public LinkedListDeque(LinkedListDeque other) {
//        sentinel = new Node(null,null,null);
//        sentinel.prev = sentinel;
//        sentinel.next = sentinel;
//        size = 0;
//
//        for (int i = 0; i< other.size(); i++) {
//            this.addLast((T) other.get(i));
//        }
//
//    }


}
