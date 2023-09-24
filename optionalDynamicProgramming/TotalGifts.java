package optionalDynamicProgramming;

import java.util.Scanner;

public class TotalGifts {
	
	/*
	 * A man is giving gifts to some kids. The kids are standing in a row on stairs, at different heights. Each kid should receive at least one gift. If two adjacent kids are at different heights, then the kid that is higher should receive one more gift than that is lower down. If two kids are at same height, then their gifts relative to each other doesn't matter. You are given number of kids and the heights of kids in order, then find the minimum number of gifts man has to bring to distribute between those kids.
Input Format:
The first line of input contains the number of kids.
The second line of input contains the heights of kids in order.
Output Format:
The only output line contains the minimum number of gifts that man should bring.
Constraints:
0 ≤ number of kids ≤ 500
0 ≤ heights ≤ 100
Sample Input:
6
2 5 4 7 3 2
Sample Output:
10
Explanation:
The gifts can be distributed among the kids in the following way, 1, 2, 1, 3, 2, 1. The second kid will receive more gifts than the first due to its height being higher. The fourth must receive more than the fifth, which in turn must receive more than the sixth. Thus the total becomes 10.
	 */
	// Brute force approach (Time complexity -> O(n*n), Space complexity -> O(1))
	public static int minGifts1(int[] heights) {
		int n = heights.length;
	    int totalGifts = 0;
	    for(int i = 0 ; i<n; i++){
	      int stepsDownLeft = 0;
	      for(int j = i; j>=1; j--){
	        if(heights[j] <= heights[j-1]){
	          break;
	        }
	        stepsDownLeft++;
	      }
	      int stepsDownRight = 0;
	      for(int j = i; j<n-1; j++){
	        if(heights[j] <= heights[j+1]){
	          break;
	        }
	        stepsDownRight++;
	      }
	      totalGifts += Math.max(stepsDownRight, stepsDownLeft) + 1;
	    }
	    return totalGifts;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int minGifts2(int[] heights) {
		int n = heights.length;
	    int[] gifts = new int[n];
	    // Give min gifts to every kid
	    for(int i = 0; i<n; i++){
	      gifts[i] = 1;
	    }
	    // Give more gift to kid at higher height than prev kid
	    // when going from left to right
	    for(int i = 0; i<n; i++){
	      if(i-1 >= 0 && heights[i] > heights[i-1] && gifts[i] <= gifts[i-1]){
	        gifts[i] = gifts[i-1] + 1;
	      }
	    }
	    // Give more gift to kid at higher height than prev kid
	    // when going from right to left
	    int totalGifts = 0;
	    for(int i = n-1; i>=0; i--){
	      if(i+1 < n && heights[i] > heights[i+1] && gifts[i] <= gifts[i+1]){
	        gifts[i] = gifts[i+1] + 1;
	      }
	      totalGifts += gifts[i];
	    }
	    return totalGifts;
	 }
	
	public static void main(String[] args) {
		   Scanner s = new Scanner(System.in);
		   int n = s.nextInt();
		   int[] heights = new int[n];
		   for(int i = 0; i < n; ++i) heights[i] = s.nextInt();
		   System.out.print(minGifts2(heights));
		   s.close();
	   }

}
