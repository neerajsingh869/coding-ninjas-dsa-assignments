package dp;

public class Knapsack {
	
	/*
	 * A thief robbing a store can carry a maximal weight 
	 * of W into his knapsack. There are N items, and i-th 
	 * item weigh 'Wi' and the value being 'Vi.' What would 
	 * be the maximum value V, that the thief can steal?
	 */
	// Solving using Recursion
	public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
		// Base case
        if(n == 0 || maxWeight <= 0){
			return 0;
        }
        // or base case
//        if(n == 0) {
//        	return 0;
//        }
        int includeItem = 0;
        if(maxWeight - weights[n-1] >= 0){
        	includeItem = values[n-1] + knapsack(weights, values, n-1, maxWeight - weights[n-1]); 
        }
        int	excludeItem = knapsack(weights, values, n-1, maxWeight);
        
        return Math.max(includeItem, excludeItem);
	}
	
	// Solving using Memoization
	public static int knapsackMemo(int[] weights, int[] values, int n, int maxWeight) {
		// Base case
        int[][] dp = new int[n+1][maxWeight+1];
        for(int i = 0; i<=n; i++){
            for(int j = 0; j<=maxWeight; j++){
                dp[i][j] = -1;
            }
        }
        return knapsackMemo_helper(weights, values, n, maxWeight, dp);
	}
    
    public static int knapsackMemo_helper(int[] weights, int[] values, int n, int maxWeight, int[][] dp){
        if(n == 0 || maxWeight <= 0){
			return 0;
        }
        if(dp[n][maxWeight] != -1){
            return dp[n][maxWeight];
        }
        int includeItem = 0;
        if(maxWeight - weights[n-1] >= 0){
        	includeItem = values[n-1] + knapsackMemo_helper(weights, values, n-1, maxWeight - weights[n-1], dp); 
        }
        int excludeItem = knapsackMemo_helper(weights, values, n-1, maxWeight, dp);
        
        return dp[n][maxWeight] = Math.max(includeItem, excludeItem);
    }
    
    //
    public static int knapsackTabu(int[] weights, int[] values, int n, int maxWeight) {
		// Base case
        int[][] dp = new int[n+1][maxWeight+1];
        // In java, by default all the cell in array are 0.
        // So, you don't need to explicitly do that.
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=maxWeight; j++){
                if(j - weights[i-1] >= 0){
					dp[i][j] = Math.max(values[i-1] + dp[i-1][j-weights[i-1]], dp[i-1][j]);
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][maxWeight];
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
