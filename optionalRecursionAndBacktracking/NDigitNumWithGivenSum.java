package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class NDigitNumWithGivenSum {
	
	/*
	 * You are given an integral value n and a sum value, you have to find all those n digit numbers whose digit sum is equal to the given sum.
		Input Format:
		The first line of input contains the value of n, and the second line of input contains the sum value.
		Output Format:
		The output contains all those space-separated n-digit numbers whose digit sum is equal to the given.
		Constraints:
		The value of n should lie between [1,20]
		Sample Input:
		6
		2
		Sample Output:
		100001 100010 100100 101000 110000 200000
	 */
	
	// Time Complexity -> O(9^n)
	public static void find(int digits, int sum) {
		find(digits, sum, "", 0);
	}

	private static void find(int digits, int sum, String numTillNow, int sumTillNow){
		if(sumTillNow > sum){
			return;
		}
		if(digits == 0){
			if(numTillNow.charAt(0) != '0' && sum == sumTillNow){
				System.out.print(numTillNow + " ");
			}
			return;
		}
		for(int i = 0; i<=9; i++){
			find(digits-1, sum, numTillNow + Integer.toString(i), sumTillNow+i);
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		
		int digits = s.nextInt();
		int sum = s.nextInt();

		find(digits, sum);
	}

}
