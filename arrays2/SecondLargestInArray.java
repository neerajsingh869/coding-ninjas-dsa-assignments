package arrays2;

import java.util.Arrays;

public class SecondLargestInArray {
	
	/*
	 * You have been given a random integer array/list(ARR) of size N. 
	 * You are required to find and return the second largest element 
	 * present in the array/list.
	 * 
	 * If N <= 1 or all the elements are same in the array/list then 
	 * return -2147483648 or -2 ^ 31(It is the smallest value for the range of Integer)
	 */
	
	// Simple approach
	public static int secondLargestElement1(int[] arr) {
        int n = arr.length;
        Arrays.sort(arr);
        int ans = Integer.MIN_VALUE;
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[n-1]){
                ans = arr[i];
                break;
            }
        }
        return ans;
    }
	
	// Better approach
	public static int secondLargestElement(int[] arr) {
        int n = arr.length;
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else{
                if(arr[i] != largest && arr[i] > secondLargest){
                    secondLargest = arr[i];
                }
            }
        }
        return secondLargest;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
