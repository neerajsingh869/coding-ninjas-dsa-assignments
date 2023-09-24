package priorityQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KSmallest {
	
	/*
	 * You are given with an integer k and an array of 
	 * integers that contain numbers in random order. 
	 * Write a program to find k smallest numbers from given array. 
	 * You need to save them in an array and return it.
	 * 
	 * Time complexity should be O(n * log(k)) and space complexity 
	 * should not be more than O(k).
	 * 
	 * Note: Order of elements in the output is not important.
	 */
	
	// Can solve it by using normal sorting too
	
	// Time Complexity -> O(n*log(n))
	// Space Complexity -> O(n)
	public static ArrayList<Integer> kSmallest1(int n, int[] input, int k) {
		if(k > n || k <= 0){
			return null;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for(int i = 0; i<n; i++){
			minHeap.add(input[i]);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for(int i = 1; i<=k; i++){
			ans.add(minHeap.poll());
		}
		return ans;
	}
	
	// Time Complexity -> O(n*log(k))
	// Space Complexity -> O(k)
	public static ArrayList<Integer> kSmallest2(int n, int[] input, int k) {
		if(k > n || k <= 0){
			return null;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for(int i = 0; i<k; i++){
			maxHeap.add(input[i]);
		}
		for(int i = k; i<n; i++){
			if(input[i] < maxHeap.peek()){
				maxHeap.poll();
				maxHeap.add(input[i]);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while(!maxHeap.isEmpty()){
			ans.add(maxHeap.poll());
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
