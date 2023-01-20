public class ArrayDeque<T> {
    private T[] items;
    private int size;
    private int capacity = 8;
    private int frontPointer = 0;
    private int backPointer = 1;


    public ArrayDeque(){
        items = (T[]) new Object[capacity];
        size = 0;
    }

    public void addFirst(T item){
        items[frontPointer] = item;
        frontPointer = frontPointer - 1 < 0 ? capacity-1 : frontPointer-1;
        size++;
        if(size == items.length){
            resize();
        }

    }

    public void addLast(T item){
        if (size == 0){
            items[frontPointer] = item;
            frontPointer = frontPointer - 1 < 0 ? capacity-1 : frontPointer-1;
        } else {
            items[backPointer] = item;
            backPointer = (backPointer + 1) % capacity;
        }
        size++;
        if(size == items.length){
            resize();
        }
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void printDeque(){
        if (size == 0){
            return;
        }
        int count = 0;
        int index = (frontPointer + 1) % capacity;
        while (count < size-1){
            System.out.print(items[index] + " ");
            index = (index + 1) % capacity;
            count++;
        }
        System.out.println(items[index]);
    }

    public T removeFirst(){
        if (size == 0) {
            return null;
        }
        size--;
        frontPointer = (frontPointer + 1) % capacity;
        T delete = items[frontPointer];
        if ((size * 1.0 / capacity) < 0.25) {
            shrink();
        }
        return delete;
    }

    public T removeLast(){
        if (size == 0) {
            return null;
        }
        size--;
        backPointer = (backPointer - 1)%capacity;
        T delete = items[backPointer];
        if ((size * 1.0 / capacity) < 0.25) {
            shrink();
        }
        return delete;
    }

    public T get(int index){
        if (index >= size || index < 0) {
            return null;
        }
        return items[(frontPointer + index + 1) % capacity];
    }

    public ArrayDeque(ArrayDeque other){
        T[] array = (T[]) new Object[capacity];
        int index = (frontPointer + 1) % capacity;
        int count = 0;
        while((count++) <size){
            array[index] = (T) other.get(index);
            index = (index + 1) % capacity;
        }
    }

    private void copyTo(T[] a) {
        int aIndex = 0;
        int index = (frontPointer + 1) % capacity;
        int count = 0;
        while ((count++) < size) {
            a[aIndex++] = items[index];
            index = (index + 1) % capacity;
        }
    }
    private void resize(){
        T[] a = (T[]) new Object[size * 2];
        copyTo(a);
        items = a;
        capacity = size * 2;
        frontPointer = capacity - 1;
        backPointer = size;
    }


    private void shrink(){
        T[] b = (T[]) new Object[capacity / 2];
        copyTo(b);
        items = b;
        capacity = capacity / 2;
        frontPointer = capacity - 1;
        backPointer = size;
    }



}
