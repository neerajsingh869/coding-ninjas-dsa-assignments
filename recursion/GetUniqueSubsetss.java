package recursion;

import java.util.Arrays;

public class GetUniqueSubsetss {
	
	/*
	 * You are given an sorted integer array of size 'n'.
		Your task is to find and return all the unique subsets of
		the input array.
		Subsets are arrays of length varying from 0 to 'n', that
		contain elements of the array. But the order of elements
		should remain the same as in the input array.
		
		Note:
		The order of subsets is not important. You can return
		the subsets in any order. However, in the output, you
		will see the subsets in lexicographically sorted order.
		
		Example:
		Input: 'n' = 3, 'arr' = [12, 15, 20]
		Output: [[], [12], [12, 15], [12, 15, 20], [12, 20], [15],
		[15, 20], [20]]
		Sample Explanation: Since there are no repeated
		numbers, a total of 8 subsets are generated.
		
		Input Format :
		The first line will contain the value of ‘n’.
		The second line will contain n integers, denoting the
		array 'arr' elements.
		
		Output format :
		Return all unique subsets in any order.
		
		Note :
		You don't need to print anything. It has already been
		taken care of. Just implement the given function.
		
		Sample Input 1 :
		3
		12 15 20
		
		Sample Output 1 :
		[] (this represents an empty array)
		12
		12 15
		12 15 20
		12 20
		15
		15 20
		20
		
		Explanation Of Sample Input 1 :
		Since there are no repeated numbers, 8 subsets are
		generated.
		
		Sample Input 2 :
		3
		1 1 2
		
		Sample Output 2 :
		[]
		1
		1 1
		1 1 2
		1 2
		2
		
		Expected Time Complexity :
		The expected time complexity is O(k * 2^n), where n
		is the size of the array and 'k' is the average size of
		a subset.
		
		Expected Space Complexity :
		The expected time complexity is O(k * 2^n), where n
		is the size of the array and 'k' is the average size of
		a subset.
		
		Constraints :
		1 <= n <= 15
		1 <= arr[i] <= 100
		Time Limit: 1 sec
	 */
	
	public static void printSubsets(int input[]) {
		int[][] ans = subsets(input, 0);

		int n = ans.length;
		for (int i = 0; i < n; i++) {
			boolean isDuplicate = false;

			for (int j = i + 1; j < n; j++) {
				if (Arrays.equals(ans[i], ans[j])) {
						isDuplicate = true;
					}
			}

			if (!isDuplicate) {
				for (int j = 0; j < ans[i].length; j++) {
					System.out.print(ans[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	private static int[][] subsets(int input[], int idx) {
		int n = input.length;
		// base case
		if (n == idx) {
			return new int[1][0];
		}

		// induction hypothesis
		int[][] tempAns = subsets(input, idx + 1);

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

}
