package backtracking;

public class NQueen {
	
	/*
	 * You are given N, and for a given N x N chess board, 
	 * find a way to place N queens such that no queen can 
	 * attack any other queen on the chess board. A queen 
	 * can be killed when it lies in the same row, or same 
	 * column, or the same diagonal of any of the other queens. 
	 * You have to print all such configurations.
	 */
	
	public static void placeNQueens(int n){
		int board[][] = new int[n][n];
		placeNQueens(board, n, 0);
	}

	public static void placeNQueens(int board[][], int n, int rowIdx){
		if(rowIdx == n){
			for(int i = 0; i<n; i++){
				for(int j = 0; j<n; j++){
					System.out.print(board[i][j] + " ");
				}
			}
			System.out.println();
			return;
		}
		for(int j = 0; j<n; j++){
			if(isSafePosition(board, rowIdx, j, n)){
				board[rowIdx][j] = 1;
				placeNQueens(board, n, rowIdx + 1);
				board[rowIdx][j] = 0;
			}
		}
	}

	public static boolean isSafePosition(int board[][], int rowIdx, int colIdx, int n){
		// Checking clash in same column
		for(int i = 0; i<rowIdx; i++){
			if(board[i][colIdx] == 1){
				return false;
			}
		}
		// Checking clash in diagonal
		for(int i = rowIdx - 1, j = colIdx - 1; i>=0 && j>=0; i--, j--){
			if(board[i][j] == 1){
				return false;
			}
		}
		for (int i = rowIdx - 1, j = colIdx + 1; i >= 0 && j < n; i--, j++) {
			if (board[i][j] == 1) {
				return false;
			}
		}
		return true;
	}

}
