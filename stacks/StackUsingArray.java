package stacks;

public class StackUsingArray {
	private int[] data;
	private int topIndex;
	// Default constructor to initialize object
	public StackUsingArray() {
		data = new int[1];
		topIndex = -1;
	}
	// Parameterized constructor to get custom size of array
	public StackUsingArray(int size) {
		data = new int[size];
		topIndex = -1;
	}
	// Push function of stack
	public void push(int element){
		if(topIndex+1 == data.length) {
			doubleArray();
		}
		data[++topIndex] = element;
	}
	// Function to doubling the array if the array is full
	private void doubleArray() {
		int[] temp = new int[2*data.length];
		for(int i = 0; i<data.length; i++) {
			temp[i] = data[i];
		}
		data = temp;
	}
	// Pop function of stack
	public int pop() throws StackEmptyException{
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		return data[topIndex--];
	}
	// Top function of stack
	public int top() throws StackEmptyException{
		if(topIndex == -1) {
			throw new StackEmptyException();
		}
		return data[topIndex];
	}
	// Size function of stack
	public int size() {
		return topIndex+1;
	}
	// Function to tell whether stack is empty or not
	public boolean isEmpty() {
		return topIndex == -1;
	}
}
