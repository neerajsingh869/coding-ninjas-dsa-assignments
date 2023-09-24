package twoDimArrays;

public class PrintLikeWave {
	
	/*
	 * For a given two-dimensional integer array/list of 
	 * size (N x M), print the array/list in a sine wave 
	 * order, i.e, print the first column top to bottom, 
	 * next column bottom to top and so on.
	 */

	public static void wavePrint(int mat[][]){
		int n = mat.length;
        if(n == 0){
            return;
        }
        int m = mat[0].length;
        for(int j = 0; j<m; j++){
            for(int i = 0; i<n; i++){
                if(j % 2 == 0){
                    System.out.print(mat[i][j] + " ");
                }
                else{
                    System.out.print(mat[n-1-i][j] + " ");
                }
            }
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
