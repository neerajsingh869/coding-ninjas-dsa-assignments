package optionalArrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class GatherRainWater {
	
	/*
	 * Given n non-negative integers representing an elevation 
	 * map where the width of each bar is 1, compute how much 
	 * water it is able to trap after raining.
	 * 
	 * Please refer to Sample test case for more details.

	 * Input format:
	   The first line of input contains size of the array, n.
       The following line of input contains n space separated integers.

	 * Output format:
	   The first and only line of output contains integer, in accordance to the task.
	 * Constraints:
		1 <= n <= 10000
	
	 * Sample Input 1:
		6
		3 0 0 2 0 4
		Sample Output 1:
		10
	 * Sample Input 2 :
		5
		90 70 20 80 50
		Sample Output 2 :
		70
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(n)
	private static int gatherRainWater1(int[] arr){
		int n = arr.length;
		int[] ger = new int[n];
		int[] gel = new int[n];
		for(int i = 0; i<n; i++){
			ger[i] = arr[i];
			gel[i] = arr[i];
		}
		int prevMaxInLeft = Integer.MIN_VALUE;
		for(int i = 0; i<n; i++){
			if(gel[i] > prevMaxInLeft){
				prevMaxInLeft = gel[i];
			}
			gel[i] = prevMaxInLeft;
		}
		int prevMaxInRight = Integer.MIN_VALUE;
		for(int i = n-1; i>=0; i--){
			if(ger[i] > prevMaxInRight){
				prevMaxInRight = ger[i];
			}
			ger[i] = prevMaxInRight;
		}
		Collections.reverse(Arrays.asList(arr));
		int ans = 0;
		for(int i = 0; i<n; i++){
			ans += Math.min(ger[i], gel[i]) - arr[i];
		}
		return ans;
	}
	
	// Time Complexity -> O(n), Space Complexity -> O(1) [BEST APPROACH]
	private static int gatherRainWater2(int[] arr){
		int n = arr.length;
		int peakValue = Integer.MIN_VALUE;
		int peakValueIdx = -1;
		for(int i = 0; i<n; i++){
			if(arr[i] > peakValue){
				peakValue = arr[i];
				peakValueIdx = i;
			}
		}
		// Left to Right
		int sumArea = 0;
		int peakSoFar = Integer.MIN_VALUE;
		int submergedArea = 0;
		int countSubmerged = 0;
		for(int i = 0; i<=peakValueIdx; i++){
			if(arr[i] >= peakSoFar){
				sumArea += peakSoFar*countSubmerged - submergedArea;
				peakSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			}
			else{
				countSubmerged++;
				submergedArea += arr[i]*1;
			}
		}
		// Right to Left
		peakSoFar = Integer.MIN_VALUE;
		submergedArea = 0;
		countSubmerged = 0;
		for(int i = n-1; i>=peakValueIdx; i--){
			if(arr[i] >= peakSoFar){
				sumArea += peakSoFar*countSubmerged - submergedArea;
				peakSoFar = arr[i];
				countSubmerged = 0;
				submergedArea = 0;
			}
			else{
				countSubmerged++;
				submergedArea += arr[i]*1;
			}
		}
		return sumArea;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(gatherRainWater2(arr));
	}

}
