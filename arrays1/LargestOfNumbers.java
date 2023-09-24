package arrays1;

import java.util.Scanner;

public class LargestOfNumbers {
	
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
	
	// Function for finding the largest number
	public static int largest(int[] arr) {
		int ans = Integer.MIN_VALUE;
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			if(arr[i] > ans) {
				ans = arr[i];
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// Taking array as input
		int[] arr = takeInput();
		int max = largest(arr);
		System.out.println(max);
	}
	
}
