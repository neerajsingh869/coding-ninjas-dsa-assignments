package twoDimArrays;

public class PrintSpiral {
	
	/*
	 * For a given two-dimensional integer array/list of 
	 * size (N x M), print it in a spiral form. That is, 
	 * you need to print in the order followed for every iteration:
	 * 
	 * 			a. First row(left to right)
	 * 			b. Last column(top to bottom)
	 * 			c. Last row(right to left)
	 * 			d. First column(bottom to top)
 	 * 
 	 * Mind that every element will be printed only once.
	 */

	// Time complexity -> O(n*m), Space complexity -> O(1)
	public static void spiralPrint(int matrix[][]){
        int n = matrix.length;
        if(n == 0){
            return;
        }
        int m = matrix[0].length;
        int count = 0, i = 0;
        while(count < m*n){
           // Top Row
            for(int j = 0+i; count<m*n && j<m-i; j++){
                System.out.print(matrix[i][j] + " ");
                count++;
            }
            // Right col
            for(int j = 1+i; count<m*n && j<n-1-i; j++){
                System.out.print(matrix[j][m-1-i] + " ");
                count++;
            }
            // Bottom row
            for(int j = m-1-i; count<m*n && j>=i; j--){
                System.out.print(matrix[n-1-i][j] + " ");
                count++;
            }
            // Left col
            for(int j = n-2-i; count<m*n && j>=1+i; j--){
                System.out.print(matrix[j][i] + " ");
                count++;
            }
            i++;
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
