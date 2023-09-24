package dp;

public class MinNumberOfSquares {
	
	/*
	 * Given an integer N, find and return the count of 
	 * minimum numbers required to represent N as a sum of squares.
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
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	
	}

}
