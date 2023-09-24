package arrays1;

public class ArrangeNumbersInArray {
	
	/*
	 * You have been given an empty array(ARR) and its size N. 
	 * The only input taken from the user will be N and 
	 * you need not worry about the array.
	 * 
	 * Your task is to populate the array using the integer values 
	 * in the range 1 to N(both inclusive) in the order - 1,3,5,.......,6,4,2.
	 */

	public static void arrange1(int[] arr, int n) {
    	//Your code goes here
        int n1 = n/2;
        if(n%2 != 0){
            n1 = n/2 + 1;
        }
        int n2 = n-n1;
        int idx = 0;
        for(int i = 0; i<n1; i++){
            arr[idx++] = 2*i + 1;
        }
        for(int i = n2-1; i>=0; i--){
            arr[idx++] = 2*(i+1);
        }
    }
	
	public static void arrange2(int[] arr, int n) {
    	//Your code goes here
		int left = 0, right = n-1;
        int counter = 1;
        while(left <= right){
            if(counter%2 != 0){
                arr[left] = counter;
                counter++;
                left++;
            }
            else{
                arr[right] = counter;
                counter++;
                right--;
            }
        }
    }
	
	public static void main(String[] args) {
		
	}
	
}
