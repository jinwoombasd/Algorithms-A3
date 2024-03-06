import java.util.Arrays;

public class Deque {
    
    public Deque(int size) { // constructor that lets you set the max deque size
 
    }
        
    public void insertRight(int item) {
                
    }


    public void insertLeft(int item) {
        
    }
    
    public int removeRight() {
        
    }
    
    public int removeLeft() {
                
    }
    
    public int peekLeft() {

    }
    
    public int peekRight() {

    }

    public boolean isEmpty() {

    }

    public boolean isFull() {

    }
    
    @Override
    public String toString() { // returns the deque as a string
        String ret = Arrays.toString(dequeArray);
        ret += "\nleft = " + left;
        ret += "\nright = " + right;
        
        return ret;
    }
}