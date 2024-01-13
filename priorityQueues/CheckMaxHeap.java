package priorityQueues;

import java.util.Scanner;
import java.io.IOException;

public class CheckMaxHeap {
	
	/*
	 * Given an array of integers, check whether it represents max-heap or not. 
	 * Return true if the given array represents max-heap, else return false.
	 * 
		Input Format:
		The first line of input contains an integer, that denotes the value of the 
		size of the array. Let us denote it with the symbol N.
		The following line contains N space separated integers, that denote the value 
		of the elements of the array.
		
		Output Format :
		The first and only line of output contains true if it represents max-heap and 
		false if it is not a max-heap.
		
		Constraints:
		1 <= N <= 10^5
		1 <= Ai <= 10^5
		Time Limit: 1 sec
		
		Sample Input 1:
		8
		42 20 18 6 14 11 9 4
		Sample Output 1:
		true
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	public static boolean checkMaxHeap(int arr[]) {
		int n = arr.length;

		for (int i = 0; i < n; i++) {
			int currNode = arr[i];

			int leftChildIdx = 2*i + 1;
			if (leftChildIdx < n && arr[leftChildIdx] > currNode) {
				return false;
			}

			int rightChildIdx = 2*i + 2;
			if (rightChildIdx < n && arr[rightChildIdx] > currNode) {
				return false;
			}
		}

		return true;
	}

	static Scanner s = new Scanner(System.in);
	public static void main(String[] args) throws NumberFormatException, IOException {

        int n = s.nextInt();
		int input[] = new int[n];
		for(int j = 0; j < n; j++) {
			input[j] = s.nextInt();
		}

		System.out.println(checkMaxHeap(input));
	}

}
