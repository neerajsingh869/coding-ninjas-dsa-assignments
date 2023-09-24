package twoDimArrays;

public class SumOnBoundariesAndDiagonals {
	
	/*
	 * For a given two-dimensional square matrix of size (N x N). 
	 * Find the total sum of elements on both the diagonals and 
	 * at all the four boundaries.
	 */
	
	// Brute force
	public static void totalSum1(int[][] mat) {
		int n = mat.length;
        int sum = 0;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                if(i == 0 || i == n-1){
                    sum += mat[i][j];
                }
                else if(j == 0 || j == n-1){
                    sum += mat[i][j];
                }
                else if(i == j || i + j == n - 1){
                    sum += mat[i][j];
                }
            }
        }
        System.out.println(sum);
	}
	
	// Better approach
	public static void totalSum2(int[][] mat) {
		int n = mat.length;
        int sum = 0;
        // Boundary sum
        for(int i = 1; i<n-1; i++){
            sum += mat[0][i] + mat[n-1][i];
            sum += mat[i][0] + mat[i][n-1];
        }
        // Diagonal sum
        for(int i = 0; i<n; i++){
            sum += mat[i][i] + mat[i][n-1-i];
        }
        // Removing duplicate value
        if(n % 2 != 0){
            sum -= mat[n/2][n/2];
        }
        System.out.println(sum);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
