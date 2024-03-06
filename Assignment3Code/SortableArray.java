import java.util.Arrays;

/*
 * simple version of quick sort
 * pivot is selected as the rightmost element in the subarray
 * */
public class SortableArray {

	private long[] array; // ref to array theArray
	private int nElems; // number of data items
	// --------------------------------------------------------------

	public SortableArray(int max) // constructor
	{
		array = new long[max]; // create the array
		nElems = 0; // no items yet
	}

	// --------------------------------------------------------------
	public void insert(long value) // put element into array
	{
		array[nElems] = value; // insert it
		nElems++; // increment size
	}

	public long get(int index) {
		return array[index];
	}

	public int size() {
		return nElems;
	}

	public String toString() // displays array contents
	{
		return "Capacity: " + array.length +
				"\nElements: " + nElems +
				"\nContent:" + Arrays.toString(array);
	}

	// --------------------------------------------------------------
	public void display() // displays array contents
	{
		System.out.print("A=");
		for (int j = 0; j < nElems; j++) // for each element,
			System.out.print(array[j] + " "); // display it
		System.out.println("");
	}

	// --------------------------------------------------------------
	public void quickSort() {
		recQuickSort(0, nElems - 1);
	}

	// --------------------------------------------------------------
	public void recQuickSort(int left, int right) {
		if (right - left <= 0) // if size <= 1,
			return; // already sorted
		else // size is 2 or larger
		{
			long pivot = array[right]; // rightmost item
										// partition range
			int partition = partitionIt(left, right, pivot);
			recQuickSort(left, partition - 1); // sort left side
			recQuickSort(partition + 1, right); // sort right side
		}
	} // end recQuickSort()
		// --------------------------------------------------------------

	public int partitionIt(int left, int right, long pivot) {
		int leftPtr = left; // left
		int rightPtr = right - 1; // skip the pivot (rightmost value)

		while (true) { // find bigger item
			while (array[leftPtr] < pivot)
				leftPtr++; // (nop)
			// find smaller item
			while (rightPtr > 0 && array[rightPtr] >= pivot)
				rightPtr--; // (nop)

			if (leftPtr >= rightPtr) // if pointers cross,
				break; // partition done
			else // not crossed, so
				swap(leftPtr, rightPtr); // swap elements
		} // end while(true)
		swap(leftPtr, right); // restore pivot
		return leftPtr; // return pivot location
	} // end partitionIt()
		// --------------------------------------------------------------

	public void swap(int dex1, int dex2) // swap two elements
	{
		long temp = array[dex1]; // A into temp
		array[dex1] = array[dex2]; // B into A
		array[dex2] = temp; // temp into B
	} // end swap(
		// --------------------------------------------------------------

	public float quickMedian() {
		// Array is empty, no median
		if (nElems == 0) {
			return Float.NaN;
		}

		int left = 0;
		int right = nElems - 1;
		int size = right - left + 1;

		// Array contains only one element
		if (size == 1) {
			return array[left];
		}

		int medianIndex = nElems / 2;

		if (nElems % 2 == 1) {

			while (true) {
				long pivot = array[right];
				int partition = partitionIt(left, right, pivot);

				if (partition == medianIndex) {

					return array[partition];

				} else if (partition < medianIndex) {
					left = partition + 1;
				} else {
					right = partition - 1;
				}
			}

		}
		else {

			long val1;
			while (true) {
				long pivot = array[right];
				int partition = partitionIt(left, right, pivot);

				if (partition == medianIndex) {

					val1 = array[partition];
					break;

				} else if (partition < medianIndex) {
					left = partition + 1;
				} else {
					right = partition - 1;
				}
			}
			while (true) {
				long pivot = array[right];
				int partition = partitionIt(left, right, pivot);

				if (partition == medianIndex - 1) {

					return (val1 + array[partition] ) / 2;

				} else if (partition < medianIndex) {
					left = partition + 1;
				} else {
					right = partition - 1;
				}
			}
		}
		
	}

}
