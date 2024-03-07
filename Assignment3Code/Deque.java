import java.util.Arrays;

public class Deque {

    private int[] dequeArray;
    private int left;
    private int right;
    private int maxsize;
    private int nItems;

    public Deque(int s) {

        maxsize = s;
        dequeArray = new int[maxsize];
        left = 0;
        right = -1;
        nItems = 0;
    }

    public void insertRight(int item) {
        if (!isFull()) {
            right = (right + 1) % maxsize;
            dequeArray[right] = item;
            nItems++;
        }
    }

    public void insertLeft(int item) {
        if (!isFull()) {
            left = (left - 1 + maxsize) % maxsize;
            dequeArray[left] = item;
            nItems++;
        }
    }

    public int removeRight() {
        if (!isEmpty()) {
            int removedItem = dequeArray[right];
            right = (right - 1 + maxsize) % maxsize;
            nItems--;
            return removedItem;
        }
        return -1;
    }

    public int removeLeft() {
        if (!isEmpty()) {
            int removedItem = dequeArray[left];
            left = (left + 1) % maxsize;
            nItems--;
            return removedItem;
        }
        return -1;
    }

    public int peekLeft() {
        if (!isEmpty()) {
            return dequeArray[left];
        }
        return -1;
    }

    public int peekRight() {
        if (!isEmpty()) {
            return dequeArray[right];
        }
        return -1;
    }

    public boolean isEmpty() {
        return nItems == 0;
    }

    public boolean isFull() {
        return nItems == maxsize;
    }

    @Override
    public String toString() { // returns the deque as a string
        String ret = Arrays.toString(dequeArray);
        ret += "\nleft = " + left;
        ret += "\nright = " + right;

        return ret;
    }
}
