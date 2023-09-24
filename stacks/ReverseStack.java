package stacks;

import java.util.Stack;

public class ReverseStack {
	
	/*
	 * You have been given two stacks that can store integers 
	 * as the data. Out of the two given stacks, one is 
	 * populated and the other one is empty. You are required 
	 * to write a function that reverses the populated stack 
	 * using the one which is empty.
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static void reverseStack1(Stack<Integer> input, Stack<Integer> extra) {
		int n = input.size();
		if(n == 0){
			return;
		}
		Integer top = input.pop();
		reverseStack1(input, extra);
		while(!input.isEmpty()){
			extra.push(input.pop());
		}
		input.push(top);
		while(!extra.isEmpty()){
			input.push(extra.pop());
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
