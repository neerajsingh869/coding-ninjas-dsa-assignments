package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class FindNthTerm {
	
	/*
	 * You are given an integer n and you have to print F(n)th term of the sequence if
		F(n)=(1)+(2 * 3)+(4 * 5 * 6)+...n
		Try to solve this problem using recursion.
		Input Format:
		The only line of input contains the value of n
		Output Format:
		The only output line contains F(n)th term.
		Constraints:
		The value of n lies between [0,10]
		Sample Input:
		3
		Sample Output:
		127
		Explanation:
		F(3)=1+(2*3)+(4*5*6)
		    =127
	 */
	
	// Time Complexity -> O(n*n)
	public static long Fnth_term1(int n) {
		long sum = 0;
		int nth_firstNum = 1;
		for(int i = 1; i<=n; i++){
			long multRes = 1;
			for(int k = 1; k<=i; k++){
				multRes *= nth_firstNum;
				nth_firstNum++;
			}
			sum += multRes;
		}
		return sum;
	}
	
	// Time Complexity -> O(n*n)
	public static long Fnth_term2(int n) {
		long lastTerm = n*(n+1)/2;
		return Fnth_term2(n, lastTerm);
	}

	private static long Fnth_term2(int n, long nth_lastTerm){
		if(n == 0 || n == 1){
			return n;
		}
		long nth_term = 1;
		for(int i = 1; i<=n; i++){
			nth_term *= nth_lastTerm;
			nth_lastTerm--;
		}
		return nth_term + Fnth_term2(n-1, nth_lastTerm);
	}
	
	// Time Complexity -> O(n*n)
	public static long Fnth_term3(int n) {
		return Fnth_term3(n, 1, 1);
	}

	private static long Fnth_term3(int n, int currIterNum, int currTermFirstNum){
		if(currIterNum == n + 1){
			return 0;
		}
		long currTerm = 1;
		for(int j = 1; j<=currIterNum; j++){
			currTerm *= currTermFirstNum;
			currTermFirstNum++;
		}
		return currTerm + Fnth_term3(n, currIterNum+1, currTermFirstNum);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int n = s.nextInt();

		System.out.println(Fnth_term2(n));
	}

}
