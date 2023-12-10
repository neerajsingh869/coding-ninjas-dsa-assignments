package arrays2;

import java.util.Scanner;

public class SelectionSort {
	
	/*
	 * Provided with a random integer array/list(ARR) of size N, 
	 * you have been required to sort this array using 'Selection Sort'.
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
	
	// Function to implement Unstable selection sort algorithm
	public static void selectionSort1(int[] arr) {
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
        	int minIdx = i;
            // Finding min element from idx i to n-1
            for(int j = i+1; j<n; j++){
                if(arr[j] <= arr[minIdx]){
                    minIdx = j;
                }
            }
            // Swapping the min element with ith element
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

	// Function to implement Stable selection sort algorithm
	public static void selectionSort2(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n-1; i++) {
			int minIdx = i;
			for(int j = i+1; j<n; j++) {
				if(arr[j] < arr[minIdx]) {
					minIdx = j;
				}
			}
			int key = arr[minIdx];
			while(minIdx > i) {
				arr[minIdx] = arr[minIdx-1];
				minIdx--;
			}
			arr[i] = key;
		}
	}
	
	// recursive approach to implement selection sort
	public static void selectionSort3(int[] arr) {
		selectionSort3(arr, 0);
	}
	
	private static void selectionSort3(int[] arr, int i) {
		int n = arr.length;
		if (i >= n) {
			return;
		}
		
		int smallestEleIdx = getMinIndex(arr, i);
		
		int temp = arr[i];
		arr[i] = arr[smallestEleIdx];
		arr[smallestEleIdx] = temp;
		
		selectionSort3(arr, i + 1);
	}
	
	private static int getMinIndex(int[] arr, int i) {
		int minIdx = i;
		
		for (int j = i + 1; j < arr.length; j++) {
			if (arr[j] < arr[minIdx]) {
				minIdx = j;
			}
		}
		
		return minIdx;
	}
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		selectionSort2(arr);
		printArray(arr);
	}

}
