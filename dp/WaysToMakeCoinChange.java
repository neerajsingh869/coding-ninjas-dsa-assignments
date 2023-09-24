package dp;

public class WaysToMakeCoinChange {
	
	/*
	 * For the given infinite supply of coins of each of 
	 * denominations, D = {D0, D1, D2, D3, ...... Dn-1}. 
	 * You need to figure out the total number of ways W, 
	 * in which you can make the change for Value V using 
	 * coins of denominations D.
	 * 
	 * Return 0 if the change isn't possible.
	 */
	// Solving using Recursion
	public static int countWaysToMakeChange(int denominations[], int value){
        return countWaysToMakeChange_helper(denominations, value, 0);
	}
    
    public static int countWaysToMakeChange_helper(int denominations[], int value, int stIdx){
        int n = denominations.length;
        if(value == 0){
            return 1;
        }
        if(stIdx == n){
            return 0;
        }
        int includeCoinWays = 0, excludeCoinWays;
        if(denominations[stIdx] <= value){
            includeCoinWays = countWaysToMakeChange_helper(denominations, value-denominations[stIdx], stIdx);
        }
        excludeCoinWays = countWaysToMakeChange_helper(denominations, value, stIdx+1);
        return includeCoinWays + excludeCoinWays;
    }
    
    // Solving using Memoization
    public static int countWaysToMakeChangeMemo(int denominations[], int value){
        // Write your code here
        int n = denominations.length;
        int[][] dp = new int[n+1][value+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=value; j++){
                dp[i][j] = -1;
            }
        }
        return countWaysToMakeChangeMemo_helper(denominations, value, 0, dp);
	}
    
    public static int countWaysToMakeChangeMemo_helper(int denominations[], int value, int stIdx, int[][] dp){
        int n = denominations.length;
        if(value == 0){
            return 1;
        }
        if(stIdx == n){
            return 0;
        }
        if(dp[stIdx][value] != -1){
            return dp[stIdx][value];
        }
        int includeCoinWays = 0, excludeCoinWays;
        if(denominations[stIdx] <= value){
            includeCoinWays = countWaysToMakeChangeMemo_helper(denominations, value-denominations[stIdx], stIdx, dp);
        }
        excludeCoinWays = countWaysToMakeChangeMemo_helper(denominations, value, stIdx+1, dp);
        return dp[stIdx][value] = includeCoinWays + excludeCoinWays;
    }
    
    // Solving Using Tabulation
    public static int countWaysToMakeChangeTabu1(int denominations[], int value){
        int n = denominations.length;
        int[][] dp = new int[n+1][value+1];
        for(int i = 0; i<=n; i++){
			dp[i][0] = 1;
        }
        // dp[i][j] means ways to make coin change of value j and i coins
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=value; j++){
                if(denominations[i-1] <= j){
                    dp[i][j] = dp[i-1][j] + dp[i][j-denominations[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][value];
	}
    
    public static int countWaysToMakeChangeTabu2(int denominations[], int value){
        int n = denominations.length;
        int[][] dp = new int[n+1][value+1];
        for(int i = 0; i<=n; i++){
			dp[i][0] = 1;
        }
        // dp[i][j] means ways to make coin change of value j and (i+1) to n coins or it is ith
        // index of coin array
        for(int i = n-1; i>=0; i--){
            for(int j = 1; j<=value; j++){
                if(denominations[i] <= j){
                    dp[i][j] = dp[i+1][j] + dp[i][j-denominations[i]];
                }
                else{
                    dp[i][j] = dp[i+1][j];
                }
            }
        }
        return dp[0][value];
	}
    

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
