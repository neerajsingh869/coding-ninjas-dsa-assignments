package optionalStackNQueues;

import java.util.Scanner;
import java.util.Stack;

public class MaximumRectangularArea {
	
	/*
	 * You are given a binary matrix. You have to print the maximum area possible for a sub-matrix with all 1's.
		Input Format:
		The first line of input contains two integers N (number of rows) and M (number of columns) of the binary matrix.
		The second line of input contains N*M space-separated elements of the binary matrix.
		Output Format:
		The only output line contains a single integer which will be the maximum area possible of sub-matrix of all 1's.
		Sample Input:
		4 5
		0 1 0 0 0 1 1 1 1 1 1 1 1 1 1 1 0 0 0 0
		Sample Output:
		10
		Explanation:
		The matrix for the above Sample Input is:
		0 1 0 0 0
		1 1 1 1 1
		1 1 1 1 1
		1 0 0 0 0
		
		The maximum size rectangle in this binary matrix is:
		1 1 1 1 1
		1 1 1 1 1
		
		So, the area of the rectangle is=5*2=10
	 */
	
	public static int maxRectArea(int[][] array){
		int n = array.length;
		if(n == 0){
			return 0;
		}
		int m = array[0].length;
		int ans = 0;
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				if(array[i][j] == 0){
					array[i][j] = 0;
				}
				else{
					array[i][j] += (i>0 ?  array[i-1][j] : 0);
				}
			}
			ans = Math.max(ans, getMaxArea(array[i], m));
		}
		return ans;
	}

	public static int getMaxArea(int[] array, int n) {
		Stack<Integer> st = new Stack<>();
		int maxArea = 0;
		int i = 0;
		while(i < n){
			if(st.isEmpty() || array[i] >= array[st.peek()]){
				st.push(i);
				i++;
			}
			else{
				int topIdx = st.peek();
				st.pop();
				int tempMaxArea = array[topIdx]*(st.isEmpty() ? i : i-st.peek()-1);
				maxArea = Math.max(maxArea, tempMaxArea);
			}
		}
		while(!st.isEmpty()){
			int topIdx = st.peek();
			st.pop();
			int tempMaxArea = array[topIdx]*(st.isEmpty() ? n : n-st.peek()-1);
			maxArea = Math.max(maxArea, tempMaxArea);
		}
		return maxArea;
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] arr = new int[n][m];
		for(int i = 0; i<n; i++){
			for(int j = 0; j<m; j++){
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println(maxRectArea(arr));
	}

}
