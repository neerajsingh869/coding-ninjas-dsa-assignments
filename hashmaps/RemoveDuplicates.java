package hashmaps;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class RemoveDuplicates {
	
	// Time complexity -> O(nlongn), Space complexity -> O(n)
	public static ArrayList<Integer> removeDuplicates1(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		Arrays.sort(arr);
		for(int i = 0; i<arr.length-1; i++) {
			if(arr[i] != arr[i+1]) {
				ans.add(arr[i]);
			}
		}
		ans.add(arr[arr.length-1]);
		return ans;
	}
	
	// Time complexity -> O(n*n), Space complexity -> O(n)
	public static ArrayList<Integer> removeDuplicates2(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++) {
			if(!map.containsValue(arr[i])) {
				map.put(i, arr[i]);
				ans.add(arr[i]);
			}
		}
		return ans;
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static ArrayList<Integer> removeDuplicates3(int[] arr){
		ArrayList<Integer> ans = new ArrayList<>();
		HashMap<Integer, Boolean> map = new HashMap<>();
		for(int i = 0; i<arr.length; i++) {
			if(!map.containsKey(arr[i])) {
				map.put(arr[i], true);
				ans.add(arr[i]);
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		int[] arr = {1, 2, 2, 3, 4, 3, 5, 4};
		ArrayList<Integer> ans = removeDuplicates3(arr);
		System.out.println(ans);
	}

}
