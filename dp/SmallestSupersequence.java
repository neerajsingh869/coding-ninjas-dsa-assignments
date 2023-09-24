package dp;

public class SmallestSupersequence {
	
	/*
	 * Given two strings S and T with lengths M and N. 
	 * Find and return the length of their shortest 'Super Sequence'.
	 * 
 	 * The shortest 'Super Sequence' of two strings is defined 
 	 * as the smallest string possible that will have both the 
 	 * given strings as its subsequences.
	 */

	// Solving using Recursion
	public static int smallestSuperSequence(String str1, String str2) {
        int n = str1.length(), m = str2.length();
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        int ans;
        if(str1.charAt(0) == str2.charAt(0)){
            ans = 1 + smallestSuperSequence(str1.substring(1), str2.substring(1));
        }
        else{
            ans = 1 + Math.min(smallestSuperSequence(str1.substring(1), str2), 
            		smallestSuperSequence(str1, str2.substring(1)));
        }
        return ans;
    	
    }
	
	// Solving using Memoization
	public static int smallestSuperSequenceMemo(String str1, String str2){
        int n = str1.length(), m = str2.length();
        int[][] dp = new int[n+1][m+1];
        // Don't need to put -1 in dp 2d array as answer can 
        // never be 0. If answer is 0, then that will be
        // automatically handled by base cases
        return smallestSuperSequenceMemo_helper(str1, str2, dp);
    }

	public static int smallestSuperSequenceMemo_helper(String str1, String str2, int[][] dp) {
        int n = str1.length(), m = str2.length();
        if(n == 0){
            return m;
        }
        if(m == 0){
            return n;
        }
        if(dp[n][m] != 0){
            return dp[n][m];
        }
        int ans;
        if(str1.charAt(0) == str2.charAt(0)){
            ans = 1 + smallestSuperSequenceMemo_helper(str1.substring(1), str2.substring(1), dp);
        }
        else{
            ans = 1 + Math.min(smallestSuperSequenceMemo_helper(str1.substring(1), str2, dp), 
            		smallestSuperSequenceMemo_helper(str1, str2.substring(1), dp));
        }
        return dp[n][m] = ans;	
    }
	
	// Solving Using Tabulation
	public static int smallestSuperSequenceTabu(String str1, String str2){
		int n = str1.length();
		int m = str2.length();
		int[][] dp = new int[n+1][m+1];
		for(int i = 0; i<=n; i++){
			for(int j = 0; j<=m; j++){
				if(i == 0){
					dp[i][j] = j;
				}
				else if(j == 0){
					dp[i][j] = i;
				}
				else if(str1.charAt(i-1) == str2.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
				}
				else{
					dp[i][j] = 1 + Math.min(dp[i][j-1], dp[i-1][j]);
				}
			}
		}
		return dp[n][m];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
