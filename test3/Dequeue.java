package test3;

/*
 * You need to implement a class for Dequeue i.e. for double 
 * ended queue. In this queue, elements can be inserted 
 * and deleted from both the ends.
 * 
 * You don't need to double the capacity.
 * 
 * You need to implement the following functions -
	1. constructor
		You need to create the appropriate constructor. Size for 
		the queue passed is 10.
	2. insertFront -
		This function takes an element as input and insert the 
		element at the front of queue. Insert the element only 
		if queue is not full. And if queue is full, print -1 and return.
	3. insertRear -
		This function takes an element as input and insert the 
		element at the end of queue. Insert the element only if 
		queue is not full. And if queue is full, print -1 and return.
	4. deleteFront -
		This function removes an element from the front of queue. 
		Print -1 if queue is empty.
	5. deleteRear -
		This function removes an element from the end of queue. 
		Print -1 if queue is empty.
	6. getFront -
		Returns the element which is at front of the queue. 
		Return -1 if queue is empty.
	7. getRear -
		Returns the element which is at end of the queue. 
		Return -1 if queue is empty.
 */

public class Dequeue {
	private int[] que;
	private int size;
	private int capacity;

	// Constructor
	public Dequeue(int capacity){
		this.capacity = capacity;
		this.que = new int[capacity];
		this.size = 0;
	}

	// Insert Front
	public void insertFront(int data){
		if(size == capacity){
			System.out.println(-1);
			return;
		}
		for(int i = size-1; i>=0; i--){
			que[i+1] = que[i];
		}
		que[0] = data;
		size++;
	}

	// Insert Rear
	public void insertRear(int data){
		if(size == capacity){
			System.out.println(-1);
			return;
		}
		que[size] = data;
		size++;
	}

	// Delete Front
	public void deleteFront(){
		if(size == 0){
			System.out.println(-1);
			return;
		}
		for(int i = 0; i<size-1; i++){
			que[i] = que[i+1];
		}
		size--;
	}

	// Delete Rear
	public void deleteRear(){
		if(size == 0){
			System.out.println(-1);
			return;
		}
		size--;
	}

	// Get Front
	public int getFront(){
		if(size == 0){
			return -1;
		}
		return que[0];
	}

	// Get Rear
	public int getRear(){
		if(size == 0){
			return -1;
		}
		return que[size-1];
	}
}
