package stacks;

import linkedLists.Node;

public class StackUsingLL<T> {
	private Node<T> head;
	private int size;
	
	public void push(T element) {
		Node<T> newHead = new Node<>(element);
		newHead.next = head;
		head = newHead;
		size++;
	}
	
	public T pop() throws StackEmptyException {
		if(size==0) {
			throw new StackEmptyException();
		}
		T temp = head.data;
		head = head.next;
		size--;
		return temp;
	}
	
	public T top() throws StackEmptyException {
		if(size==0) {
			throw new StackEmptyException();
		}
		return head.data;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
}
