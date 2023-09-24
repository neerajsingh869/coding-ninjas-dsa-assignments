package arrays1;

public class Sort01 {
	
	/*
	 * You have been given an integer array/list(ARR) of size N 
	 * that contains only integers, 0 and 1. Write a function 
	 * to sort this array/list. Think of a solution which scans 
	 * the array/list only once and don't require use of an extra array/list.
	 */
	
	public static void sortZeroesAndOne1(int[] arr) {
    	//Your code goes here
        int n = arr.length, i = 0, j = n-1;
        while(i < j){
            if(arr[j] == 0){
                if(arr[i] == 1){
                	int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                    j--;
                }
                i++;
            }
            else{
                j--;
            }
        }
    }
	
	public static void sortZeroesAndOne2(int[] arr) {
    	//Your code goes here
        int n = arr.length, nextZero = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                int temp = arr[nextZero];
                arr[nextZero] = arr[i];
                arr[i] = temp;
                nextZero++;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
