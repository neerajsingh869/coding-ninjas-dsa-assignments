package stacks;

public class Stack1Use {

	public static void main(String[] args) throws StackFullException, StackEmptyException {
		// To make stack, create object of StackUsingArray class
		StackUsingArray stack = new StackUsingArray();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack.size());
		System.out.println(stack.top());
		stack.pop();
//		System.out.println(stack.pop());
		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
	}

}
