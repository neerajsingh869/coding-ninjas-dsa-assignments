package dp;

public class LootHouses {

	/*
	 * A thief wants to loot houses. He knows the amount 
	 * of money in each house. He cannot loot two consecutive 
	 * houses. Find the maximum amount of money he can loot.
	 */
	// Solving Using Recursion
	public static int maxMoneyLooted(int[] houses) {
        return maxMoneyLooted_helper(houses, 0);
	}
    
    public static int maxMoneyLooted_helper(int[] houses, int stIdx){
        int n = houses.length;
        if(n <= stIdx){
            return 0;
        }
        int lootHouse1 = houses[stIdx] + maxMoneyLooted_helper(houses, stIdx+2);
        int doNotLootHouse1 = maxMoneyLooted_helper(houses, stIdx+1);
        return Math.max(lootHouse1, doNotLootHouse1);
    }
	
    // Solving Using Memoization
	public static int maxMoneyLootedMemoi(int[] houses) {
        int n = houses.length;
        int[] dp = new int[n+1];
        for(int i = 0; i<=n; i++){
            dp[i] = -1;
        }
        return maxMoneyLootedMemoi_helper(houses, 0, dp);
	}
    
    public static int maxMoneyLootedMemoi_helper(int[] houses, int stIdx, int[] dp){
        int n = houses.length;
        if(n <= stIdx){
            return 0;
        }
        if(dp[n-stIdx] != -1){
            return dp[n-stIdx];
        }
        int lootHouse1 = houses[stIdx] + maxMoneyLootedMemoi_helper(houses, stIdx+2, dp);
        int doNotLootHouse1 = maxMoneyLootedMemoi_helper(houses, stIdx+1, dp);
        return dp[n-stIdx] = Math.max(lootHouse1, doNotLootHouse1);
    }
    
    // Solving Using Tabulation
    public static int maxMoneyLootedTabu(int[] houses) {
        return maxMoneyLootedTabu_helper(houses, 0);
	}
    
    public static int maxMoneyLootedTabu_helper(int[] houses, int stIdx){
        int n = houses.length;
        int[] dp = new int[n+1];
        dp[0] = 0;
        for(int i = 1; i<=n; i++){
            if(i == 1){
                dp[1] = houses[0];
            }
            else{
                dp[i] = Math.max(houses[i-1] + dp[i-2], dp[i-1]);
            }
        }
        return dp[n];
    }
	
	public static void main(String[] args) {

	}

}
