package test3;

import java.util.Scanner;

public class SplitArray {
	
	/*
	 * Given an integer array A of size N, check if the input 
	 * array can be splitted in two parts such that -
	 * 
	 * 				- Sum of both parts is equal
	 * 				- All elements in the input, which are 
	 * 				  divisible by 5 should be in same group.
	 * 				- All elements in the input, which are 
	 * 				  divisible by 3 (but not divisible by 5) 
	 * 				  should be in other group.
	 * 				- Elements which are neither divisible by 5 
	 * 				  nor by 3, can be put in any group.
	 * 
	 * Groups can be made with any set of elements, i.e. elements 
	 * need not to be continuous. And you need to consider each 
	 * and every element of input array in some group.
	 * 
	 * Return true, if array can be split according to the above 
	 * rules, else return false.
	 */
	
	// Time Complexity -> Exponential, Space Complexity -> O(n)
	public static boolean splitArray(int input[]) {
        return splitArray(input, 0, 0, 0);
	}
    
    public static boolean splitArray(int[] input, int idx, int sum1TillNow, int sum2TillNow){
        int n = input.length;
        // Base case
        if(idx == n){
            return sum1TillNow == sum2TillNow;
        }
        // Induction Step -> Deciding in which group to put input[idx]
        // Induction Hypothesis -> splitArray method will check if two
        // groups with same sum can be done or not by following the
        // conditions
        if(input[idx] % 5 == 0){
            return splitArray(input, idx+1, sum1TillNow+input[idx], sum2TillNow);
        }
        else if(input[idx] % 3 == 0){
            return splitArray(input, idx+1, sum1TillNow, sum2TillNow+input[idx]);
        }
        else{
            return (splitArray(input, idx+1, sum1TillNow+input[idx], sum2TillNow) || 
                   splitArray(input, idx+1, sum1TillNow, sum2TillNow+input[idx]));
        }
    }

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int input[] = new int[n];
		for(int i = 0; i < n; i++) {
			input[i] = s.nextInt();
		}
		System.out.println(splitArray(input));
	}

}
