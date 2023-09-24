package optionalArrays;

import java.util.Scanner;

public class BinaryMatrix {
	
	/*
	 * You are given a matrix mat[M][N] of size M X N having 0's 
	 * and 1's only, you have to modify it such that if a matrix 
	 * cell mat[i][j] is 1, then make all the cells of ith row and 
	 * jth column as 1.
	
	 * Note: Try doing it without any extra space.
	 
	 * Input Format:
		The first line of input contains the number of rows(M) of 
		the input matrix, the following line of input contains the 
		number of columns of the input matrix(N) and then the 
		following M lines contain the input matrix.
	 
	 * Output Format
		The M lines of output contain the modified matrix.
	 
	 * Sample Input:
		3
		4
		1 0 0 1
		0 0 1 0
		0 0 0 0
	 * Sample Output:
		1 1 1 1
		1 1 1 1
		1 0 1 1
	 */
	
	// Time Complexity -> O(n*m*(n+m)), Space Complexity -> O(1)
	private static void newMat1(int[][] arr, int m, int n){
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(arr[i][j] == 1){
					for(int k = 0; k<m; k++){
						if(arr[k][j] != 1){
							arr[k][j] = -1;
						}
					}
					for(int l = 0; l<n; l++){
						if(arr[i][l] != 1){
							arr[i][l] = -1;
						}
					}
				}
			}
		}
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(arr[i][j] == -1){
					arr[i][j] = 1;
				}
			}
		}
	}
	
	// Time Complexity -> O(n*m), Space Complexity -> O(n+m)
	private static void newMat2(int[][] arr, int m, int n){
		boolean[] rowArr = new boolean[m];
		boolean[] colArr = new boolean[n];
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(arr[i][j] == 1){
					rowArr[i] = true;
					colArr[j] = true;
				}
			}
		}
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				if(rowArr[i] || colArr[j]){
					arr[i][j] = 1;
				}
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m = sc.nextInt();
		int n = sc.nextInt();
		int[][] arr = new int[m][n];
		for(int i = 0; i<m; i++){
			for(int j =0; j<n; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		newMat1(arr, m, n);
		for(int i = 0; i<m; i++){
			for(int j = 0; j<n; j++){
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
}
