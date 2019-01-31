package code;

import java.util.Arrays;

import code.QuickSort.indexPair;
import given.AbstractArraySort;

/*
 * Your sorting algorithm for the sorting spree! 
 * You do not need to use the swap and compare methods of AbstractArraySort here
 * Only the speed of the code and the correctness of the output will be checked
 * 
 * We suggest that you use a hybrid algorithm!
 * 
 */

public class ContestEntrySort<K extends Comparable<K>> extends AbstractArraySort<K> {

	
	
  public ContestEntrySort() {
    // Change the name with your ID!
    name = "60124";
    
    //Initialize anything else here
  }
  
  public class indexPair {
	    public int p1, p2;
	    
	    indexPair(int pos1, int pos2)
	    {
	      p1 = pos1;
	      p2 = pos2;
	    }
	    
	    public String toString()
	    {
	      return "(" + Integer.toString(p1) + ", " + Integer.toString(p2) + ")";
	    }
	  }
  
  @Override
  public void sort(K[] inputArray) {
	  
	  double dLim = 2*Math.log(inputArray.length);
	  iSort(inputArray, 0, inputArray.length-1, dLim);
	  
  }
  
  public void iSort(K[] inputArray, int lo, int hi, double d) {
	  if(lo<hi) {
		  if(hi-lo < 31) {
			  insertionSort(inputArray, lo, hi);
		  } else if(d > 0) {
			  int p = pickPivot(inputArray, lo, hi);
			  indexPair parts = partition(inputArray, lo, hi, p);
			  iSort(inputArray, lo, parts.p1,d);
			  iSort(inputArray, parts.p2, hi,d);
		  } else {
			  heapSort(inputArray);
		  }
	  }
  }
  
  public void insertionSort(K[] inputArray, int s, int e) 
  {  
	for(int i=s+1; i<=e; i++) {
		int j = i;
		while(j>0 && (compare(inputArray[j-1],inputArray[j]) > 0)) {
			swap(inputArray,j,j-1);
			j--;
		}
	}
    
  }
  
  public void heapSort(K[] inputArray) {
		heapify(inputArray);
		int k = inputArray.length-1;
		while(k>0) {
			swap(inputArray, 0, k);
			k--;
			downheap(inputArray, 0, k);
		}

	  }

	  public void heapify(K[] inputArray) {
		for(int i=inputArray.length/2; i>=0; i--) {
			downheap(inputArray, i, inputArray.length-1);
		}
		  
	  }
	  
	  protected void downheap(K[] inputArray, int i, int k) {
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
  
  public indexPair partition(K[] inputArray, int lo, int hi, int p)
  {
	  int u = lo;
	  int e = lo;
	  int g = hi+1;
	  K pivEl = inputArray[p];
	  while(u < g) {
		  if(compare(inputArray[u],pivEl) < 0) {
			  swap(inputArray, u, e);
			  e++;
			  u++;
		  } else if(compare(inputArray[u],pivEl) == 0) {
			  u++;
		  } else {
			  g--;
			  swap(inputArray,u,g);
		  }
	  }
	  indexPair indPair2BeRet = new indexPair(e,g);
	  return indPair2BeRet;
  }
  
  protected int pickPivot(K[] inputArray, int lo, int hi)
  {
    int mid = (hi+lo)/2;
    
    if(compare(inputArray[lo], inputArray[mid])>0) {
    		swap(inputArray,lo,mid);
    }
    
    if(compare(inputArray[lo], inputArray[hi])>0) {
		swap(inputArray,lo,hi);
    }
    
    if(compare(inputArray[mid], inputArray[hi])>0) {
		swap(inputArray,mid,hi);
    }
    
    swap(inputArray,mid,hi-1);
    return hi-1;
  }
  
}
