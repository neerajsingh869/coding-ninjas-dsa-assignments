package priorityQueues;

import java.util.PriorityQueue;

public class KthLargestElement {
	
	/*
	 * Given an array A of random integers and an integer k, 
	 * find and return the kth largest element in the array.
	 * 
	 * Note: Try to do this question in less than O(N * logN) time.
	 */
	
	// Time Complexity -> O(N * logK)
	public static int kthLargest(int n, int[] input, int k) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i<k; i++){
			minHeap.add(input[i]);
		}
		for(int i = k; i<n; i++){
			if(input[i] > minHeap.peek()){
				minHeap.poll();
				minHeap.add(input[i]);
			}
		}
		return minHeap.peek();
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
