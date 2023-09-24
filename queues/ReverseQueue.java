package queues;

import java.util.Queue;

public class ReverseQueue {
	
	/*
	 * You have been given a queue that can store integers 
	 * as the data. You are required to write a function 
	 * that reverses the populated queue itself without 
	 * using any other data structures.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static void reverseQueue(Queue<Integer> input) {
		if(input.size() == 0){
			return;
		}
		Integer front = input.poll();
		reverseQueue(input);
		input.add(front);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
