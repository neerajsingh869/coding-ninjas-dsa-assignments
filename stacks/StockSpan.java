package stacks;

import java.util.Stack;

public class StockSpan {
	
	/*
	 * Afzal has been working with an organization called 
	 * 'Money Traders' for the past few years. The organization 
	 * is into the money trading business. His manager assigned 
	 * him a task. For a given array/list of stock's prices for 
	 * N days, find the stock's span for each day.
	 * 
	 * The span of the stock's price today is defined as the 
	 * maximum number of consecutive days(starting from today 
	 * and going backwards) for which the price of the stock 
	 * was less than today's price.
	 * 
	 * For example, if the price of a stock over a period of 
	 * 7 days are [100, 80, 60, 70, 60, 75, 85], then the stock 
	 * spans will be [1, 1, 1, 2, 1, 4, 6].
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(n)
	public static int[] stockSpan1(int[] price) {
		int n = price.length;
		int[] ans = new int[n];
		for(int i = 0; i<n; i++){
			int count = 1;
			for(int j = i-1; j>=0; j--){
				if(price[j] < price[i]){
					count++;
				}
				else{
					break;
				}
			}
			ans[i] = count;
		}
		return ans;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	public static int[] stockSpan2(int[] price) {
		int n = price.length;
		Stack<Integer> st = new Stack<>();
		int[] ans = new int[n];
		for(int i = 0; i<n; i++){
			while(!st.isEmpty() && (price[i] > price[st.peek()])){
				st.pop();
			}
			ans[i] = (st.isEmpty()) ? i + 1 : i - st.peek();
			st.push(i);
		}
		return ans;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
