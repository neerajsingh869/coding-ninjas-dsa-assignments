package arrays2;

public class BinarySearch {
	
	/*
	 * You have been given a sorted(in ascending order) 
	 * integer array/list(ARR) of size N and an element X. 
	 * Write a function to search this element in the given 
	 * input array/list using 'Binary Search'. Return the 
	 * index of the element in the input array/list. In case 
	 * the element is not present in the array/list, then return -1.
	 */
	
	public static int binarySearch(int[] arr, int x) {
    	//Your code goes here
        int n = arr.length;
        int i = 0, j = n-1;
        while(i<=j){
            int midIdx = i + (j-i)/2;
            if(arr[midIdx] == x){
                return midIdx;
            }
            else if(arr[midIdx] > x){
                j = midIdx-1;
            }
            else{
                i = midIdx+1;
            }
        }
        return -1;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
