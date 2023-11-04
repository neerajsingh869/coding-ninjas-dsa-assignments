package recursion;

import java.util.Scanner;

public class ReturnSubsetsOfArray {
	
	/*
	 * Given an integer array (of length n), find and return 
	 * all the subsets of input array.
		Subsets are of length varying from 0 to n, that contain elements 
		of the array. But the order of elements should remain same as 
		in the input array.
		
		Note :
		The order of subsets are not important.
		
		Input format :
		Line 1 : Size of array
		Line 2 : Array elements (separated by space)
		
		Sample Input:
		3
		15 20 12
		Sample Output:
		[] (this just represents an empty array, don't worry about the square brackets)
		12 
		20 
		20 12 
		15 
		15 12 
		15 20 
		15 20 12 
	 */
	// Time complexity -> O(2^n), Space complexity -> O(2^n)
	public static int[][] returnSubsets(int input[]) {
		return returnSubsets(input, 0);
	}
	
	private static int[][] returnSubsets(int input[], int idx) {
		int n = input.length;
		// base case
		if (n == idx) {
			return new int[1][0];
		}

		// induction hypothesis
		int[][] tempAns = returnSubsets(input, idx + 1);

		// induction step
		int[][] ans = new int[2 * tempAns.length][0];

		int i = 0;
		for (; i < tempAns.length; i++) {
			ans[i] = new int[tempAns[i].length];

			for (int j = 0; j < tempAns[i].length; j++) {
				ans[i][j] = tempAns[i][j];
			}
		}

		for (; i < 2 * tempAns.length; i++) {
			ans[i] = new int[tempAns[i - tempAns.length].length + 1];
			ans[i][0] = input[idx];

			for (int j = 0; j < tempAns[i - tempAns.length].length; j++) {
				ans[i][j + 1] = tempAns[i - tempAns.length][j];
			}
		}

		return ans;
	}

	public static int[] takeInput() {
		Scanner s = new Scanner(System.in);
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int output[][] = returnSubsets(input);
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
