package dp;

public class MaxSquareWithAllZeros {
	
	/*
	 * Given an NxM matrix that contains only 0s and 1s, 
	 * find out the size of the maximum square sub-matrix 
	 * with all 0s. You need to return the size of the 
	 * square matrix with all 0s.
	 */
	
	// Time Complexity -> O(3^(n*m), Space Complexity -> O(n*m)
	public static int findMaxSquareWithAllZeros1(int[][] input){
		int n = input.length;
		if(n == 0){
			return 0;
		}
		int m = input[0].length;
		int[][] halfAns = new int[n][m];
		findMaxSquareWithAllZerosEndingNM(input, n, m, halfAns);
		int fullAns = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				fullAns = Math.max(fullAns, halfAns[i][j]);
			}
		}
		return fullAns;
	}

	private static int findMaxSquareWithAllZerosEndingNM(int[][] input, int n, int m, int[][] halfAns){
		if(n == 0 || m == 0){
			return 0;
		}
		if(input[n-1][m-1] != 0){
			halfAns[n-1][m-1] = 0;
		}
		else{
			int tempAns1 = findMaxSquareWithAllZerosEndingNM(input, n-1, m, halfAns);
			int tempAns2 = findMaxSquareWithAllZerosEndingNM(input, n-1, m-1, halfAns);
			int tempAns3 = findMaxSquareWithAllZerosEndingNM(input, n, m-1, halfAns);
			halfAns[n-1][m-1] = 1 + Math.min(tempAns1, Math.min(tempAns2, tempAns3));
		}
		return halfAns[n-1][m-1];
	}

	// Time Complexity -> O(n*m), Space Complexity -> O(n*m)
	public static int findMaxSquareWithAllZeros2(int[][] input){
		int n = input.length;
		if(n == 0){
			return 0;
		}
		int m = input[0].length;
		int[][] dp = new int[n][m];
		// dp[i][j] = Max square length with all 0s ending at i & j index
		int ans = 0;
		for(int i = 0; i<n; i++){
			dp[i][0] = (input[i][0] == 0)  ? 1 : 0;
			ans = Math.max(ans, dp[i][0]);
		}
		for(int j = 0; j<m; j++){
			dp[0][j] = (input[0][j] == 0) ? 1 : 0;
			ans = Math.max(ans, dp[0][j]);
		}
		for(int i = 1; i<n; i++){
			for(int j = 1; j<m; j++){
				if(input[i][j] == 0){
					dp[i][j] = 1 + Math.min(dp[i-1][j-1], Math.min(dp[i-1][j], dp[i][j-1]));
				}
				else{
					dp[i][j] = 0;
				}
				ans = Math.max(ans, dp[i][j]);
			}
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
