package priorityQueues;

import java.util.ArrayList;

/*
 * Space Complexity of all methods is O(1)
 * Time Complexity = O(log(n)) for insert & remove
 * Time Complexity = O(1) for other methods
 */
public class MinPriorityQueue<T> {
	private ArrayList<Element<T>> heap;
	
	public MinPriorityQueue() {
		heap = new ArrayList<>();
	}
	
	private void swapElements(int idx1, int idx2) {
		Element<T> temp = heap.get(idx1);
		heap.set(idx1, heap.get(idx2));
		heap.set(idx2, temp);
	}
	
	public void insert(T value, int priority) {
		Element<T> newEle = new Element<>(value, priority);
		heap.add(newEle);
		int childIdx = size()-1;
		int parentIdx = (childIdx-1)/2;
		while(childIdx > 0) {
			if(heap.get(parentIdx).priority > heap.get(childIdx).priority) {
				swapElements(parentIdx, childIdx);
			}
			else {
				break;
			}
			childIdx = parentIdx;
			parentIdx = (childIdx-1)/2;
		}
	}
	
	public T getMin() throws PriorityQueueException{
		if(size() == 0) {
			throw new PriorityQueueException();
		}
		return heap.get(0).value;
	}
	
	public T removeMin() throws PriorityQueueException{
		int n = size();
		if(n == 0) {
			throw new PriorityQueueException();
		}
		Element<T> toRemove = heap.get(0);
		heap.set(0, heap.get(n-1));
		heap.remove(n-1);
		n = n-1;
		//Find child with minimum priority
		int parentIdx = 0;
		int leftChildIdx = 2*parentIdx + 1;
		int rightChildIdx = 2*parentIdx + 2;
		int minChildEleIdx = leftChildIdx;
		while(leftChildIdx < n){
			if(rightChildIdx < n) {
				if(heap.get(rightChildIdx).priority < heap.get(minChildEleIdx).priority) {
					minChildEleIdx = rightChildIdx;
				}
			}
			if(heap.get(parentIdx).priority > heap.get(minChildEleIdx).priority) {
				swapElements(parentIdx, minChildEleIdx);
			}
			else {
				break;
			}
			parentIdx = minChildEleIdx;
			leftChildIdx = 2*parentIdx + 1;
			rightChildIdx = 2*parentIdx + 2;
			minChildEleIdx = leftChildIdx;
		}
		return toRemove.value;
	}
	
	public int size() {
		return heap.size();
	}
	
	public boolean isEmpty() {
		return heap.size() == 0;
	}
}
