package group1Test;

import java.util.Scanner;

public class MaximumSubarraySum {
	
	/*
	 * This problem was asked by Amazon.
Given an array of numbers, find the maximum sum of any contiguous subarray of the array.
For example, given the array [34, -50, 42, 14, -5, 86], the maximum sum would be 137, since we would take elements 42, 14, -5, and 86.
Given the array [-5, -1, -8, -9], the maximum sum would be -1.
Follow up: Do this in O(N) time.
Input Format:
The first line of input contains size of array, which is denoted by N and second line of input contains N space separated integers.
Output Format:
The first and only line of output should print the maximum subarray sum, as described in the description.
	 */
	
	// Best approach (Time complexity -> O(n))
	public static int maximumSubarraySum(int[] arr) {
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i<arr.length; i++){
            sum += arr[i];
            ans = Math.max(ans, sum);
            if(sum <= 0) {
                sum = 0;
            }
        }
        return ans;
    }
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int ans = maximumSubarraySum(arr);
        System.out.println(ans);
    }

}
