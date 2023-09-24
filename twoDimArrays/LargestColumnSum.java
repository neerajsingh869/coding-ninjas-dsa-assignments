package twoDimArrays;

import java.util.Scanner;

public class LargestColumnSum {
	
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
	
	public static int maxColSum(int[][] arr) {
		int n = arr.length;
		if(n == 0) {
			return Integer.MIN_VALUE;
		}
		int m = arr[0].length;
		int maxi = Integer.MIN_VALUE;
		for(int i = 0; i<m; i++) {
			int temp = 0;
			for(int j = 0; j<n; j++) {
				temp += arr[j][i];
			}
			if(temp > maxi) {
				maxi = temp;
			}
		}
		return maxi;
	}

	public static void main(String[] args) {
		int[][] input = takeInput2d();
		System.out.println(maxColSum(input));
	}

}
