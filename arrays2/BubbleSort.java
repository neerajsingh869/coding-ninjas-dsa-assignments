package arrays2;

import java.util.Scanner;

public class BubbleSort {
	
	/*
	 * Provided with a random integer array/list(ARR) of size N, 
	 * you have been required to sort this array using 'Bubble Sort'.
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

	// Function to implement bubble sort algorithm
	public static void bubbleSort1(int[] arr) {
		int n = arr.length;
		for(int i = 0; i<n-1; i++) {
			for(int j = 0; j<n-i-1; j++) {
				if(arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	// Function to implement optimized bubble sort algorithm
	public static void bubbleSort2(int[] arr){
        int n = arr.length;
        for(int i = 0; i<n-1; i++){
            boolean isSwapped = false;
            for(int j = 0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = temp;
                    isSwapped = true;
                }
            }
            if(!isSwapped){
                break;
            }
        }
    }
	
	public static void main(String[] args) {
		int[] arr = takeInput();
		bubbleSort2(arr);
		printArray(arr);
	}

}
