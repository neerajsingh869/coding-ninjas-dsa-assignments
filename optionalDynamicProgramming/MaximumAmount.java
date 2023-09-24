package optionalDynamicProgramming;

import java.util.Scanner;

public class MaximumAmount {
	
	/*
	 * You are given N coins placed in a row with values C1, C2,...,CN. You have to play a game with your friend.
In each turn a player has to select a coin, either the last or the first one from the row and then removes it from the row, and keeps the coin to himself.
You have to find the maximum possible value of coin that you can win if you go first.
Input Format:
The first line of input denotes the number of coins(N) and the second line contains the values of coins.
Output Format:
The only output line prints the maximum amount that you can win.
Constraints:
2<=N<=100
Sample Input:
9 16 4 8
Sample Output:
24(16+8)
	 */
	// Time complexity -> O(2^n), Space complexity -> O(n)
	public static int winAmount1(int[] arr) {
		   return winAmount1(arr, 0, arr.length - 1);
    }

    private static int winAmount1(int[] arr, int st, int end){
        if(st > end){
            return 0;
        }
        int ans1 = arr[st] + Math.min(winAmount1(arr, st+2, end), winAmount1(arr, st+1, end-1));
        int ans2 = arr[end] + Math.min(winAmount1(arr, st+1, end-1), winAmount1(arr, st, end-2));
        return Math.max(ans1, ans2);
    }
    
    // Time complexity -> O(n^2), Space complexity -> O(n^2)
    public static int winAmount2(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
       return winAmount2(arr, 0, arr.length - 1, dp);
    }

    private static int winAmount2(int[] arr, int st, int end, int[][] dp){
        int  n = arr.length;
        if(st > end){
            return 0;
        }
        if(dp[st][end] != -1){
            return dp[st][end];
        }
        int ans1 = arr[st] + Math.min(winAmount2(arr, st+2, end, dp), winAmount2(arr, st+1, end-1, dp));
        int ans2 = arr[end] + Math.min(winAmount2(arr, st+1, end-1, dp), winAmount2(arr, st, end-2, dp));
        return dp[st][end] = Math.max(ans1, ans2);
    }
    
    // Time complexity -> O(n^2), Space complexity -> O(n^2)
    public static int winAmount3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = n-1; i>=0; i--){
            for(int j = i; j<n; j++){
                int x = (i + 2 < n) ? dp[i+2][j] : 0;
                int y = (i+1 < n & j - 1 >= 0) ? dp[i+1][j-1] : 0;
                int z = (j - 2 >= 0) ? dp[i][j-2] : 0;
                int chooseFirst = arr[i] + Math.min(x, y);
                int chooseLast = arr[j] + Math.min(y, z);
                dp[i][j] = Math.max(chooseFirst, chooseLast);
            }
        }
       return dp[0][n-1];
    }
    
    public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = s.nextInt();
		}
		System.out.print(winAmount3(arr));
	}

}
