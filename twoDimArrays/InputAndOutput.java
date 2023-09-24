package twoDimArrays;

import java.util.Scanner;

public class InputAndOutput {
	
	// Function to input 2d arrays
	public static int[][] takeInput2d(){
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int m = s.nextInt();
		int[][] arr2d = new int[n][m];
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				arr2d[i][j] = s.nextInt();
			}
		}
		return arr2d;
	}
	
	// Function to print 2d array
	public static void print2d(int[][] arr) {
		int n = arr.length;
		int m = arr[0].length;
		for(int i = 0; i<n; i++) {
			for(int j = 0; j<m; j++) {
				System.out.print(arr[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		int[][] arr = takeInput2d();
		print2d(arr);
	}
	
}
