package optionalStackNQueues;

import java.util.Scanner;
import java.util.Stack;

public class MaximumAreaInHistogram {
	
	/*
	 * You are given a histogram in the form of an array of size N. Each element in the array represents the height of the histogram's bar. You may assume that the width of each bar is 1 unit. Find out the area of the largest rectangle that can fit inside the histogram.
Below is shown a picture of the histogram represented by the array [2, 1, 5, 6, 2, 3]. It also shows the rectangle with the largest area
Histogram

Input Format:
First line of the input has N, the size of the array
Second line of the input has N space-separated integers representing the bar heights of the histogram
Output Format:
The only line of the output contains the area of the largest rectangle that can fit inside the histogram
Constraints:
1 <= N <= 10^6
Time limit: 1sec
Sample Input 1
2
3 5
Sample Output 1
6
Sample Input 2
6
2 1 5 6 2 3
Sample Output 2
10
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int getMaxArea1(int[] array, int n) {
		int ans = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			int count = 1;
			for(int j = i-1; j>=0; j--){
				if(array[j] < array[i]){
					break;
				}
				count++;
			}
			for(int j = i+1; j<n; j++){
				if(array[j] < array[i]){
					break;
				}
				count++;
			}
			ans = Math.max(ans, array[i]*count);
		}
		return ans;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static int getMaxArea2(int[] array, int n) {
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

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] array = new int[n];

		for (int i = 0; i < n; i++) {
			array[i] = scn.nextInt();
		}

		System.out.println(getMaxArea2(array, n));

	}

}
