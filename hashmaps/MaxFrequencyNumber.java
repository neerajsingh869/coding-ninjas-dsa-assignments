package hashmaps;

import java.util.HashMap;

public class MaxFrequencyNumber {
	
	/*
	 * You are given an array of integers that contain numbers 
	 * in random order. Write a program to find and return the 
	 * number which occurs the maximum times in the given input.
	 * 
	 * If two or more elements contend for the maximum frequency, 
	 * return the element which occurs in the array first.
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static int maxFrequencyNumber1(int[] arr){
        int n = arr.length;
        int maxFreq = Integer.MIN_VALUE;
        int maxNum = 0;
        for(int i = 0; i<n; i++){
            int tempCount = 0;
            for(int j = 0; j<n; j++){
                if(arr[i] == arr[j]){
                    tempCount++;
                }
            }
            if(tempCount > maxFreq){
                maxFreq = tempCount;
                maxNum = arr[i];
            }
        }
        return maxNum;
    }
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static int maxFrequencyNumber2(int[] arr){
        int n = arr.length;
        HashMap<Integer, Integer> freq = new HashMap<>();
        int maxFreq = Integer.MIN_VALUE;
        int maxNum = 0;
        for(int i : arr){
//            if(freq.containsKey(i)){
//                freq.put(i, freq.get(i) + 1);
//            }
//            else{
//                freq.put(i, 1);
//            }
        	freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for(int i : arr){
            if(freq.get(i) > maxFreq){
                maxFreq = freq.get(i);
                maxNum = i;
            }
        }
        return maxNum;
    }

	public static void main(String[] args) {
		
	}

}
