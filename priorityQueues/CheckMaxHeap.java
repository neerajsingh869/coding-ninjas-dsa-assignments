package priorityQueues;

public class CheckMaxHeap {
	
	/*
	 * Given an array of integers, check whether it represents 
	 * max-heap or not. Return true if the given array represents 
	 * max-heap, else return false.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static boolean checkMaxHeap(int arr[]) {
		boolean ans = true;
		int n = arr.length;
		for(int i = 0; i<n; i++){
			int parentIdx = i;
			int leftChildIdx = 2*parentIdx + 1;
			int righChildIdx = 2*parentIdx + 2;
			if(leftChildIdx < n && arr[leftChildIdx] > arr[parentIdx]){
				return false;
			}
			if(righChildIdx < n && arr[righChildIdx] > arr[parentIdx]){
				return false;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
