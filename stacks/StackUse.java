package stacks;

public class StackUse {

	public static void main(String[] args) throws StackEmptyException {
//		StackUsingArray stack = new StackUsingArray();
		StackUsingLL<Integer> stack = new StackUsingLL<>();
		int arr[] = {4, 10, 9, 3, 2};
		for(int i = 0; i<arr.length; i++) {
			stack.push(arr[i]);
		}
		for(int i = 0; i<arr.length; i++) {
			System.out.println(stack.pop());
		}
	}

}
