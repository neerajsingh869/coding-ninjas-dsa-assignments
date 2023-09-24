package optionalDynamicProgramming;

import java.util.Scanner;

class Pair {
  boolean isSouthVis;
  boolean isEastVis;
  Pair(boolean isSouthVis, boolean isEastVis){
    this.isSouthVis = isSouthVis;
    this.isEastVis = isEastVis;
  }
}

public class PlaceTheMirror {
	
	/*
	 * You are given a N x N grid, in which some cells are empty(denoted by '0') while some cells have rock in it(denoted by '1'). You are standing at the south side of the grid and you have to watch on the east side. You can place a mirror at 45 degrees on an empty cell in the grid, so that you could see on the east side of the grid.
But, if you found a rock in the line of sight, you won't be able to see anything on the east side.
You. have to tell how many possible cells are there in which you can place a mirror to watch on the east side.
Input Format:
The first line of input contains the size of the grid.
Next N lines contains N characters in each line (either '0' or '1' to denote empty or rock in a cell)
Output Format:
The output contains an integer denoting the number of possible options where mirror can be placed to see on the East side.
Constraints:
1<=N<=1000
Sample Input:
4
1 0 1 1
0 1 0 0
0 0 0 0
0 1 1 0
Sample Output:
4
	 */
	// Brute force approach (Time complexity -> O(n*n*n),
	// Space complexity -> O(1))
	 public static int numCells1(int[][] grid) {
		 int n = grid.length;
		 if(n == 0) return 0;
		 int count = 0;
		 for(int i = 0; i<n; i++){
		   for(int j = 0; j<n; j++){
			 // Place where mirror can be placed
		     if(grid[i][j] == 0){
		       boolean canManSeeEast = true;
		       // To check whether men can see mirror or not
		       for(int k = j; k<n; k++){
		         if(grid[i][k] == 1){
		           canManSeeEast = false;
		           break;
		         }
		       }
		       // To check whether mirror can show east side or not
		       for(int k = i; k<n; k++){
		         if(grid[k][j] == 1){
		           canManSeeEast = false;
		           break;
		         }
		       }
		       if(canManSeeEast){
		         count++;
		       }
		     }
		   }
		 }
		 return count;
	 }
	 
	 // Time complexity -> O(n*m), Space complexity -> O(n*m)
	 public static int numCells2(int[][] grid) {
		  int n = grid.length;
		  if(n == 0) return 0;
		  // need to travel from right to left for 
		  // east visibility checking
	      int[][] eastVisArr = new int[n][n];
	      // need to travel from bottom to up for
	      // south visibility checking
	      int[][] southVisArr = new int[n][n];
		     for(int i = 0; i<n; i++){
	        for(int j = n-1; j>=0; j--){
	          if(grid[i][j] == 0){
	            eastVisArr[i][j] = (j!=n-1) ? eastVisArr[i][j+1] : 1;
	          }
	          else{
	            eastVisArr[i][j] = 0;
	          }
	          if(grid[j][i] == 0){
	            southVisArr[j][i] = (j!=n-1) ? southVisArr[j+1][i] : 1;
	          }
	          else{
	            southVisArr[j][i] = 0;
	          }
	        }
	      }
	      int count = 0;
	      for(int i = 0; i<n; i++){
	        for(int j = 0; j<n; j++){
	          if(eastVisArr[i][j] == 1 && southVisArr[i][j] == 1){
	            count++;
	          }
	        }
	      }
	     return count;
	 }
	 
	 // Time complexity -> O(n*m), Space complexity -> O(n*m)
	 public static int numCells3(int[][] grid) {
		 int n = grid.length;
	     if(n == 0) return 0;
	     Pair[][] visArr = new Pair[n][n];
	     // visArr[i][j] => It contain two things. They are-
	     //                       1. isSouthVis -> The mirror placed at 
	     //										   index is visible from south or not
	     //                       2. isEastVis -> East side is visible from 
	     //										  mirror placed at index or not
	     int count = 0;
	     for(int i = n-1; i>=0; i--){
	       for(int j = n-1; j>=0; j--){
	    	 // Mirror can't be placed at this index
	         if(grid[i][j] == 1){
	           visArr[i][j] = new Pair(false, false);
	         }
	         // Mirror can be placed at this index
	         else{
	           visArr[i][j] = new Pair((i+1<n) ? visArr[i+1][j].isSouthVis: true, (j+1<n) ? visArr[i][j+1].isEastVis : true);
	         }
	         if(visArr[i][j].isEastVis && visArr[i][j].isSouthVis){
	           count++;
	         }
	       }
	     }
	     return count;
	 }
	 
	 public static void main(String[] args) {
		   Scanner s = new Scanner(System.in);
		   int n = s.nextInt();
	       int[][] grid = new int[n][n];
		   for(int i = 0; i < n; ++i) {
			   for(int j = 0; j < n; ++j) {
				   grid[i][j] = s.nextInt();
			   }
		   }
		   System.out.print(numCells3(grid));
		   s.close();
	  }

}
