package twoDimArrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
	public static void spiralPrint1(int matrix[][]){
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
	
	public static void spiralPrint2(int matrix[][]){
		int n = matrix.length;
		if (n == 0) {
			return;
		}

		int m = matrix[0].length;

		int totalIter = n / 2 - 1;
		if (n % 2 != 0) {
			totalIter = n / 2;
		}

		int k = 0;
		int totalCount = n * m;
		for (int iter = 0; iter <= totalIter; iter++) {
			for (int j = 0 + iter; j < m - iter && k < totalCount; j++, k++) {
				System.out.print(matrix[iter][j] + " ");
			}

			for (int i = iter + 1; i < n - iter - 1 && k < totalCount; i++, k++) {
				System.out.print(matrix[i][m - iter - 1] + " ");
			}

			for (int j = m - iter - 1; j >= iter && k < totalCount; j--, k++) {
				System.out.print(matrix[n - iter - 1][j] + " ");
			}

			for (int i = n - iter - 2; i > iter && k < totalCount; i--, k++) {
				System.out.print(matrix[i][iter] + " ");
			}
		}
	}
	
	// Best approach [Time complexity -> O(n*m), Space complexity -> O(1)]
	public static void spiralPrint(int matrix[][]){
		int n = matrix.length;
		if (n == 0) return;
		int m = matrix[0].length;

		int rowNo = 0, colNo = 0, k = 0, totalElements = n * m;
		while (k < totalElements) {
			for (int j = colNo; j < m && k < totalElements; j++, k++) {
				System.out.print(matrix[rowNo][j] + " ");
			}
			rowNo++;

			for (int i = rowNo; i < n && k < totalElements; i++, k++) {
				System.out.print(matrix[i][m - 1] + " ");
			}
			m--;

			for (int j = m - 1; j >= colNo && k < totalElements; j--, k++) {
				System.out.print(matrix[n - 1][j] + " ");
			}
			n--;
			
			for (int i = n - 1; i >= rowNo && k < totalElements; i--, k++) {
				System.out.print(matrix[i][colNo] + " ");
			}
			colNo++;
		}
	}
	
	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    
    public static int[][] take2DInput() throws IOException {
        String[] strRowsCols = br.readLine().trim().split("\\s");
        int n_rows = Integer.parseInt(strRowsCols[0]);
        int m_cols = Integer.parseInt(strRowsCols[1]);

        if (n_rows == 0) {
            return new int[0][0];
        }


        int[][] mat = new int[n_rows][m_cols];

        for (int row = 0; row < n_rows; row++) {
            String[] strNums; 
            strNums = br.readLine().trim().split("\\s");
            
            for (int col = 0; col < m_cols; col++) {
                mat[row][col] = Integer.parseInt(strNums[col]);
            }
        }

        return mat;
    }


    public static void main(String[] args) throws NumberFormatException, IOException {
        int t = Integer.parseInt(br.readLine().trim());

        while(t > 0) {

            int[][] mat = take2DInput();

            spiralPrint2(mat);
            System.out.println();

            t -= 1;
        }
    }

}
