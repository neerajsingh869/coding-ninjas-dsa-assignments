package arrays2;

public class RotateArray {
	
	/*
	 * You have been given a random integer array/list(ARR) 
	 * of size N. Write a function that rotates the given 
	 * array/list by D elements(towards the left).
	 */
	
	// Good way to solve the problem (Using extra space)
	public static void rotate1(int[] arr, int d) {
        int n = arr.length;
        if(n!=0 && d >= n){
            d %= n;
        }
        int[] temp = new int[d];
        for(int i = 0; i<d; i++){
            temp[i] = arr[i];
        }
        for(int i = d; i<n; i++){
            arr[i-d] = arr[i];
        }
        for(int i = n-d; i<n; i++){
            arr[i] = temp[i-(n-d)];
        }
    }
	
	// Best way to solve the problem (Without using extra space)
	public static void rotate2(int[] arr, int d) {
        int n = arr.length;
        if(n == 0){
            return;
        }
        if(n!=0 && d >= n){
            d %= n;
        }
        reverse(arr, 0, n-1);
        reverse(arr, 0, n-d-1);
        reverse(arr, n-d, n-1);
    }
	
	public static void reverse(int[] arr, int st, int ed){
        while(st<=ed){
            swap(arr, st, ed);
            st++;
            ed--;
        }
    }
	
	public static void swap(int[] arr, int i, int j){
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
