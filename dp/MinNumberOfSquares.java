package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinNumberOfSquares {
	
	/*
	 * Given an integer N, find and return the count of minimum
		numbers required to represent N as a sum of squares.
		
		That is, if N is 4, then we can represent it as : {1^2 + 1^2
		+ 1^2 + 1^2} and {2^2}. The output will be 1, as 1 is the
		minimum count of numbers required to represent N as
		sum of squares.
		
		Input format :
		The first and the only line of input contains an
		integer value, 'N'.
		
		Output format :
		Print the minimum count of numbers required.
		
		Constraints :
		0 <= n <= 10 ^ 4
		Time Limit: 1 sec
		
		Sample Input 1 :
		12
		
		Sample Output 1 :
		3
		
		Explanation of Sample Output 1 :
		12 can be represented as :
		A) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) +
		(1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2)
		B) (1^2) + (1^2) + (1^2) + (1^2) + (1^2) + (1^2) +
		(1^2) + (1^2) + (2 ^ 2)
		C) (1^2) + (1^2) + (1^2) + (1^2) + (2 ^ 2) + (2 ^ 2)
		D) (2 ^ 2) + (2 ^ 2) + (2 ^ 2)
		As we can see, the output should be 3.
		
		Sample Input 2 :
		9
		
		Sample Output 2 :
		1
	 */
	// Solving Using Recursion
	public static int minCount(int n) {
        if(n <= 0){
            return 0;
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + minCount(n-i*i));
        }
        return ans;
	}
	
	// Solving Using Memoization
	public static int minCountMemoi(int n) {
        int[] dp = new int[n+1];
        for(int i = 0; i<n+1; i++){
            dp[i] = -1;
        }
        return minCountMemoi_helper(n, dp);
	}
    
    public static int minCountMemoi_helper(int n, int dp[]){
        if(n <= 0){
            return 0;
        }
        if(dp[n] != -1){
            return dp[n];
        }
        int ans = Integer.MAX_VALUE;
        for(int i = 1; i*i <= n; i++){
            ans = Math.min(ans, 1 + minCountMemoi_helper(n-i*i, dp));
        }
        return dp[n] = ans;
    }
	
    // Solving Using Tabulation
    public static int minCountTabu(int n) {
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i<=n; i++){
            dp[i] = Integer.MAX_VALUE;
            for(int j = 1; j*j <= i; j++){
				dp[i] = Math.min(dp[i], 1 + dp[i-j*j]);
            }
        }
        return dp[n];
	}
	
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws NumberFormatException, IOException {
            int n = Integer.parseInt(br.readLine().trim());
            System.out.println(minCountTabu(n));
    }

}
