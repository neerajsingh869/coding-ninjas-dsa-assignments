package optionalDynamicProgramming;

import java.util.Scanner;

public class MaximizeCut {
	
	/*
	 * You are given a line segment of length L. You have to cut this line segment in such a manner that the total number of segments of length a, b, c are maximised.
Note: The segments can only be of length a, b and c.
Input Format:
The first line of input contains L(length of the line segment).
The second line of input contains 3 space separated integers a, b and c.
Output Format:
The only integer in the output contains the maximum number of segments of length a, b or c. If a certain length is not possible then print -1.
Constraints:
1<=N, a, b, c<=4000
Sample Input:
13
2 5 6
Sample Output:
5
	 */
	
	// Time Complexity -> O(3^L), Space Complexity -> O(L)
	public static int maxSegments1(int L, int a, int b, int c) {
        int ans = maxSegmentsHelper1(L, a, b, c);
        if(ans == Integer.MIN_VALUE){
            return -1;
        }
        return ans;
    }

    private static int maxSegmentsHelper1(int L, int a, int b, int c){
        if(L == 0){
            return 0;
        }
        if(L < 0){
            return Integer.MIN_VALUE;
        }
        int choiceA = maxSegmentsHelper1(L-a, a, b, c);
        int choiceB = maxSegmentsHelper1(L-b, a, b, c);
        int choiceC = maxSegmentsHelper1(L-c, a, b, c);
        if(choiceA == Integer.MIN_VALUE && choiceB == Integer.MIN_VALUE && choiceC == Integer.MIN_VALUE){
            return Integer.MIN_VALUE;
        }
        else{
            return 1 + Math.max(choiceA, Math.max(choiceB, choiceC));
        }
    }
    
    // Time Complexity -> O(L), Space Complexity -> O(L)
    public static int maxSegments2(int L, int a, int b, int c) {
        int[] dp = new int[L+1];
        for(int i = 0; i<=L; i++){
            dp[i] = -1;
        }
        int ans = maxSegmentsHelper2(L, a, b, c, dp);
        if(ans == Integer.MIN_VALUE){
            return -1;
        }
        return ans;
    }

    private static int maxSegmentsHelper2(int L, int a, int b, int c, int[] dp){
        if(L == 0){
            return 0;
        }
        if(L < 0){
            return Integer.MIN_VALUE;
        }
        if(dp[L] != -1){
            return dp[L];
        }
        int choiceA = maxSegmentsHelper2(L-a, a, b, c, dp);
        int choiceB = maxSegmentsHelper2(L-b, a, b, c, dp);
        int choiceC = maxSegmentsHelper2(L-c, a, b, c, dp);
        if(choiceA == Integer.MIN_VALUE && choiceB == Integer.MIN_VALUE && choiceC == Integer.MIN_VALUE){
            return dp[L] = Integer.MIN_VALUE;
        }
        else{
            return dp[L] = 1 + Math.max(choiceA, Math.max(choiceB, choiceC));
        }
    }
    
    // Time Complexity -> O(L), Space Complexity -> O(L)
    public static int maxSegments3(int L, int a, int b, int c) {
        int[] dp = new int[L+1];
        dp[0] = 0;
        for(int i = 1; i<=L; i++){
            int tempAns = Integer.MIN_VALUE;
            if(i-a >= 0 && dp[i-a] != Integer.MIN_VALUE){
                tempAns = Math.max(tempAns, dp[i-a]);
            }
            if(i-b >= 0 && dp[i-b] != Integer.MIN_VALUE){
                tempAns = Math.max(tempAns, dp[i-b]);
            }
            if(i-c >= 0 && dp[i-c] != Integer.MIN_VALUE){
                tempAns = Math.max(tempAns, dp[i-c]);
            }
            if(tempAns != Integer.MIN_VALUE){
                dp[i] = 1 + tempAns;
            }
            else{
                dp[i] = tempAns;
            }
        }
        return (dp[L] == Integer.MIN_VALUE) ? -1 : dp[L];
    } 
    
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int L = s.nextInt();
		int a = s.nextInt();
		int b = s.nextInt();
		int c = s.nextInt();
		System.out.print(maxSegments3(L, a, b, c));
	}

}
