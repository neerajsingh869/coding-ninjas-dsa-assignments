package arrays2;

import java.util.Scanner;

public class InsertionSort {
	
	/*
	 * Provided with a random integer array/list(ARR) of size N, 
	 * you have been required to sort this array using 'Insertion Sort'.
	 */
	
	// Function to input array
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
		for(int i = 0; i<arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}

	// Function to implement insertion sort algorithm
	public static void insertionSort1(int[] arr) {
		int n = arr.length;
		// 0-(i-1)th idx array is sorted locally
		for(int i = 1; i<n; i++) {
			int j = i-1, curr = arr[i];
			while(j>=0 && arr[j] > curr) {
				arr[j+1] = arr[j];
				j--;
			}
			arr[j+1] = curr;
		}
	}
	
	// Function to implement insertion sort algorithm
	public static void insertionSort2(int[] arr) {
    	int n = arr.length;
    	// 0-ith idx array is sorted locally
        for(int i = 0; i<n-1; i++){
            int j = i, key = arr[i+1];
            while(j >= 0 && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
    }
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		insertionSort2(arr);
		printArray(arr);
	}

}
