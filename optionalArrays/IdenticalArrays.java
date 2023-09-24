package optionalArrays;

import java.util.Scanner;

public class IdenticalArrays {
	
	/*
	 * You are given two input arrays of same size n, which 
	 * contains the same elements but placed in a different 
	 * order. Elements present in the first or second array 
	 * should be distinct. You have to make the second array 
	 * same as the first array using a minimum number of swaps.
	 * Note: We can only make changes in the second array.
	
	 * Input format:
	   The first line of input contains the size of both the input arrays(n). The following line contains n space-separated integers elements of the first array and the last line contains n space-separated elements of the second array.
	
	 * Output format:
	   Minimum number of swaps required to make the two arrays identical.
	
	 * Constraints:
		0 <= n <= 1000
	
	 * Sample Input 1 :
		5
		5 1 6 9 7
		1 7 6 9 5
		Sample Output 1 :
		2
	
	 * Sample Input 2 :
		4
		4 1 2 5
		1 4 5 2
		Sample Output 2 :
		2
	 */
	
	private static int minNumSwaps(int[] arr1, int[] arr2){
		int n = arr1.length;
		int ans = 0;
		for(int i = 0; i<n; i++){
			if(arr1[i] != arr2[i]){
				int j = i+1;
				for(; j<n; j++){
					if(arr1[i] == arr2[j]){
						break;
					}
				}
				if(j == n){
					return 0;
				}
				swap(arr2, i, j);
				ans++;
			}
		}
		return ans;
	}

	private static void swap(int[] arr2, int i, int j){
		int temp = arr2[i];
		arr2[i] = arr2[j];
		arr2[j] = temp;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr1 = new int[n];
		for(int i = 0; i<n; i++){
			arr1[i] = sc.nextInt();
		}	
		int[] arr2 = new int[n];
		for(int i = 0; i<n; i++){
			arr2[i] = sc.nextInt();
		}
		System.out.println(minNumSwaps(arr1, arr2));
	}

}
