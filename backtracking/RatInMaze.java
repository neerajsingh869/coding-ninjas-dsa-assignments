package backtracking;

public class RatInMaze {
	
	/*
	 * You are given a N*N maze with a rat placed at maze[0][0]. 
	 * Find whether any path exist that rat can follow to reach 
	 * its destination i.e. maze[N-1][N-1]. Rat can move in any 
	 * direc­tion ( left, right, up and down).
	 * 
	 * Value of every cell in the maze can either be 0 or 1. 
	 * Cells with value 0 are blocked means rat can­not enter into 
	 * those cells and those with value 1 are open.
	 */
	

	public static boolean ratInAMaze(int maze[][]){
        int n = maze.length;
        int path[][] = new int[n][n];
        return ratInAMaze_helper(maze, 0, 0, path);
	}
	
	public static boolean ratInAMaze_helper(int maze[][], int i, int j, int path[][]){
        // Base case
        int n = maze.length;
        // Check whether i and j are valid or not
        if(i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1){
            return false;
        }
        // Mark the cell from where we are going to explore
        path[i][j] = 1;
        // Check whether we reached destination or not
        if(i == n-1 && j == n-1){
        	path[i][j] = 0;
            return true;
        }
        boolean ans = (ratInAMaze_helper(maze, i, j+1, path) || ratInAMaze_helper(maze, i+1, j, path) ||
        		ratInAMaze_helper(maze, i, j-1, path) || ratInAMaze_helper(maze, i-1, j, path));
        path[i][j] = 0;
        return ans;
    }	
	
	public static void main(String[] args) {
		int maze[][] = {{1, 1, 0}, {0, 1, 1}, {0, 1, 1}};
		System.out.println(ratInAMaze(maze));
	}
	
}
