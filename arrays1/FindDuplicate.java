package arrays1;

import java.util.Arrays;

public class FindDuplicate {
	
	/*
	 * You have been given an integer array/list(ARR) of 
	 * size N which contains numbers from 0 to (N - 2). 
	 * Each number is present at least once. That is, 
	 * if N = 5, the array/list constitutes values ranging 
	 * from 0 to 3 and among these, there is a single 
	 * integer value that is present twice. You need to 
	 * find and return that duplicate number present in the array.
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static int duplicateNumber1(int arr[]) {
    	//Your code goes here
        int n = arr.length;
        int idealSum = 0, realSum = 0;
        for(int i = 0; i<n; i++){
            if(i != n-1){
                idealSum += i;
            }
            realSum += arr[i];
        }
        return realSum - idealSum;
    }
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int duplicateNumber2(int arr[]) {
    	//Your code goes here
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            for(int j = i+1; j<n; j++){
                if(arr[i] == arr[j]){
                    return arr[i];
                }
            }
        }
        return Integer.MAX_VALUE;
    }
	
	// Time Complexity -> O(n*logn), Space Complexity -> O(1)
	public static int duplicateNumber3(int[] arr) {
		int n = arr.length;
        Arrays.sort(arr);
        for(int i = 0; i<n; i++){
            if(i != arr[i]){
            	return arr[i];
            }
        }
        return Integer.MAX_VALUE;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
