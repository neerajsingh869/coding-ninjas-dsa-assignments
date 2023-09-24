package hashmaps;

import java.util.HashMap;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class LongestSubsetSum0 {
	
	/*
	 * Given an array consisting of positive and negative integers, find the 
	 * length of the longest subarray whose sum is zero.
	 * 
		Input Format:
		The first line of input contains an integer, that denotes the value of the 
		size of the array. Let us denote it with the symbol N.
		The following line contains N space separated integers, that denote the 
		value of the elements of the array.
		
		Output Format
		The first and only line of output contains length of the longest subarray 
		whose sum is zero.
		
		Constraints:
		0 <= N <= 10^8
		Time Limit: 1 sec
		
		Sample Input 1:
		10 
		 95 -97 -387 -435 -5 -70 897 127 23 284
		Sample Output 1:
		5
		Explanation:
		The five elements that form the longest subarray that sum up to zero are: 
		-387, -435, -5, -70, 897 
		
		Note
		You don't have to print anything. Just complete the definition of the function 
		given and return the value accordingly.
	 */
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static int lengthOfLongestSubsetWithZeroSum1(int arr[]) {
		int count = 0;
		for(int i = 0; i<arr.length; i++){
			int sum = 0;
			for(int j = i; j<arr.length; j++){
				sum += arr[j];
				if(sum == 0){
					count = Math.max(count, j - i + 1);
				}
			}
		}
		return count;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int lengthOfLongestSubsetWithZeroSum2(int arr[]) {
		int ans = 0;
		
		for (int i = 1; i<arr.length; i++) {
			arr[i] += arr[i-1];
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		
		for (int i = 0; i<arr.length; i++) {
			if (arr[i] == 0) {
				// if arr[i] = 0, then length of subset is i + 1
				ans = i + 1;
			} else if ( map.containsKey(arr[i]) ) {
				// in case of repeated sums, sum from map.get(arr[i]) + 1
				// to ith index is 0. So, update ans accordingly 
				ans = Math.max(ans, i - map.get(arr[i]));
			} else {
				// store arr[i] as key and i (first-index with sum arr[i]) 
				// as value in map
				map.put(arr[i], i);
			}
		}
		
		return ans;
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));;
	static StringTokenizer st;

	public static void main(String[] args) throws NumberFormatException, IOException {
		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int arr[] = new int[n];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		System.out.println(lengthOfLongestSubsetWithZeroSum2(arr));
	}

}
