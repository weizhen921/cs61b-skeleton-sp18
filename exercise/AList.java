/** Array based list.
 *  @author Josh Hug
 */

public class AList {
    int[] items;
    int size;

    /** Creates an empty list. */
    public AList() {
        /** Decide what memory box to set up */
        private items = new int[100];
        private size = 0;
    }

    /** Resizes the underlying array to the target capacity */
    private void resize(int capacity){
            int[] a = new int[capacity];
            System.arraycopy(items, 0, a, 0, size);
            items = a;

    }

    /** Inserts X into the back of the list. */
    public void addLast(int x) {
        if(size == items.length){
            resize(size + 1);
        }
        items[size] = x;
        size = size + 1;
    }

    /** Returns the item from the back of the list. */
    public int getLast() {
        return items[size - 1];
    }
    /** Gets the ith item in the list (0 is the front). */
    public int get(int i) {
        return items[i];
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    /** Deletes item from back of the list and
     * returns deleted item. */
    public int removeLast() {
        int x = getLast();
        size = size - 1;
        return x;
    }


} 