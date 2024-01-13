package priorityQueues;

public class HeapSort {
	
	/*
	 * Given an integer array of size N. Sort this array 
	 * (in decreasing order) using heap sort.
	 */
	
	public static void inplaceHeapSort1(int arr[]) {
		int n = arr.length;
		// Converting the array into min-heap (Takes O(n*log(n) time)
		for(int i = 0; i<n; i++) {
			upHeapify(arr, 0, i);
			
		}
		// Removing min from heap and putting it 
		// in the last of array
		for(int i = 0; i<n-1; i++) {
			int toRemove = arr[0];
			arr[0] = arr[n-i-1];
			arr[n-i-1] = toRemove;
			downHeapify(arr, 0, n-i-1);
		}
	}
	
	public static void inplaceHeapSort2(int arr[]) {
		int n = arr.length;
		// Converting the array into min-heap (Takes O(n) time)
		for(int i = n - 1; i>=0; i--) {
			downHeapify(arr, i, n);
		}
		// Removing min from heap and putting it 
		// in the last of array
		for(int i = 0; i<n-1; i++) {
			int toRemove = arr[0];
			arr[0] = arr[n-i-1];
			arr[n-i-1] = toRemove;
			downHeapify(arr, 0, n-i-1);
		}
	}
	
	// Optimized approach
	public static void inplaceHeapSort3(int arr[]) {
		int n = arr.length;
		// Converting the array into min-heap (Takes O(n) time)
		// Here, we are leaving leaf nodes since they are already 
		// heap in themselves (n/2 leaf nodes in heap with nodes n)
		for(int i = n/2 - 1; i>=0; i--) {
			downHeapify(arr, i, n);
		}
		// Removing min from heap and putting it 
		// in the last of array (Takes O(n*log(n)) time)
		for(int i = 0; i<n-1; i++) {
			int toRemove = arr[0];
			arr[0] = arr[n-i-1];
			arr[n-i-1] = toRemove;
			downHeapify(arr, 0, n-i-1);
		}
	}
	
	// O(logn) time complexity
	public static void upHeapify(int[] arr, int topIdx, int bottomIdx) {
		int childIdx = bottomIdx;
		while(childIdx > topIdx) {
			int parentIdx = (childIdx - 1)/2;
			if(arr[parentIdx] > arr[childIdx]) {
				int temp = arr[parentIdx];
				arr[parentIdx] = arr[childIdx];
				arr[childIdx] = temp;
			}
			else {
				break;
			}
			childIdx = parentIdx;
		}
	}
	
	// O(logn) time complexity
	public static void downHeapify(int[] arr, int topIdx, int bottomIdx) {
		int parentIdx = topIdx;
		int leftChildIdx = 2*parentIdx + 1;
		int rightChildIdx = 2*parentIdx + 2;
		int minIdx = leftChildIdx;
		while(leftChildIdx < bottomIdx) {
			if(rightChildIdx < bottomIdx && arr[rightChildIdx] < arr[minIdx]) {
				minIdx = rightChildIdx;
			}
			if(arr[parentIdx] > arr[minIdx]) {
				int temp = arr[parentIdx];
				arr[parentIdx] = arr[minIdx];
				arr[minIdx] = temp;
			}
			else {
				break;
			}
			parentIdx = minIdx;
			leftChildIdx = 2*parentIdx + 1;
			rightChildIdx = 2*parentIdx + 2;
			minIdx = leftChildIdx;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
