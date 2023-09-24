package dp;

public class MagicGrid {
	
	/*
	 * You are given a magic grid A with R rows and C columns. 
	 * In the cells of the grid, you will either get magic juice, 
	 * which increases your strength by |A[i][j]| points, or poison, 
	 * which takes away |A[i][j]| strength points. If at any point 
	 * of the journey, the strength points become less than or 
	 * equal to zero, then you will die.
	 * 
	 * You have to start from the top-left corner cell (1,1) 
	 * and reach at the bottom-right corner cell (R,C). 
	 * From a cell (i,j), you can only move either one cell down 
	 * or right i.e., to cell (i+1,j) or cell (i,j+1) and 
	 * you can not move outside the magic grid. You have to 
	 * find the minimum number of strength points with which 
	 * you will be able to reach the destination cell.
	 */
	
	public static int getMinimumStrength1(int[][] grid) {
        return getMinimumStrength1(grid, 0, 0);
//        return getMinimumStrength1Dash(grid, 0, 0);
    }

    private static int getMinimumStrength1(int[][] grid, int i, int j){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n || j == m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
//        int ans = Integer.MAX_VALUE;
//        if(i+1 == n){
//            ans = getMinimumStrength1(grid, i, j + 1) - grid[i][j + 1];
//        }
//        else if(j+1 == m){
//            ans = getMinimumStrength1(grid, i + 1, j) - grid[i + 1][j];
//        }
//        else{
//            ans = Math.min(getMinimumStrength1(grid, i + 1, j) - grid[i + 1][j],
//            		getMinimumStrength1(grid, i, j + 1) - grid[i][j + 1]);
//        }
        
        // Better Approach
        int ans = Math.min(getMinimumStrength1(grid, i + 1, j),
        		getMinimumStrength1(grid, i, j + 1)) - grid[i][j];
        return (ans > 0) ? ans : 1;
    }
    
    // Solved Using Memoization
    public static int getMinimumStrength2(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n][m];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                dp[i][j] = -1;
            }
        }
        return getMinimumStrength2(grid, 0, 0, dp);
    }

    private static int getMinimumStrength2(int[][] grid, int i, int j, int[][] dp){
        int n = grid.length;
        int m = grid[0].length;
        if(i == n || j == m){
            return Integer.MAX_VALUE;
        }
        if(i == n-1 && j == m-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
//        int ans = Integer.MAX_VALUE;
//        if(i+1 == n){
//            ans = getMinimumStrength2(grid, i, j + 1, dp) - grid[i][j + 1];
//        }
//        else if(j+1 == m){
//            ans = getMinimumStrength2(grid, i + 1, j, dp) - grid[i + 1][j];
//        }
//        else{
//            ans = Math.min(
//                    getMinimumStrength2(grid, i + 1, j, dp) - grid[i + 1][j],
//                    getMinimumStrength2(grid, i, j + 1, dp) - grid[i][j + 1]);
//        }
        
        // Better Approach
        int ans = Math.min(
                getMinimumStrength2(grid, i + 1, j, dp),
                getMinimumStrength2(grid, i, j + 1, dp)) - grid[i][j];
        return dp[i][j] = (ans > 0) ? ans : 1;
    }
    
    // Solved Using Tabulation
    public static int getMinimumStrength3(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for(int i = n; i>=0; i--){
            for(int j = m; j>=0; j--){
                if(i == n || j == m){
                    dp[i][j] = Integer.MAX_VALUE;
                }
                else if(i == n-1 && j == m-1){
                    dp[i][j] = 1;
                }
                else{
//                    int tempAns = Integer.MAX_VALUE;
//                    if(i+1 == n){
//                        tempAns =  dp[i][j+1] - grid[i][j+1];
//                    }
//                    else if(j+1 == m){
//                        tempAns = dp[i+1][j] - grid[i+1][j];
//                    }
//                    else{
//                        tempAns = Math.min(dp[i][j+1] - grid[i][j+1], 
//                                                       dp[i+1][j] - grid[i+1][j]);
//                    }
                	
                	// Better Approach
                	int tempAns = Math.min(dp[i][j+1], dp[i+1][j]) - grid[i][j];
                    dp[i][j] = (tempAns > 0) ? tempAns : 1;
                }
            }
        }
        return dp[0][0];
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
