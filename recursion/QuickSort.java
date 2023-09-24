package recursion;

public class QuickSort {
	
	/*
	 * Sort an array A using Quick Sort.
	 * 
	 * Change in the input array itself. So no need to return 
	 * or print anything.
	 */
	
	// Average Time Complexity - O(n*logn), Space Complexity -> O(n)
	// Worst case Time Complexity -> O(n*n) if array is sorted
	public static void quickSort(int[] input) {
        int n = input.length;
        quickSort(input, 0, n-1);
	}
    
    public static void quickSort(int[] input, int st, int end){
        if(st >= end){
            return;
        }
        int pivotIdx = doPartition1(input, st, end);
        // int pivotIdx = doPartition2(input, st, end);
        quickSort(input, st, pivotIdx-1);
        quickSort(input, pivotIdx+1, end);
    }
    
    public static int doPartition1(int[] input, int st, int end){
        /*
        * First element is our pivot. Now, we have to place all
        * elements smaller or equal to it on it's left side and
        * all bigger elements on it's right. In last, we will
        * return the new pivot index.
        */
        int pivotIdx = st;
        for(int i = st+1; i<=end; i++){
            if(input[i] <= input[pivotIdx]){
                swap(input, pivotIdx+1, i);
            	swap(input, pivotIdx, pivotIdx+1);
            	pivotIdx++;
            }
        }
        return pivotIdx;
    }
    
    public static void swap(int[] input, int i, int j){
        int temp = input[i];
        input[i] = input[j];
        input[j] = temp;
    }
    
    // Another way of doing partition
    public static int doPartition2(int[] input, int st, int end){
    	// Can also take middle element as pivot
        int pivot = input[st];
        int count = 0;
        for(int i = st+1; i<=end; i++){
            if(input[i] <= pivot){
                count++;
            }
        }
        int pivotIndex = st + count;
        swap(input, pivotIndex, st);
        int i = st, j = end;
        while(i<j){
            while(i<=end && input[i] <= pivot){
                i++;
            }
            while(j>=st && input[j] > pivot){
                j--;
            }
            if(i < j){
                swap(input, i, j);
            }
        }
        return pivotIndex;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
