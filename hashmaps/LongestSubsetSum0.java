package hashmaps;

import java.util.HashMap;

public class LongestSubsetSum0 {
	
	/*
	 * Given an array consisting of positive and negative 
	 * integers, find the length of the longest sub-array 
	 * whose sum is zero.
	 */
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
	
	public static int lengthOfLongestSubsetWithZeroSum2(int arr[]) {
		int count = 0;
		for(int i = 1; i<arr.length; i++){
			arr[i] += arr[i-1];
		}
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++){
			if (arr[i] == 0) {
				count = Math.max(count, i + 1);
			}
			if(!map.containsKey(arr[i])){
				map.put(arr[i], i);
			}
			else{
				count = Math.max(count, i - map.get(arr[i]));
			}
		}
		return count;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
