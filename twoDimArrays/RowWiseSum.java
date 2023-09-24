package twoDimArrays;

public class RowWiseSum {
	
	/*
	 * For a given two-dimensional integer array/list of 
	 * size (N x M), find and print the sum of each of 
	 * the row elements in a single line, separated by a single space.
	 */
	
	public static void rowWiseSum(int[][] mat) {
		int n = mat.length;
        if(n == 0){
            return;
        }
        int m = mat[0].length;
        for(int i = 0; i<n; i++){
            int rowSum = 0;
            for(int j = 0; j<m; j++){
                rowSum += mat[i][j];
            }
            System.out.print(rowSum + " ");
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
