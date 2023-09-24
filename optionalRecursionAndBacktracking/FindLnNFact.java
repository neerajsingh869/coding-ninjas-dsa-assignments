package optionalRecursionAndBacktracking;

import java.util.Scanner;

public class FindLnNFact {
	
	/*
	 * You are given a number N and you have to find ln(N!) that is log value of N factorial. Here, ln denotes log with base e.
Note: You have to return only the integral part of your final answer.
Try to do this problem using recursion.
Input Format:
The only line of input contains the value of N.
Output Format:
The only output line contains the value of ln(N!).
Constraints:
Value of N should lie in the range [1,10000].
Sample Input:
3
Sample Output:
1
Explanation:
ln(3!)=ln(6)=1.791759
So integral part will be 1.
	 */
	
	// Time Complexity -> O(N), Space Complexity -> O(N)
	public static long lnfact(int N) {
		double ans = lnfactDouble(N);
		return (long)ans;
	}

	private static double lnfactDouble(int N){
		if(N == 0 || N == 1){
			return 0.0;
		}
		return lnfactDouble(N-1) + Math.log(N);
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);

		int N = s.nextInt();

		System.out.println(lnfact(N));
	}

}
