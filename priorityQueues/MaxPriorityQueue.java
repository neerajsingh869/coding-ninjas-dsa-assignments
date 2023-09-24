package priorityQueues;

import java.util.ArrayList;

/*
 * Space Complexity of all methods is O(1)
 * Time Complexity = O(log(n)) for insert & remove
 * Time Complexity = O(1) for other methods
 */
public class MaxPriorityQueue {
		ArrayList<Integer> heap;
		public MaxPriorityQueue(){
			heap = new ArrayList<>();
		}
		boolean isEmpty() {
			return (heap.size() == 0);
		}

		int getSize() {
			return heap.size();
		}

		int getMax() {
			if(isEmpty()){
				return Integer.MIN_VALUE;
			}
			return heap.get(0);
		}

		void insert(int element) {
			heap.add(element);
			int n = heap.size();
			int childIdx = n-1;
			while(childIdx > 0){
				int parentIdx = (childIdx-1)/2;
				if(heap.get(parentIdx) < heap.get(childIdx)){
					int temp = heap.get(childIdx);
					heap.set(childIdx, heap.get(parentIdx));
					heap.set(parentIdx, temp);
				}
				else{
					break;
				}
				childIdx = parentIdx;
			}
		}

		int removeMax() {
			if(isEmpty()){
				return Integer.MIN_VALUE;
			}
			int n = heap.size();
			int toRemove = heap.get(0);
			heap.set(0, heap.get(n-1));
			heap.remove(n-1);
			n = n-1;
			int parentIdx = 0;
			int leftChildIdx = 2*parentIdx + 1;
			int rightChildIdx = 2*parentIdx + 2;
			int maxChildIdx = leftChildIdx;
			while(leftChildIdx < n){
				if(rightChildIdx < n && heap.get(rightChildIdx) > heap.get(maxChildIdx)){
					maxChildIdx = rightChildIdx;
				}
				if(heap.get(parentIdx) < heap.get(maxChildIdx)){
					int temp = heap.get(parentIdx);
					heap.set(parentIdx, heap.get(maxChildIdx));
					heap.set(maxChildIdx, temp);
				}
				else{
					break;
				}
				parentIdx = maxChildIdx;
				leftChildIdx = 2*parentIdx + 1;
				rightChildIdx = 2*parentIdx + 2;
				maxChildIdx = leftChildIdx;
			}
			return toRemove;
		}
}
