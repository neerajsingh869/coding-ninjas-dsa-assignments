package arrays2;

public class CheckArrayRotation {
	
	/*
	 * You have been given an integer array/list(ARR) of size N. 
	 * It has been sorted(in increasing order) and then rotated 
	 * by some number 'K' in the right hand direction.
	 * 
	 * Your task is to write a function that returns the value 
	 * of 'K', that means, the index from which the array/list has been rotated.
	 */
	
	public static int arrayRotateCheck1(int[] arr){
    	int n = arr.length;
        int minIdx = 0;
        for(int i = 1; i<n; i++){
            if(arr[i] < arr[minIdx]){
                minIdx = i;
            }
        }
        return minIdx;
    }
	
	public static int arrayRotateCheck2(int[] arr){
    	int n = arr.length;;
        for(int i = 0; i<n-1; i++){
            if(arr[i] > arr[i+1]){
                return i+1;
            }
        }
        return 0;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
