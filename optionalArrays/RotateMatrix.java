package optionalArrays;

import java.util.Scanner;

public class RotateMatrix {
	
	/*
	 * Given an N*N integer square matrix, rotate it by 
	 * 90 degrees in anti-clockwise direction.
	 * Try doing it without any extra space.
	 
	 * Note : You just need to change in the given input itself. No need to return or print anything.

	 * Input format :
		Line 1 : Integers N
		Next N lines : N integers, elements of one row (separated by space)

	 * Output Format :
		Updated matrix
	
	 * Constraints :
		1 <= N <= 1000

	 * Sample Input :
		3
		1 2 3
		4 5 6
		7 8 9
	 
	  * Sample Output :
		3  6  9 
		2  5  8 
		1  4  7
	 */
	
	public static void rotate(int input[][]){
		int n = input.length;
		if(n == 0){
			return;
		}
		for(int i = 0; i<n/2; i++){
			for(int j = i; j<n-i-1; j++){
				int temp = input[i][j];
				input[i][j] = input[j][n-i-1];
				input[j][n-i-1] = input[n-i-1][n-j-1];
				input[n-i-1][n-j-1] = input[n-1-j][i];
				input[n-1-j][i] = temp;
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int arr[][] = new int[n][n];
		for(int i = 0; i < n; i++)
			for(int j = 0; j < n; j++)
				arr[i][j] = s.nextInt();
		rotate(arr);	
		
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}

}
