package twoDimArrays;

public class LargestRowOrColumn {
	
	/*
	 * For a given two-dimensional integer array/list of 
	 * size (N x M), you need to find out which row or 
	 * column has the largest sum(sum of all the elements 
	 * in a row/column) amongst all the rows and columns.
	 */
	
	public static void findLargest(int mat[][]){
		int n = mat.length;
        int maxRowSum = Integer.MIN_VALUE, maxRowIdx = 0;
        int maxColSum = Integer.MIN_VALUE, maxColIdx = 0;
        if(n == 0){
            System.out.println("row " + maxRowIdx + " " + maxRowSum);
            return;
        }
        int m = mat[0].length;
        for(int i = 0; i<n; i++){
            int rowSum = 0;
            for(int j = 0; j<m; j++){
                rowSum += mat[i][j];
            }
            if(rowSum > maxRowSum){
                maxRowSum = rowSum;
                maxRowIdx = i;
            }
        }
        for(int j = 0; j<m; j++){
            int colSum = 0;
            for(int i = 0; i<n; i++){
                colSum += mat[i][j];
            }
            if(colSum > maxColSum){
                maxColSum = colSum;
                maxColIdx = j;
            }
        }
        if(maxColSum > maxRowSum){
            System.out.println("column " + maxColIdx + " " + maxColSum);
        }
        else{
            System.out.println("row " + maxRowIdx + " " + maxRowSum);
        }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
