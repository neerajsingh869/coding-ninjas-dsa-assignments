package arrays1;

import java.util.Scanner;

public class FindUnique {
	
	/*
	 * You have been given an integer array/list(ARR) of size N. 
	 * Where N is equal to [2M + 1].
	 * Now, in the given array/list, 'M' numbers are present 
	 * twice and one number is present only once.
	 * You need to find and return that number which is unique in the array/list.
	 */
	
	// Function to take input
	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1);
	public static int findUnique1(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n; i++){
            int j;
            for(j = 0; j<n; j++){
                if(j!=i && arr[i] == arr[j]){
                    break;
                }
            }
            if(j == n){
                return arr[i];
            }
        }
        return Integer.MAX_VALUE; 
    }
	
	// Time Complexity -> O(n), Space Complexity -> O(1);
	public static int findUnique2(int[] arr){
		//Your code goes here
        int n = arr.length, ans = 0;
        for(int i = 0; i<n; i++){
            ans^=arr[i];
        }
        return ans;
    }

	public static void main(String[] args) {
		int[] arr = takeInput();
		System.out.println(findUnique2(arr));
	}

}
