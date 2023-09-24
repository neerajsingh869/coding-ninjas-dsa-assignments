package dp;

public class EditDistance {
	
	/*
	 * You are given two strings S and T of lengths M and N, respectively. 
	 * Find the 'Edit Distance' between the strings.
	 * Edit Distance of two strings is the minimum number of steps required 
	 * to make one string equal to the other. In order to do so, you can perform 
	 * the following three operations:
	 * 				1. Delete a character
 	 * 				2. Replace a character with another one
	 * 				3. Insert a character
	 */
	// Solving using Recursion
	public static int editDistance1(String s, String t) {
		int m = s.length(), n = t.length();
        if(s == t){
            return 0;
        }
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        int ans = 0;
        if(s.charAt(0) == t.charAt(0)){
            ans = editDistance1(s.substring(1), t.substring(1));
        }
        else{
            int ansDel = 0, ansRep = 0, ansIns = 0;
            // Deleting a character
            ansDel = editDistance1(s.substring(1), t);
            // Replacing a character
            ansRep = editDistance1(s.substring(1), t.substring(1));
            // Inserting a character
            ansIns = editDistance1(s, t.substring(1));
            ans = 1 + Math.min(ansDel, Math.min(ansRep, ansIns));
        }
        return ans;
    }
	
	public static int editDistance2(String s, String t) {
		return editDistance2_helper(s, t, 0, 0);
    }
    
    public static int editDistance2_helper(String s, String t, int sIdx, int tIdx){
        int m = s.length(), n = t.length();
        if(m == sIdx){
            return n-tIdx;
        }
        if(n == tIdx){
            return m-sIdx;
        }
        int ans = 0;
        if(s.charAt(sIdx) == t.charAt(tIdx)){
            ans = editDistance2_helper(s, t, sIdx+1, tIdx+1);
        }
        else{
            int ansDel = 0, ansRep = 0, ansIns = 0;
            // Deleting a character
            ansDel = editDistance2_helper(s, t, sIdx+1, tIdx);
            // Replacing a character
            ansRep = editDistance2_helper(s, t, sIdx+1, tIdx+1);
            // Inserting a character
            ansIns = editDistance2_helper(s, t, sIdx, tIdx+1);
            ans = 1 + Math.min(ansDel, Math.min(ansRep, ansIns));
        }
        return ans;
    }
    
    // Solving using Memoization
    public static int editDistanceMemoi(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                dp[i][j] = -1;
            }
        }
        return editDistanceMemoi_helper(s, t, dp);
    }

	public static int editDistanceMemoi_helper(String s, String t, int[][] dp) {
		int m = s.length(), n = t.length();
        if(s == t){
            return 0;
        }
        if(m == 0){
            return n;
        }
        if(n == 0){
            return m;
        }
        if(dp[m][n] != -1){
            return dp[m][n];
        }
        int ans = 0;
        if(s.charAt(0) == t.charAt(0)){
            ans = editDistanceMemoi_helper(s.substring(1), t.substring(1), dp);
        }
        else{
            int ansDel = 0, ansRep = 0, ansIns = 0;
            // Deleting a character
            ansDel = editDistanceMemoi_helper(s.substring(1), t, dp);
            // Replacing a character
            ansRep = editDistanceMemoi_helper(s.substring(1), t.substring(1), dp);
            // Inserting a character
            ansIns = editDistanceMemoi_helper(s, t.substring(1), dp);
            ans = 1 + Math.min(ansDel, Math.min(ansRep, ansIns));
        }
        return dp[m][n] = ans;
    }
	
	// Solving using Tabulation
	public static int editDistanceTabu(String s, String t){
        int m = s.length(), n = t.length();
        int[][] dp = new int[m+1][n+1];
        for(int i = 0; i<=m; i++){
            for(int j = 0; j<=n; j++){
                if(i == 0){
                    dp[i][j] = j;
                }
                else if(j == 0){
                    dp[i][j] = i;
                }
                else{
                    if(s.charAt(i-1) == t.charAt(j-1)){
                        dp[i][j] = dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = 1 + Math.min(dp[i-1][j], Math.min(dp[i-1][j-1], dp[i][j-1]));
                    }
                }
            }
        }
        return dp[m][n];
    }

	public static void main(String[] args) {
		
	}

}
