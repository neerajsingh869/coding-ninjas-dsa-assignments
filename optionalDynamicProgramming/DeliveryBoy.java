package optionalDynamicProgramming;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class DeliveryBoy {
	
	/*
	 * A and B are two delivery boys on a pizza shop. The pizza shop received a total of N orders. The tip amount can be different when handled by a different delivery man. That is, if A takes ith order he gets a tip of Ai rupees, and if B takes ith order he gets a tip of Bi rupees.
One delivery boy can handle one order at a time. A can't handle more than X orders and B can't handle more than Y orders.
A and B have to distribute the orders among themselves such the total tip money is maximised. Find that maximum possible tip amount after delivering all the orders.
Input Format:
The first line of input contains 3 integers N, X and Y.
The second line of input contains tip amounts of A for N orders separated by space.
The last line of input contains tip amounts of B for N orders separated by space.
Output Format:
 The only line of output contains the maximum tip money they would receive.
Constraints:
1 ≤ N ≤ 10 5
1 ≤ X, Y ≤ N; X + Y ≥ N
1 ≤ Ai, Bi ≤ 104
Sample Input:
5 4 4 
9 7 6 5 3
5 6 7 8 9
Sample Output:
40
	 */
	// Worst approach (Time complexity -> O(2^n), Space complexity -> O(n))
	public static long maxTip1(int[] aTips, int[] bTips, int x, int y) {
		return maxTip1(aTips, bTips, x, y, 0);
	}

	private static long maxTip1(int[] aTips, int[] bTips, int x, int y, int i){
		int n = aTips.length;
		if(i >= n){
		  return 0;
		}
		if(x == 0 && y == 0){
		  return 0;
		}
		else if(x == 0){
		  return bTips[i] + maxTip1(aTips, bTips, x, y-1, i+1);
		}
		else if(y == 0){
		  return aTips[i] + maxTip1(aTips, bTips, x-1, y, i+1);
		}
		else{
		  return Math.max(bTips[i] + maxTip1(aTips, bTips, x, y-1, i+1), 
		                            aTips[i] + maxTip1(aTips, bTips, x-1, y, i+1));
		}
	}
	
	// Better approach (Time complexity -> O(n*x*y), Space complexity -> O(n*x*y))
	public static long maxTip2(int[] aTips, int[] bTips, int x, int y) {
      int n = aTips.length;
      long[][][] dp = new long[n][x+1][y+1];
      for(int i = 0; i<n; i++){
        for(int j = 0; j<=x; j++){
          for(int k = 0; k<=y; k++){
            dp[i][j][k] =-1;
          }
        }
      }
      return maxTip2(aTips, bTips, x, y, 0, dp);
    }

    private static long maxTip2(int[] aTips, int[] bTips, int x, int y, int i, long[][][] dp){
      int n = aTips.length;
      if(i >= n){
        return 0;
      }
      if(dp[i][x][y] != -1){
        return dp[i][x][y];
      }
      long ans = 0;
      if(x == 0 && y == 0){
        ans = 0;
      }
      else if(x == 0){
        ans = bTips[i] + maxTip2(aTips, bTips, x, y-1, i+1, dp);
      }
      else if(y == 0){
        ans = aTips[i] + maxTip2(aTips, bTips, x-1, y, i+1, dp);
      }
      else{
        ans = Math.max(bTips[i] + maxTip2(aTips, bTips, x, y-1, i+1, dp), 
                                  aTips[i] + maxTip2(aTips, bTips, x-1, y, i+1, dp));
      }
      return dp[i][x][y] = ans;
    }
    
    // Best approach (Time complexity -> O(n*(log(n))), Space complexity -> O(n))
    public static long maxTip3(int[] aTips, int[] bTips, int x, int y) {
		  int n = aTips.length;
    // If only A delivers orders irrespective of its capacity
    int tipSum = 0;
    for(int i = 0; i<n; i++){
      tipSum += aTips[i];
    }
    // Now, we will consider B. First find which order gives more tip
    // to B as compared to A
    Integer bDiffTip[] = new Integer[n];
    for(int i = 0; i<n; i++){
      bDiffTip[i] = bTips[i] - aTips[i];
    }
    // Now, arrange those orders in descending order
    Arrays.sort(bDiffTip, Collections.reverseOrder());
    // Remove those orders from tipSum for which B Tip is more
    int maxTip = 0;
    for(int i = 0; i<y && i<n; i++){
      tipSum += bDiffTip[i];
      // If A orders reduces from x (max orders of A), then 
      // keep on updating maxTip so that we can know which 
      // one when ordered generates maximum tip
      if(n - (i+1) <= x){
        maxTip = Math.max(maxTip, tipSum);
      }
    }
    return maxTip;
  }
    
    public static void main(String[] args) {
 	   Scanner s = new Scanner(System.in);
 	   int n = s.nextInt();
 	   int x = s.nextInt();
 	   int y = s.nextInt();
 	   int[] aTips = new int[n];
 	   int[] bTips = new int[n];
 	   for(int i = 0; i < n; ++i) aTips[i] = s.nextInt();
 	   for(int i = 0; i < n; ++i) bTips[i] = s.nextInt();
 	   System.out.print(maxTip3(aTips, bTips, x, y));
 	   s.close();
    }

}
