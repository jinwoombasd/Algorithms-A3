import java.util.Random;

public class Assignment3Checks {

	public static void checkProblem1(int numElements, int maxCapacity) {
		int testCapacity = maxCapacity;
		int maxLong = 100;
		System.out.println("Checking Problem 1...");

		SortableArray actual = new SortableArray(testCapacity);
		SortableArray expected = new SortableArray(testCapacity);

		Random rng = new Random();

		for (int i = 0; i < numElements; i++) {
			int val = rng.nextInt(maxLong);
			actual.insert(val);
			expected.insert(val);
		}

		expected.quickSort();
		float expectedMedian;

		if (expected.size() % 2 == 1)
			expectedMedian = expected.get(expected.size() / 2);
		else {
			long rightVal = expected.get(expected.size() / 2);
			long leftVal = expected.get(expected.size() / 2 - 1);
			expectedMedian = (leftVal + rightVal) / 2f;
		}

		float actualMedian = actual.quickMedian();

		if (expectedMedian == actualMedian) {
			System.out.println("Problem 1 passed the check!");
		} else {
			System.out.println("quickMedian failed!");
			System.out.println("Expected: ");
			System.out.println("****************************\n");
			System.out.println(expectedMedian);
			System.out.println("\n****************************\n");

			System.out.println("Actual: ");
			System.out.println("****************************\n");
			System.out.println(actualMedian);
			System.out.println("\n****************************\n\n");

			System.out.println("Test Data (sorted): ");
			System.out.println("****************************\n");
			System.out.println(expected);
			System.out.println("\n****************************\n\n");
		}
	}

	public static void checkProblem2(int numElements, int maxCapacity) throws Exception {
		// create a new deque to test
		Deque actual = new Deque(maxCapacity);
		java.util.Deque<Integer> expected = new java.util.ArrayDeque<>();
		
		Random rng = new Random();
		System.out.println("\n\nChecking Problem 2...");


		System.out.print("---Testing insert left (uses peek)...");		
		for (int i = 0; i < numElements/2; i++) {
			int value = rng.nextInt(100);
			actual.insertLeft(value);
			expected.addFirst(value);
			if (actual.peekLeft() != expected.getFirst()) {
				System.out.println("\ninsertLeft did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");

		System.out.print("---Testing remove left (uses peek)...");		
		for (int i = 0; i < numElements/4; i++) {
			if (actual.removeLeft() != expected.removeFirst()) {
				System.out.println("\nremoveLeft did not pass a check");
				return;
			}
				
			if (actual.peekLeft() != expected.getFirst()) {
				System.out.println("\nremoveLeft did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");
		
		
		System.out.print("---Testing insert right (uses peek)...");		
		for (int i = 0; i < numElements/2; i++) {
			int value = rng.nextInt(100);
			actual.insertRight(value);
			expected.addLast(value);	
			if (actual.peekRight() != expected.getLast()) {
				System.out.println("\ninsertRight did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");
		
		System.out.print("---Testing remove right (uses peek)...");		
		for (int i = 0; i < numElements/4; i++) {
			if (actual.removeRight() != expected.removeLast()) {
				System.out.println("\nremoveLeft did not pass a check");
				return;
			}
				
			if (actual.peekRight() != expected.getLast()) {
				System.out.println("\nremoveRight did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");
		
		System.out.print("---Testing Dequeue isFull...");		
		actual = new Deque(maxCapacity);
		for (int i = 0; i < maxCapacity; i++) {
			int value = rng.nextInt(100);
			actual.insertLeft(value);
		}
		if (!actual.isFull()) {
			System.out.println("\nisFull did not pass a check");
			return;
		}
		System.out.println(" Success!");
		
		
		System.out.println("Problem 2 passed the check!");
		
		
	}
	
	public static void checkProblem3Queue(int numElements, int maxCapacity) throws Exception {
		Queue actual = new Queue(maxCapacity);
		
		java.util.Queue<Integer> expected = new java.util.ArrayDeque<>();
		
		Random rng = new Random();
		System.out.println("\n\nChecking Queue for Problem 3...");


		System.out.print("---Testing enqueue (uses peek)...");		
		for (int i = 0; i < numElements; i++) {
			int value = rng.nextInt(100);
			actual.enqueue(value);
			expected.add(value);
			if (actual.peek() != expected.peek()) {
				System.out.println("\nenqueue did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");

		System.out.print("---Testing dequeue (uses peek)...");		
		for (int i = 0; i < numElements/2; i++) {
			if (actual.dequeue() != expected.remove()) {
				System.out.println("\ndequeue did not pass a check");
				return;
			}
				
			if (actual.peek() != expected.peek()) {
				System.out.println("\ndequeue did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");
		
		
		System.out.print("---Tensting Queue isFull...");		
		actual = new Queue(maxCapacity);
		for (int i = 0; i < maxCapacity; i++) {
			int value = rng.nextInt(100);
			actual.enqueue(value);
			
		}
		if (!actual.isFull()) {
			System.out.println("\nisFull did not pass a check");
			return;
		}
		System.out.println(" Success!");
		
		System.out.println("Problem 3 Queue passed the check!");
		
		
		
	}
	
	

	public static void checkProblem3Stack(int numElements, int maxCapacity) throws Exception {
		Stack actual = new Stack(maxCapacity);
		
		java.util.Stack<Integer> expected = new java.util.Stack<>();
		
		Random rng = new Random();
		System.out.println("\n\nChecking Queue for Problem 3...");

		System.out.print("---Testing push (uses peek)...");		
		for (int i = 0; i < numElements; i++) {
			int value = rng.nextInt(100);
			actual.push(value);
			expected.push(value);
			if (actual.peek() != expected.peek()) {
				System.out.println("\npush did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");

		System.out.print("---Testing pop (uses peek)...");		
		for (int i = 0; i < numElements/2; i++) {
			if (actual.pop() != expected.pop()) {
				System.out.println("\npop did not pass a check");
				return;
			}
				
			if (actual.peek() != expected.peek()) {
				System.out.println("\npop did not pass a check");
				return;
			}
		}
		System.out.println(" Success!");
		
		
		System.out.print("---Tensting Stack isFull...");		
		actual = new Stack(maxCapacity);
		for (int i = 0; i < maxCapacity; i++) {
			int value = rng.nextInt(100);
			actual.push(value);
			
		}
		if (!actual.isFull()) {
			System.out.println("\nisFull did not pass a check");
			return;
		}
		System.out.println(" Success!");
		
		System.out.println("Problem 3 Stack passed the check!");
		
		
		
	}
	
	public static void main(String[] args) throws Exception {

		// Examples of calling check methods
		
		Random rng = new Random();
		int numElements = rng.nextInt(100);
		int maxCapacity = numElements + rng.nextInt(100);

		checkProblem1(numElements, maxCapacity);
		// checkProblem2(numElements, maxCapacity);
		// checkProblem3Queue(numElements, maxCapacity);
		// checkProblem3Stack(numElements, maxCapacity);

	}
}
