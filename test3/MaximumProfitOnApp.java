package test3;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumProfitOnApp {
	
	/*
	 * You have made a smartphone app and want to set 
	 * its subscription price such that the profit earned 
	 * is maximised. There are certain users who will 
	 * subscribe to your app only if their budget is 
	 * greater than or equal to your price.
	 * 
	 * You will be provided with a list of size N having budgets 
	 * of subscribers and you need to return the maximum profit 
	 * that you can earn.
	 * 
	 * Lets say you decide that price of your app is Rs. x and there 
	 * are N number of subscribers. So maximum profit you can earn is :
 	 * 								
 	 * 							m * x
	 * 
	 * where m is total number of subscribers whose budget is greater 
	 * than or equal to x.
	 */
	
	// Time Complexity -> O(n*n), Space Complexity -> O(1)
	public static int maximumProfit1(int budget[]) {
        int n = budget.length;
        int ans = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            int count = 0;
            for(int j = 0; j<n; j++){
                if(budget[j] >= budget[i]){
                    count++;
                }
            }
            ans = Math.max(ans, count*budget[i]);
        }
        return ans;
	}
	
	// Time Complexity -> O(n*log(n)), Space Complexity -> O(1)
	public static int maximumProfit2(int budget[]) {
        int n = budget.length;
        int ans = Integer.MIN_VALUE;
        Arrays.sort(budget);
        for(int i = 0; i<n; i++){
            ans = Math.max(ans, budget[i]*(n-i));
        }
        return ans;
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i=0;i<n;i++)
			input[i] = s.nextInt();
		
		System.out.println(maximumProfit2(input));
	}

}
