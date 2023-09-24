package priorityQueues;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

public class KLargest {
	
	/*
	 * You are given with an integer k and an array of 
	 * integers that contain numbers in random order. 
	 * Write a program to find k largest numbers from given array. 
	 * You need to save them in an array and return it.
	 * 
	 * Time complexity should be O(n*log(k)) and space complexity 
	 * should be not more than O(k).
	 */
	
	// Can solve it by using normal sorting too
	
	public static ArrayList<Integer> kLargest1(int input[], int k) {
		int n = input.length;
		if (k > n || k <= 0) {
			return null;
		}
		PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
		for (int i = 0; i < n; i++) {
			maxHeap.add(input[i]);
		}
		ArrayList<Integer> ans = new ArrayList<>();
		for (int i = 1; i <= k; i++) {
			ans.add(maxHeap.poll());
		}
		return ans;
	}
	
	public static ArrayList<Integer> kLargest2(int input[], int k) {
		int n = input.length;
		if (k > n || k <= 0) {
			return null;
		}
		PriorityQueue<Integer> minHeap = new PriorityQueue<>();
		for (int i = 0; i < k; i++) {
			minHeap.add(input[i]);
		}
		for (int i = k; i < n; i++) {
			if (input[i] > minHeap.peek()) {
				minHeap.poll();
				minHeap.add(input[i]);
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		while (!minHeap.isEmpty()) {
			ans.add(minHeap.poll());
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
