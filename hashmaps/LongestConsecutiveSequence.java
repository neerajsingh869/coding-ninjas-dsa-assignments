package hashmaps;

import java.util.ArrayList;
import java.util.HashMap;

public class LongestConsecutiveSequence {
	
	/*
	 * You are given an array of unique integers that contain 
	 * numbers in random order. You have to find the longest 
	 * possible sequence of consecutive numbers using the numbers 
	 * from given array.
	 * 
	 * You need to return the output array which contains starting 
	 * and ending element. If the length of the longest possible 
	 * sequence is one, then the output array must contain only 
	 * single element.
	 */
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence1(int[] arr) {
		HashMap<Integer, Integer> freq = new HashMap<>();

		for (int i = 0; i < arr.length; i++) {
			freq.put(arr[i], freq.getOrDefault(arr[i], 0) + 1);
		}

		int maxCount = Integer.MIN_VALUE;
		int maxFirstNum = arr[0];
		int maxSecondNum = arr[0];

		for (int i = 0; i < arr.length; i++) {
			int currNum = arr[i];
			int tempFirstNum = currNum;
			int count = 0;
			while (freq.containsKey(currNum)) {
				count++;
				currNum += 1;
			}
			int tempSecondNum = currNum - 1;
			if (count > maxCount) {
				maxCount = count;
				maxFirstNum = tempFirstNum;
				maxSecondNum = tempSecondNum;
			}
		}
		
		ArrayList<Integer> ans = new ArrayList<>();
		if (maxFirstNum == maxSecondNum) {
			ans.add(maxFirstNum);
			return ans;
		}
		ans.add(maxFirstNum);
		ans.add(maxSecondNum);
		return ans;
    }
	
	public static ArrayList<Integer> longestConsecutiveIncreasingSequence2(int[] arr) {
		int n = arr.length;
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i<n; i++){
			map.put(arr[i], true);
		}
		int count = 1;
		int stEle = arr[0];
		for(int i = 0; i<n; i++){
			if(!map.containsKey(arr[i] - 1)){
				int tempStEle = arr[i];
				int j = arr[i];
				int tempCount = 0;
				while(map.containsKey(j)){
					tempCount++;
					j++;
				}
				if(tempCount > count){
					count = tempCount;
					stEle = tempStEle;
				}
			}
		}
		ArrayList<Integer> ans = new ArrayList<>();
		ans.add(stEle);
		if(count > 1){
			ans.add(stEle + count - 1);
		}
		return ans;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
