package dp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MinCostPathSum {
	
	/*
	 * An integer matrix of size (M x N) has been given. 
	 * Find out the minimum cost to reach from the cell 
	 * (0, 0) to (M - 1, N - 1).
	 * From a cell (i, j), you can move in three directions:
	 * 		1. ((i + 1),  j) which is, "down"
	 * 		2. (i, (j + 1)) which is, "to the right"
	 * 		3. ((i+1), (j+1)) which is, "to the diagonal"
	 * The cost of a path is defined as the sum of each cell's 
	 * values through which the route passes.
	 */
	// Solving Using Recursion
	public static int minCostPath(int[][] input) {
        int m = input.length;
        if(m == 0){
            return Integer.MAX_VALUE;
        }
        return minCostPath_helper(input, 0, 0);
	}
    
    public static int minCostPath_helper(int[][] input, int i, int j){
        int m = input.length;
        int n = input[0].length;
        // Base cases
        if(i < 0 || i > m-1 || j < 0 || j > n-1){
            return Integer.MAX_VALUE;
        }
        if(i == m-1 && j == n-1){
            return input[i][j];
        }
        
        int costRight = minCostPath_helper(input, i, j+1);
        int costDown = minCostPath_helper(input, i+1, j);
        int costDiagonal = minCostPath_helper(input, i+1, j+1);
        
        return input[i][j] + Math.min(costDiagonal, Math.min(costDown, costRight));
    }
    
    // Solving Using Memoization
    public static int minCostPathMemoi(int[][] input) {
        int m = input.length;
        if(m == 0){
            return Integer.MAX_VALUE;
        }
        int n = input[0].length;
        int[][] dp = new int[m][n];
        for(int i = 0; i<m; i++){
            for(int j = 0; j<n; j++){
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        return minCostPathMemoi_helper(input, 0, 0, dp);
	}
    
    public static int minCostPathMemoi_helper(int[][] input, int i, int j, int[][] dp){
        int m = input.length;
        int n = input[0].length;
        // Edge cases
        if(i < 0 || i > m-1 || j < 0 || j > n-1){
            return Integer.MAX_VALUE;
        }
        // Base cases
        if(i == m-1 && j == n-1){
            return input[i][j];
        }
        if(dp[i][j] != Integer.MIN_VALUE){
            return dp[i][j];
        }
        int costRight = minCostPathMemoi_helper(input, i, j+1, dp);
        int costDown = minCostPathMemoi_helper(input, i+1, j, dp);
        int costDiagonal = minCostPathMemoi_helper(input, i+1, j+1, dp);
        
        return dp[i][j] = input[i][j] + Math.min(costDiagonal, Math.min(costDown, costRight));
    }
    
    // Solving Using Tabulation
    
    public static int minCostPathTabu1(int[][] input) {
		int m = input.length;
		int n = input[0].length;
		int[][] dp = new int[m+1][n+1];
		for(int i = 0; i<=m; i++){
			dp[i][n] = Integer.MAX_VALUE;
		}
		for(int j = 0; j<=n; j++){
			dp[m][j] = Integer.MAX_VALUE;
		}
		for(int i = m-1; i>=0; i--){
			for(int j = n-1; j>=0; j--){
				if(i == m-1 && j == n-1){
					dp[i][j] = input[i][j];
				}
				else{
					dp[i][j] = input[i][j] + Math.min(dp[i + 1][j], 
												Math.min(dp[i][j + 1], dp[i + 1][j + 1]));
				}
				
			}
		}
		return dp[0][0];
	}
    
    public static int minCostPathTabu2(int[][] input) {
        int m = input.length;
        if(m == 0){
            return Integer.MAX_VALUE;
        }
        int n = input[0].length;
        int[][] dp = new int[m+1][n+1];
        for(int i = m; i>=0; i--){
            for(int j = n; j>=0; j--){
            	if(i == m-1 && j == n-1) {
            		dp[i][j] = input[i][j];
            		continue;
            	}
                if(i == m){
                    dp[m][j] = Integer.MAX_VALUE;
                }
                else if(j == n){
                    dp[i][n] = Integer.MAX_VALUE;
                }
                else{
                   	dp[i][j] = input[i][j] + Math.min(dp[i+1][j+1], Math.min(dp[i+1][j], dp[i][j+1])); 
                }
                
            }
        }
        return dp[0][0];
	}
    
    public static int minCostPathTabu3(int[][] input) {
		int m = input.length;
		if (m == 0) {
			return Integer.MAX_VALUE;
		}
		int n = input[0].length;
		
		int[][] dp = new int[m + 1][n + 1];
		// dp[i][j] -> min cost path to reach from cell (0, 0) to (i - 1, j - 1)
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = Integer.MAX_VALUE;
				} else {
					int ansToLeft = dp[i][j - 1];
					int ansToUp = dp[i - 1][j];
					int ansToDiag = dp[i - 1][j - 1];

					int minTempCost = Math.min(ansToDiag, Math.min(ansToLeft, ansToUp));
					if (minTempCost == Integer.MAX_VALUE) {
						dp[i][j] = input[i - 1][j - 1];
					} else {
						dp[i][j] = input[i - 1][j - 1] + minTempCost;
					}
				}
			}
		}
		
		// dp[m][n] -> min cost path to reach from cell (0, 0) to (m - 1, n - 1)
		return dp[m][n];
	}

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int mRows = Integer.parseInt(strRowsCols[0]);
        int nCols = Integer.parseInt(strRowsCols[1]);

        if (mRows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[mRows][nCols];

        for (int row = 0; row < mRows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < nCols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int[][] mat = take2DInput();
        System.out.println(minCostPathTabu3(mat));
    }
}
