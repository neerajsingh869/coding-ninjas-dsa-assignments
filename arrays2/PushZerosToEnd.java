package arrays2;

public class PushZerosToEnd {
	
	/*
	 * You have been given a random integer array/list(ARR) of size N. 
	 * You have been required to push all the zeros that are present 
	 * in the array/list to the end of it. Also, make sure to maintain 
	 * the relative order of the non-zero elements.
	 */
	
	public static void pushZerosAtEnd1(int[] arr) {
        int n = arr.length;
        int[] arr2 = new int[n];
        for(int i = 0; i<n; i++){
            arr2[i] = arr[i];
        }
        int k = 0;
        for(int i = 0; i<n; i++){
            if(arr2[i] != 0){
                arr[k++] = arr2[i];
            }
        }
        for(; k<n; k++){
            arr[k] = 0;
        }
    }
	
	// Best approach
	public static void pushZerosAtEnd2(int[] arr) {
    	int n = arr.length;
        int nonZeroCount = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] != 0){
                int temp = arr[i];
                arr[i] = arr[nonZeroCount];
                arr[nonZeroCount] = temp;
                nonZeroCount++;
            }
        }
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
