package dp;

public class LCS {
	
	/*
	 * Given two strings, 'S' and 'T' with lengths 'M' and 'N', 
	 * find the length of the 'Longest Common Subsequence'.
	 * For a string 'str'(per se) of length K, the subsequences 
	 * are the strings containing characters in the same relative 
	 * order as they are present in 'str,' but not necessarily contiguous. 
	 * Subsequences contain all the strings of length varying from 0 to K.
	 */
	// Solving Using Recursion
	public static int lcs(String s, String t) {
		int m = s.length(), n = t.length();
        if(m == 0 || n == 0){
            return 0;
        }
        
        int ans;
        if(s.charAt(0) == t.charAt(0)){
            ans = 1 + lcs(s.substring(1), t.substring(1));
        }
        else{
            ans = Math.max(lcs(s, t.substring(1)), lcs(s.substring(1), t));
        }
        return ans;
    }
	
	// Solving Using Memoization
	public static int lcsMemo(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        return lcsMemo_helper(s, t, dp);
    }

	public static int lcsMemo_helper(String s, String t, int[][] dp) {
		int m = s.length(), n = t.length();
        if(m == 0 || n == 0){
            return 0;
        }
        
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        
        int ans;
        if(s.charAt(0) == t.charAt(0)){
            ans = 1 + lcsMemo_helper(s.substring(1), t.substring(1), dp);
        }
        else{
            ans = Math.max(lcsMemo_helper(s, t.substring(1), dp), lcsMemo_helper(s.substring(1), t, dp));
        }
        return dp[m][n] = ans;
    }
	
	// Solving Using Tabulation
	public static int lcsTabu1(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] = lcs in string s with length i and 
        // string t with length j from the beginning
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0 || j == 0){
                    dp[i][j] = 0;
                }
                else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
						dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                    }
                }
            }
        }
        return dp[m][n];
    }
	
	public static int lcsTabu2(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] = lcs in string s with length i and 
        // string t with length j from the beginning
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
            	if(s.charAt(i-1) == t.charAt(j-1)){
					dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
	
	public static int lcsTabu3(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        // dp[i][j] = lcs in string s with length i and 
        // string t with length j from the end
        for(int i = 1; i<=m; i++){
            for(int j = 1; j<=n; j++){
            	if(s.charAt(m-i) == t.charAt(n-j)){
					dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
