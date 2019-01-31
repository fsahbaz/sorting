package code;

import given.AbstractArraySort;

/*
 * Implement the heap-sort algorithm here. You can look at the slides for the pseudo-code.
 * Make sure to use the swap and compare functions given in the AbstractArraySort!
 * 
 */

public class HeapSort<K extends Comparable<K>> extends AbstractArraySort<K> {

  // Add any fields here

  public HeapSort() {
    name = "Heapsort";

    // Initialize anything else here
  }

  @Override
  public void sort(K[] inputArray) {
    // TODO: Implement the heap-sort algorithm
	heapify(inputArray);
	int k = inputArray.length-1;
	while(k>0) {
		swap(inputArray, 0, k);
		k--;
		downheap(inputArray, 0, k);
	}

  }

  // Public since we are going to check its output!
  public void heapify(K[] inputArray) {
    // TODO: Heapify the array. See the slides for an O(n) version which uses
    // downheap
	for(int i=inputArray.length/2; i>=0; i--) {
		downheap(inputArray, i, inputArray.length-1);
	}
	  
  }
  
  // The below methods are given given as suggestion. You do not need to use them.
  // Feel free to add more methods

  protected void downheap(K[] inputArray, int i, int k) {
    // TODO: Implement the downheap method to help with the algorithm
	int ind = i;
	int leftC = 2*i + 1;
	int rightC = 2*i + 2;
	if(leftC <= k && compare(inputArray[ind],inputArray[leftC]) < 0) {
		ind = leftC;
	}
	if(rightC <= k && compare(inputArray[ind],inputArray[rightC]) < 0) {
		ind = rightC;
	}
	
	if(ind != i) {
		swap(inputArray, i, ind);
		downheap(inputArray, ind, k);
	}
	
  }
}