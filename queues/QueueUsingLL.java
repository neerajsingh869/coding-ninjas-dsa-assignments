package queues;

import linkedLists.Node;

public class QueueUsingLL<T> {
	private Node<T> head;
	private Node<T> tail;
	private int size;
	
	public void enqueue(T data) {
		Node<T> temp = new Node<>(data);
		if(head == null) {
			head = temp;
		}
		else {
			tail.next = temp;
		}
		tail = temp;
		size++;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		T ans = head.data;
		head = head.next;
		size--;
		if(size == 0) {
			tail = null;
		}
		return ans;
	}
	
	public T front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
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
