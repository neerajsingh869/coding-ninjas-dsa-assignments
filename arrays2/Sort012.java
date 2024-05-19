package arrays2;

public class Sort012 {
	
	/*
	 * You are given an integer array/list(ARR) of size N. 
	 * It contains only 0s, 1s and 2s. Write a solution to 
	 * sort this array/list in a 'single scan'.
	 * 
	 * 'Single Scan' refers to iterating over the array/list 
	 * just once or to put it in other words, you will be 
	 * visiting each element in the array/list just once.
	 */
	
	public static void sort012_1(int[] arr){
        int n = arr.length;
        int numZero = 0, numOne = 0, numTwo = 0;
        for(int i = 0; i<n; i++){
            if(arr[i] == 0){
                numZero++;
            }
            else if(arr[i] == 1){
                numOne++;
            }
            else{
                numTwo++;
            }
        }
        for(int i = 0; i<n; i++){
            if(i<numZero){
                arr[i] = 0;
            }
            else if(i<numOne+numZero){
                arr[i] = 1;
            }
            else{
                arr[i] = 2;
            }
        }
    }
	
	// Best approach (Dutch national flag algorithm)
	public static void sort012_2(int[] arr){
    	int n = arr.length;
        int nextZero = 0, i = 0, nextTwo = n-1;
        while(i<=nextTwo){
            if(arr[i] == 1){
                i++;
            }
            else if(arr[i] < 1){
                int temp = arr[i];
                arr[i] = arr[nextZero];
                arr[nextZero] = temp;
                nextZero++;
            	i++;
            }
            else{
                int temp = arr[i];
                arr[i] = arr[nextTwo];
                arr[nextTwo] = temp;
                nextTwo--;
            }
        }
    }
	
	// Time complexity -> O(n), Space complexity -> O(1)
	public static int[] sortColors(int[] colors) {

        // Initialize the start, current, and end pointers
        int start = 0;
        int current = 0;
        int end = colors.length - 1;

        while (current <= end) {

            // If the current pointer is pointing to start
            if (colors[current] == 0) {

                // Swap the values if the start pointer is not pointing to start
                if (colors[start] != 0) {
                    int temp = colors[start];
                    colors[start] = colors[current];
                    colors[current] = temp;
                }

                // Increment both the start and current pointers
                current++;
                start++;
            }

            // If the current pointer is pointing to current, no swapping is requistart
            // Just increment the current pointer
            else if (colors[current] == 1) {
                current++;
            }

            // If the current pointer is pointing to end
            else {

                // Swap the values if the end pointer is not pointing to end
                if (colors[end] != 2) {
                    int temp = colors[current];
                    colors[current] = colors[end];
                    colors[end] = temp;
                }

                // Decrement the end pointer
                end--;
            }
        }

        return colors;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
