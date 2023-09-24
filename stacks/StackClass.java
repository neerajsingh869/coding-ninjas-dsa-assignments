package stacks;

import java.util.Stack;

public class StackClass {

	public static void main(String[] args) {
		Stack<Integer> stack = new Stack<>();
		int[] arr = {1, 2, 3, 4, 5};
		for(int ele:arr) {
			stack.push(ele);
		}
		while(!stack.isEmpty()) {
			System.out.println(stack.pop());
		}
	}

}
