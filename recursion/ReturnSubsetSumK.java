package recursion;

import java.util.Scanner;

public class ReturnSubsetSumK {
	
	/*
	 * Given an array A of size n and an integer K, return all subsets of A 
	 * which sum to K.
		Subsets are of length varying from 0 to n, that contain elements of the array. 
		But the order of elements should remain same as in the input array.
		
		Note :
		The order of subsets are not important.
		
		Input format :
		Line 1 : Integer n, Size of input array
		Line 2 : Array elements separated by space
		Line 3 : K 
		
		Constraints :
		1 <= n <= 20
		
		Sample Input :
		9 
		5 12 3 17 1 18 15 3 17 
		6
		Sample Output :
		3 3
		5 1
	 */
	// Brute force approach
	public static int[][] subsetsSumK1(int input[], int k) {
		int n = input.length;
		// base cases
		if (k == 0 && n >= 0) {
			return new int[1][0];
		}

		if (n == 0) {
			return new int[0][0];
		}

		// induction hypothesis
		int[] tempInput = new int[n - 1];
		for (int i = 0; i < n - 1; i++) {
			tempInput[i] = input[i + 1];
		}
		
		int[][] tempAns1 = subsetsSumK1(tempInput, k - input[0]);
		int n1 = tempAns1.length;

		int[][] tempAns2 = subsetsSumK1(tempInput, k);
		int n2 = tempAns2.length;

		// induction step
		int[][] ans = new int[n1 + n2][0];
		int i = 0;
		for (; i < n1; i++) {
			int column = tempAns1[i].length;
			ans[i] = new int[column + 1];
			ans[i][0] = input[0];

			for (int j = 0; j < column; j++) {
				ans[i][j + 1] = tempAns1[i][j];
			}
		}

		for (; i < n1 + n2; i++) {
			int column = tempAns2[i - n1].length;
			ans[i] = new int[column];

			for (int j = 0; j < column; j++) {
				ans[i][j] = tempAns2[i - n1][j];
			}
		}

		return ans;
	}
	
	// Better approach
	public static int[][] subsetsSumK2(int input[], int k) {
		return subsetsSumK2(input, 0, k);
	}

	private static int[][] subsetsSumK2(int input[], int idx, int k) {
		int n = input.length;
		// base cases
		if (k == 0 && idx >= n) {
			return new int[1][0];
		}

		if (n == idx) {
			return new int[0][0];
		}

		// induction hypothesis
		int[][] tempAns1 = subsetsSumK2(input, idx + 1, k - input[idx]);
		int n1 = tempAns1.length;

		int[][] tempAns2 = subsetsSumK2(input, idx + 1, k);
		int n2 = tempAns2.length;

		// induction step
		int[][] ans = new int[n1 + n2][0];
		int i = 0;
		for (; i < n1; i++) {
			int column = tempAns1[i].length;
			ans[i] = new int[column + 1];
			ans[i][0] = input[idx];

			for (int j = 0; j < column; j++) {
				ans[i][j + 1] = tempAns1[i][j];
			}
		}

		for (; i < n1 + n2; i++) {
			int column = tempAns2[i - n1].length;
			ans[i] = new int[column];

			for (int j = 0; j < column; j++) {
				ans[i][j] = tempAns2[i - n1][j];
			}
		}

		return ans;
	}

	static Scanner s = new Scanner(System.in);
	public static int[] takeInput() {
		int size = s.nextInt();
		int arr[] = new int[size];
		for (int i = 0; i < size; i++) {
			arr[i] = s.nextInt();
		}
		return arr;
	}
	
	public static void main(String[] args) {
		int[] input = takeInput();
		int k = s.nextInt();
		
		int output[][] = subsetsSumK2(input, k);
		
		for(int i = 0; i < output.length; i++) {
			for(int j = 0; j < output[i].length; j++) {
				System.out.print(output[i][j] + " ");
			}
			System.out.println();
		}
	}

}
