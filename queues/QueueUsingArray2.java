package queues;

// CIRCULAR QUEUE

public class QueueUsingArray2 {
	private int[] data;
	private int frontIdx;
	private int rearIdx;
	private int size;
	
	public QueueUsingArray2() {
		data = new int[1];
		frontIdx = -1;
		rearIdx = -1;
		size = 0;
	}
	public QueueUsingArray2(int capacity) {
		data = new int[capacity];
		frontIdx = -1;
		rearIdx = -1;
		size = 0;
	}
	
	public void enqueue(int elem) throws QueueFullException {
		if(size == data.length) {
			throw new QueueFullException();
		}
		if(frontIdx == -1) {
			frontIdx = 0;
		}
		rearIdx = (rearIdx + 1)%data.length;
		data[rearIdx] = elem;
		size++;
	}
	
	public int front() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return data[frontIdx];
	}
	
	public int dequeue() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		int front = data[frontIdx];
		data[frontIdx] = 0;
		frontIdx = (frontIdx + 1)%data.length;
		size--;
		if(size == 0) {
			frontIdx = -1;
			rearIdx = -1;
		}
		return front;
	}
	
	public int rear() throws QueueEmptyException {
		if(size == 0) {
			throw new QueueEmptyException();
		}
		return data[rearIdx];
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size==0;
	}
}
