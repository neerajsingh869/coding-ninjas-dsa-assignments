package optionalDynamicProgramming;

import java.util.Scanner;

public class EarnMaximumCoins {
	
	/*
	 * You are given N balloons indexed from 0 to N-1, with some number painted on each of them represented by an array 'A'. By bursting a balloon i, you will gain some coins. The number of coins gained is equal to A[i-1]* A[i] * A[i+1]. After the burst, balloons i-1 and i+1 becomes adjacent.
Find the maximum coin you can gain by bursting all the balloons wisely.
Note: At each boundary, i.e, A[-1] and A[N]=1
Input Format:
The first line of input contains the total number of balloons.
The second line of input contains the number painted on each each ballon from index 0 to N-1.
Output Format:
The only output line contains the maximum profit earned by bursting all the balloons.
Constraints:
0 ≤ N ≤ 500, 0 ≤A[i] ≤ 100
Sample Input:
5
1 2 3 4 5 
Sample Output:
110
Explanation:
First burst 4, coins=3 * 4 * 5=60

2nd burst 3, coins=2 * 3 * 5=30

3rd burst 2, coins=1 * 2 * 5=10

4th burst 1, coins=1 * 1 * 5=5

At last burst 5, coins=1 * 5 * 1=5

Coins gained=60+30+10+5+5=110
	 */
	
	public static int maxCoins(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int burstI = 0;
            if(i - 1 >= 0 && i + 1 <= n-1){
                burstI = arr[i-1]*arr[i]*arr[i+1];
            }
            else if(i - 1 >= 0){
                burstI = arr[i-1]*arr[i];
            }
            else if(i + 1 <= n-1){
                burstI = arr[i]*arr[i+1];
            }
            else{
                burstI = arr[i];
            }
            int[] tempArr = new int[n-1];
            int k = 0;
            for(int j = 0; j<n; j++){
                if(i != j){
                    tempArr[k++] = arr[j];
                }
            }
            ans = Math.max(ans, burstI + maxCoins(tempArr));
        }
        return ans;
    }
	
	public static int maxCoins2(int[] arr) {
        return maxCoins2(arr, 0, arr.length-1, 1, 1);
    }

    private static int maxCoins2(int[] arr, int i, int j, int leftCusion, int rightCusion){
        if(i > j){
            return 0;
        }
        int maxCoins = 0;
        for(int k = i; k<=j; k++){
            int rightCusion1 = arr[k];
            int leftCusion1 = arr[k];
            int tempAns1 = maxCoins2(arr, i, k-1, leftCusion, rightCusion1);
            int tempAns2 = maxCoins2(arr, k+1, j, leftCusion1, rightCusion);
            maxCoins = Math.max(maxCoins, leftCusion*arr[k]*rightCusion + tempAns1 + tempAns2);
        }
        return maxCoins;
    }
    
    
    // Time complexity -> O(n*n*n), Space complexity -> O(n*n)
    public static int maxCoins3(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = -1;
            }
        }
        return maxCoins3(arr, 0, arr.length-1, 1, 1, dp);
    }

    private static int maxCoins3(int[] arr, int i, int j, int leftCusion, int rightCusion, int[][] dp){
        if(i > j){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int maxCoins = 0;
        for(int k = i; k<=j; k++){
            int rightCusion1 = arr[k];
            int leftCusion1 = arr[k];
            int tempAns1 = maxCoins3(arr, i, k-1, leftCusion, rightCusion1, dp);
            int tempAns2 = maxCoins3(arr, k+1, j, leftCusion1, rightCusion, dp);
            maxCoins = Math.max(maxCoins, leftCusion*arr[k]*rightCusion + tempAns1 + tempAns2);
        }
        return dp[i][j] = maxCoins;
    }
    
    // Time complexity -> O(n*n*n), Space complexity -> O(n*n)
    public static int maxCoins4(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int[][] dp = new int[n][n];
        for(int window = 1; window<=n; window++){
            for(int start = 0; start <= n - window; start++){
                int end = start + window - 1;
                for(int burstLater = start; burstLater <= end; burstLater++){
                    int burstAns = 0;
                    if(start - 1 >= 0 && end + 1 < n){
                        burstAns = arr[start-1]*arr[burstLater]*arr[end+1];
                    }
                    else if(start - 1 >= 0){
                        burstAns = arr[start-1]*arr[burstLater];
                    }
                    else if(end + 1 < n){
                        burstAns = arr[burstLater]*arr[end+1];
                    }
                    else{
                        burstAns = arr[burstLater];
                    }
                    int leftBurstAns = (burstLater - 1 >= 0) ? dp[start][burstLater-1] : 0;
                    int rightBurstAns = (burstLater + 1 < n) ? dp[burstLater+1][end] : 0;
                    dp[start][end] = Math.max(dp[start][end], leftBurstAns + rightBurstAns + burstAns);
                }
            }
        }
        return dp[0][n-1];
    }
    
    // Time complexity -> O(n*n*n), Space complexity -> O(n*n)
    public static int maxCoins5(int[] arr) {
        int n = arr.length;
        if(n == 0){
            return 0;
        }
        int balloons[] = new int[n+2];
        balloons[0] = 1;
        balloons[n+1] = 1;
        for(int i = 0; i<n; i++){
            balloons[i+1] = arr[i];
        }
        int[][] dp = new int[n+2][n+2];
        for(int window = 1; window<=n; window++){
            for(int start = 1; start <= n - window + 1; start++){
                int end = start + window - 1;
                for(int burstLater = start; burstLater <= end; burstLater++){
                    dp[start][end] = Math.max(dp[start][end], 
                    		dp[start][burstLater-1] + dp[burstLater+1][end] + 
                    		balloons[start-1]*balloons[burstLater]*balloons[end+1]);
                }
            }
        }
        return dp[1][n];
    }
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i < n; ++i) {
			arr[i] = s.nextInt();
		}
		System.out.print(maxCoins2(arr));
	}

}
