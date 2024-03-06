
public class Queue {

	private int maxSize;
	private int[] queArray;
	private int front; // front of the queue
	private int rear; // rear of the queue
	private int nItems;
		
	// --------------------------------------------------------------
	public Queue(int s) // constructor
	{
		maxSize = s;
		queArray = new int[maxSize];
		front = 0;
		rear = -1;
		nItems = 0;
	}

	// --------------------------------------------------------------
	public void enqueue(int item) // put item at rear of queue
	{
		if (rear == maxSize - 1) // deal with wraparound
			rear = -1;
		queArray[++rear] = item; // increment rear and insert
		nItems++; // one more item
	}

	// --------------------------------------------------------------
	public int dequeue() // take item from front of queue
	{
		int temp = queArray[front++]; // get value and increment front
		if (front == maxSize) // deal with wraparound
			front = 0;
		nItems--; // one less item
		return temp;
	}

	// --------------------------------------------------------------
	public int peek() // peek at front of queue
	{
		return queArray[front];
	}

	// --------------------------------------------------------------
	public boolean isEmpty() // true if queue is empty
	{
		return (nItems == 0);
	}

	// --------------------------------------------------------------
	public boolean isFull() // true if queue is full
	{
		return (nItems == maxSize);
	}

	// --------------------------------------------------------------
	public int size() // number of items in queue
	{
		return nItems;
	}
	// --------------------------------------------------------------
	
	
	@Override
	public String toString() {
		String ret = "";
		
		for (int i = front; i != rear; i++) {
			if (i == maxSize) // deal with wraparound
				i -= maxSize;
			ret += queArray[i] + " ";
		}
		ret += queArray[rear] + "\n";
		return ret;		
	}
} // end class QueueX