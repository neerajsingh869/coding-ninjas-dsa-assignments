package arrays1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MaximumCandies {
	
	/*
	 * You are given the array ‘children’ of size ‘N’ representing the 
	 * number of candies present at each child. You have a ‘extraCandies’ 
	 * amount of candies. Your task is to find for each child if the child 
	 * has the most candies among all children if all ‘extraCandies’ are 
	 * given to the child.
		You have to return a boolean array. ‘True’ is present at position 
		‘index’ if the child at position ‘index’ will have the maximum amount 
		of candies when given all the ‘extraCandies’ candies.
		For example:
		You are given ‘children’ = [12, 20, 5], and ‘extraCandies’ = ‘9’
		
		If you give all the candies to the child at position 1, the child 
		will have 21 candies, which is the highest among all children.
		
		If you give all the candies to the child at position 2, the child 
		will have 29 candies, which is the highest among all children.
		
		If you give all the candies to the child at position 3, the child 
		will have 14 candies, which is not the highest among all children.
		
		Hence the answer is [True, True, False].
		Input Format:
		The first line of input contains the integer ‘T’ representing the 
		number of test cases.
		
		The first line of each test case contains two integers, ‘N’ and 
		‘extraCandies’, representing the number of children and extra candies.
		
		The second line of each test case contains ‘N’ space-separated 
		integers, denoting the elements of the array ‘children’ where 
		‘children[index]’ represents the number of candies present at 
		child at ‘index’ position.
		Output Format:
		For each test case, print an array of boolean values. ‘True’ is 
		present at position ‘index’ if the child at position ‘index’ has 
		the maximum number of candies among all children after receiving 
		extra candies. Otherwise, ‘False’ is present.
		
		Print a separate line for each test case.
		Note:
		You do not need to print anything. It has already been taken care 
		of. Just implement the function.
		Constraints:
		1 <= T <= 10
		2 <= N <= 10^6
		1 <= children[i] <= 10^9
		1 <= extraCandies <= 10^9
		
		Time Limit: 1 sec
		Sample Input 1:
		2
		3 9
		12 20 5
		2 1
		10 11
		Sample Ouput 1:
		True True False
		True True
		Explanation:
		For the first test case, You are given children = [12, 20, 5], and 
		extraCandies = 9
		
		If you give all the candies to the child at position 1, they will 
		have 21 candies, which is the highest among all children.
		
		If you give all the candies to the child at position 2, they will 
		have 29 candies, which is the highest among all children.
		
		If you give all the candies to the child at position 3, they will 
		have 14 candies, which is not the highest among all children.
		
		Hence the answer is [True, True, False].
		
		For the second test case, You are given children= [10, 11] and 
		extraCandies = 1
		
		If you give all the candies to the child at position 1, they will 
		have 11 candies, which is equal to the highest among all children.
		
		If you give all the candies to the child at position 2, they will 
		have 12 candies, which is the highest among all children.
		
		Hence the answer is [True, True].
		Sample Input 2:
		2
		3 5
		11 18 9
		2 1
		1 2
		Sample Output2:
		False True False
		True True
	 */
	// Time complexity -> O(n), Space complexity -> O(n)
	public static boolean[] maxCandies(int n, int[] children, int extraCandies) {
        int maxCandies = Integer.MIN_VALUE;

        for (int i : children) {
            if (i > maxCandies) {
                maxCandies = i;
            }
        }

        boolean[] ans = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (children[i] + extraCandies >= maxCandies) {
                ans[i] = true;
            } else {
                ans[i] = false;
            }
        }

        return ans;
    }
	
	static int t;
	static int arr[][];
	static int arr1[];

	public static void takeInput() throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		t = Integer.parseInt(br.readLine().split(" ")[0]);
		arr = new int[t][];
		arr1 = new int[t];
		for (int i = 0; i < t; i++) {
			String nums1[] = br.readLine().split(" ");
			int n = Integer.parseInt(nums1[0]);
			arr1[i] = Integer.parseInt(nums1[1]);
			arr[i] = new int[n];
			String nums[] = br.readLine().split(" ");
			for (int j = 0; j < n; j++) {
				arr[i][j] = Integer.parseInt(nums[j]);
			}

		}
	}


	public static void execute() {
		for (int i = 0; i < t; i++) {

			// Get the answer from scaffold/solution
			maxCandies(arr[i].length, arr[i], arr1[i]);
		}
	}

	public static void executeAndPrintOutput() {
		for (int i = 0; i < t; i++) {
			boolean[] result = maxCandies(arr[i].length, arr[i], arr1[i]);
			for (int j = 0; j < result.length; j++) {
				if (result[j])
					System.out.print("True");
				else
					System.out.print("False");

				System.out.print(" ");
			}

			System.out.println();
		}
	}

	public static void main(String[] args) throws NumberFormatException, IOException {
		takeInput();
		executeAndPrintOutput();
	}

}
