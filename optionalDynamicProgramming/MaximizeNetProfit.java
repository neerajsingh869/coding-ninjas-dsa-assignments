package optionalDynamicProgramming;

public class MaximizeNetProfit {
	
	/*
	 * A water park has a long line of n customers with different profits from their tickets(P[i]) to the water park authorities. The authorities chooses the customers to enter the water park in 2 phases:
Phase 1: The authorities chooses 2 indices i and j and let the customers i, i+1,....,j to enter the water park. The authorities find the sum of profits in this range i.e. P[i]+P[i+1]+....+P[j].
Phase 2: The authorities chooses 2 more indices k and l and let the customers k, k+1,....,l to enter the water park. The authorities find the sum of profits in this range i.e. P[k]+P[k+1]+....+P[l].
But the net profit to the water park authorities is determined by the absolute difference between the profits obtained in the two phases. Our task is to maximise the net profit from the customers.
Input Format:
The first line of input denotes the total number of customers(n).
The second line of input denotes the profits from the tickets(P[i]) of the n customers separated by space.
Output Format:
Maximum profit that the water park authorities can get.
Constraints:
2<=n<=10000
1 ≤ i ≤ j < k ≤ l ≤ n
−10 9 ≤ P[i] ≤ 109
Sample Input:
5
2 3 4 5 6
Sample Output:
16
	 */
	
	public static long maxProfit(long[] ticketProfit) {
      int n = ticketProfit.length;
      long ans = 0;
      for(int i = 0; i<n-1; i++){
        long minLeft = minProfitSum(ticketProfit, 0, i);
        long minRight = minProfitSum(ticketProfit, i+1, n-1);
        long maxLeft = maxProfitSum(ticketProfit, 0, i);
        long maxRight = maxProfitSum(ticketProfit, i+1, n-1);
        ans = Math.max(ans, Math.max(Math.abs(maxRight - minLeft), Math.abs(maxLeft - minRight)));
      }
      return ans;
    }

    private static long minProfitSum(long[] ticketProfit, int i, int j){
      long ans = ticketProfit[i];
      for(int k = i; k<=j; k++){
        ans = Math.min(ans, ticketProfit[k]);
      }
      return ans;
    }

    private static long maxProfitSum(long[] ticketProfit, int i, int j){
      long ans = 0;
      for(int k = i; k<=j; k++){
        ans += ticketProfit[k];
      }
      return ans;
    }

}
