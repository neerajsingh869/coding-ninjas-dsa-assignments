package backtracking;

public class PrintAllPathRatInMaze {
	
	/*
	 * You are given a N*N maze with a rat placed at maze[0][0]. 
	 * Find and print all paths that rat can follow to reach its 
	 * destination i.e. maze[N-1][N-1]. Rat can move in any direc­tion 
	 * ( left, right, up and down).
	 * 
	 * Value of every cell in the maze can either be 0 or 1. 
	 * Cells with value 0 are blocked means rat can­not enter into 
	 * those cells and those with value 1 are open.
	 */

	public static void ratInAMaze_helper(int maze[][], int i, int j, int path[][], int n){
        // Check whether i and j are valid or not
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
        	return;
        }
        // Mark the cell from where we are going to explore
        path[i][j] = 1;
        // Check whether we reached destination or not
        if(i == n-1 && j == n-1){
        	for(int k = 0; k<n; k++){
        		for(int l = 0; l<n; l++){
        			System.out.print(path[k][l] + " ");
        		}
        	}
        	System.out.println();
            path[i][j] = 0;
        	return;
        }
        ratInAMaze_helper(maze, i, j+1, path, n);
        ratInAMaze_helper(maze, i+1, j, path, n);
        ratInAMaze_helper(maze, i, j-1, path, n);
        ratInAMaze_helper(maze, i-1, j, path, n);
        path[i][j] = 0;
	}    
    
	public static void ratInAMaze(int maze[][], int n) {
        int path[][] = new int[n][n];
        ratInAMaze_helper(maze, 0, 0, path, n);
	}
	
	public static void main(String[] args) {
		int maze[][] = {{1, 1, 0}, {0, 1, 1}, {0, 1, 1}};
		ratInAMaze(maze, 3);
	}
	
}
