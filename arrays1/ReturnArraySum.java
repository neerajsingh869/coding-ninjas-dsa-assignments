package arrays1;

public class ReturnArraySum {
	
	/*
	 * Given an array/list(ARR) of length N, you need 
	 * to find and return the sum of all the elements in the array/list.
	 */
	
	public static int sum(int[] arr) {
		//Your code goes here
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
        }
        return sum;
	}
	
	public static void main(String[] args) {
		
	}
	
}
