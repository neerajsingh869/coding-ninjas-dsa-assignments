package arrays1;

import java.util.Scanner;

public class SwapAlternate {
	/*
	 * You have been given an array/list(ARR) of size N. 
	 * You need to swap every pair of alternate elements 
	 * in the array/list.
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
	
	// Function to print array
	public static void printArray(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n; i++) {
			System.out.print(arr[i] + " ");
		}
	}
	
	// Function to swap alternate elements of array
	public static void swapAlternate(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n-1; i+=2) {
			int temp = arr[i];
			arr[i] = arr[i+1];
			arr[i+1] = temp;
		}
	}

	public static void main(String[] args) {
		int[] arr = takeInput();
		swapAlternate(arr);
		printArray(arr);
	}

}
