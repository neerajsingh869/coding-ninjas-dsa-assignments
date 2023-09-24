package stacks;

public class Stack2Use {
	
	public static void main(String[] args) throws StackEmptyException{
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		System.out.println(stack.size());
		System.out.println(stack.top());
		System.out.println(stack.pop());
		System.out.println(stack.size());
		System.out.println(stack.top());
		System.out.println(stack.isEmpty());
	}
	
}
