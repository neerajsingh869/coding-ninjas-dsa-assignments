package optionalDynamicProgramming;

public class HighwayRevenue {
	
	// Recursive approach 1 (Time complexity -> O(2^n), Space complexity -> O(n))
	public static int maxRevenue1(int k, int m, int[] position, int[] revenue) {
      return maxRevenue1(k, m, position, revenue, 0);
    }

    private static int maxRevenue1(int k, int m, int[] position, int[] revenue, int i){
      int n = position.length;
      if(i >= n){
        return 0;
      }
      if(position[i] > k){
        return 0;
      }
      int currBillPos = i;
      int nextBillPos = i+1;
      while(nextBillPos < n && position[nextBillPos] - position[currBillPos] <= m){
        nextBillPos++;
      }
      return Math.max(revenue[currBillPos] + maxRevenue1(k, m, position, revenue, nextBillPos), 
     		 maxRevenue1(k, m, position, revenue, currBillPos + 1));
    }
    
    // Memorization approach (Time complexity -> O(n), Space complexity -> O(n))
    public static int maxRevenue2(int k, int m, int[] position, int[] revenue) {
	    int[] dp = new int[position.length];
	    for(int i = 0; i<dp.length; i++){
	      dp[i] = -1;
	    }
	    return maxRevenue2(k, m, position, revenue, 0, dp);
	  }
	
	  private static int maxRevenue2(int k, int m, int[] position, int[] revenue, int i, int[] dp){
	    int n = position.length;
	    if(i >= n){
	      return 0;
	    }
	    if(position[i] > k){
	      return 0;
	    }
	    if(dp[i] != -1){
	      return dp[i];
	    }
	    int currBillPos = i;
	    int nextBillPos = i+1;
	    while(nextBillPos < n && position[nextBillPos] - position[currBillPos] <= m){
	      nextBillPos++;
	    }
	    return dp[i] = Math.max(revenue[currBillPos] + maxRevenue2(k, m, position, revenue, nextBillPos, dp), 
	 		   maxRevenue2(k, m, position, revenue, currBillPos + 1, dp));
	  }
	  
	  // Tabulation approach (Time complexity -> O(k), Space complexity -> O(k)
	  public static int maxRevenue(int k, int m, int[] position, int[] revenue) {
	      int n = position.length;
	      int[] dp = new int[k+1];
	      // dp[i] = max revenue generated till "i" miles
	      int dist = 0;
	      for(int i = 1; i<=k; i++){
	        if(dist < n){
	          if(position[dist] == i){
	            int ans1 = dp[i-1];
	            int ans2 = revenue[dist];
	            if(i-m-1 >= 0){
	              ans2 += dp[i-m-1];
	            }
	            dp[i] = Math.max(ans1, ans2);
	            dist++;
	          }
	          else{
	            dp[i] = dp[i-1];
	          }
	        }
	        else{
	          dp[i] = dp[i-1];
	        }
	      }
	      return dp[k];
	  }

}
