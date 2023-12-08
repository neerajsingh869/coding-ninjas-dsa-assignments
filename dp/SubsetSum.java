package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {
	
	/*
	 * You are given a set of N integers. You have to return 
	 * true if there exists a subset that sum up to K, otherwise return false.
	 */
	
	// Solving Using Recursion
	public static boolean isSubsetPresent(int[] arr, int n, int sum) {
        if(sum == 0){
            return true;
        }
		if(n == 0){
            return false;
        }
        if(arr[n-1] <= sum){
            return isSubsetPresent(arr, n-1, sum-arr[n-1]) || isSubsetPresent(arr, n-1, sum);
        }
        else{
            return isSubsetPresent(arr, n-1, sum);
        }
    }
	
	// Solving using Tabulation
	public static boolean isSubsetPresentTabu(int[] arr, int n, int sum) {
        boolean[][] dp = new boolean[n+1][sum+1];
        for(int i = 0; i<=n; i++){
            dp[i][0] = true;
        }
        for(int j = 1; j<=sum; j++){
            dp[0][j] = false;
        }
        for(int i = 1; i<=n; i++){
            for(int j = 1; j<=sum; j++){
                if(arr[i-1] <= j){
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-arr[i-1]];
                }
                else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][sum];
    }

static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static void main(String[] args) throws NumberFormatException, IOException {
        int size = Integer.parseInt(br.readLine().trim());
        int[] input = new int[size];

        if (size == 0) {
            System.out.print("No");
            return;
        }
        
		String[] strNums;
		strNums = br.readLine().split("\\s");
		
        for (int i = 0; i < size; ++i) {
            input[i] = Integer.parseInt(strNums[i]);
        }

        int sum = Integer.parseInt(br.readLine().trim());
        if (isSubsetPresent(input,size,sum)){
            System.out.print("Yes");
        }
        else{
            System.out.print("No");
        }


    }

}
