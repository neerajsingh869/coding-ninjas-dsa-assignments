package fullTest1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class CheckSubset {
	/*
	 * Given two integer arrays. Check if second array is a subset of first array.
Input format :
Line 1 : Integer N1 
Line 2 : N1 integers separated be a single space
Line 1 : Integer N2 
Line 2 : N2 integers separated be a single space
Output Format :
 Boolean
Constraints :
 0 <= N1 <= 10^4
 0 <= N2 <= 10^4
Sample Input :
15
3 6 5 8 15 1 14 18 7 9 14 9 3 12 8 
4
18 6 9 8
Sample Output :
true
	 */
	// Time complexity -> O(n1*n2)
	public static boolean checkSubset1(int[] arr1, int n1, int[] arr2, int n2) {
		for (int i = 0; i < n2; i++) {
			boolean isEleFound = false;
			
			for (int j = 0; j < n1; j++) {
				if (arr2[i] == arr1[j]) {
					arr1[j] = Integer.MIN_VALUE;
					isEleFound = true;
					break;
				}
			}
			
			if (isEleFound == false) {
				return false;
			}
		}
        return true;
	}
	
	// Time complexity -> O(n1*log(n1) + n2*log(n2)), Space complexity -> O(1)
	public static boolean checkSubset2(int[] arr1, int n1, int[] arr2, int n2) {
		Arrays.sort(arr1);
		Arrays.sort(arr2);
		
		int i = 0, j = 0;
		while (i < n1 && j < n2) {
			if (arr1[i] == arr2[j]) {
				i++;
				j++;
			} else if (arr1[i] < arr2[j]){
				i++;
			} else {
				return false;
			}
		}
		
		if (j < n2) return false;
		
		return true;
	}
	
	// Time complexity -> O(n1 + n2), Space complexity -> O(n1)
	public static boolean checkSubset6(int[] arr1, int n1, int[] arr2, int n2) {
		HashMap<Integer, Integer> freqArr1 = new HashMap<>();
		
		for (int i = 0; i < n1; i++) {
			freqArr1.put(arr1[i], freqArr1.getOrDefault(arr1[i], 0) + 1);
		}
		
		for (int i = 0; i < n2; i++) {
			if (freqArr1.getOrDefault(arr1[i], 0) > 0) {
				freqArr1.put(arr2[i], freqArr1.get(arr2[i]) - 1);
			} else {
				return false;
			}
		}
		
		return true;
	}
	
	static Scanner s  = new Scanner(System.in);
	
	public static void main(String[] args) {
		int n = s.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++){
			arr[i] = s.nextInt();
		} 
		n = s.nextInt();
		int arr1[] = new int[n];
		for(int i=0;i<n;i++){
			arr1[i] = s.nextInt();
		} 
		System.out.println(checkSubset6(arr,arr.length,arr1,arr1.length));
	}
}
