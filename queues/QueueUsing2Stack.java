package queues;

import java.util.Stack;

public class QueueUsing2Stack<T> {
	private Stack<T> st1;
	private Stack<T> st2;
	
	public QueueUsing2Stack() {
		st1 = new Stack<>();
		st2 = new Stack<>();
	}
	
	public void enqueue(T elem) {
		st1.push(elem);
	}
	
	public T front() throws QueueEmptyException {
		if(size() == 0) {
			throw new QueueEmptyException();
		}
		while(st1.size() > 1) {
			st2.push(st1.pop());
		}
		T ans = st1.pop();
		st2.push(ans);
		Stack<T> temp = st1;
		st1 = st2;
		st2 = temp;
		return ans;
	}
	
	public T dequeue() throws QueueEmptyException {
		if(size() == 0) {
			throw new QueueEmptyException();
		}
		while(st1.size() > 1) {
			st2.push(st1.pop());
		}
		T ans = st1.pop();
		Stack<T> temp = st1;
		st1 = st2;
		st2 = temp;
		return ans;
	}
	
	public int size() {
		return st1.size();
	}
	
	public boolean isEmpty() {
		return size()==0;
	}
}
