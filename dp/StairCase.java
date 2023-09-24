package dp;

public class StairCase {
	
	/*
	 * A child runs up a staircase with 'n' steps and can 
	 * hop either 1 step, 2 steps or 3 steps at a time. 
	 * Implement a method to count and return all possible 
	 * ways in which the child can run-up to the stairs.
	 */
	// Solving Using Recursion
	public static long staircase(int n) {
		// Base case
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        // Induction Hypothesis and Induction Step
        return staircase(n-1) + staircase(n-2) + staircase(n-3);
	}
	
	// Solving Using Memoization (Time Complexity -> O(n), Space Complexity -> O(n))
	public static long staircaseMemoi(int n){
        long dp[] = new long[n+1];
        for(int i = 0; i<n+1; i++){
            dp[i] = -1;
        }
        return staircaseMemoi_helper(n, dp);
    }

	public static long staircaseMemoi_helper(int n, long dp[]) {
		// Base case
        if(n < 0){
            return 0;
        }
        if(n == 0){
            return 1;
        }
        // Finding answer in dp table
        if(dp[n] != -1){
            return dp[n];
        }
        // If answer is not in dp table, then find the
        // answer and then save it in dp table for future use
        return dp[n] = staircaseMemoi_helper(n-1, dp) + 
            			staircaseMemoi_helper(n-2, dp) + 
            			staircaseMemoi_helper(n-3, dp);
	}
	
	// Solving Using Tabulation (Time Complexity -> O(n), Space Complexity -> O(n))
	public static long staircaseTabu1(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }
        long dp[] = new long[n+1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
        }
        return dp[n];
    }
	
	// Most optimized approach (Time Complexity -> O(n), Space Complexity -> O(1))
	public static long staircaseTabu2(int n){
        if(n == 0){
            return 1;
        }
        if(n == 1 || n == 2){
            return n;
        }
        long a = 1, b = 1, c = 2;
        for(int i = 3; i<n+1; i++){
            long temp = a + b + c;
            a = b;
            b = c;
            c = temp;
        }
        return c;
    }
    
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
