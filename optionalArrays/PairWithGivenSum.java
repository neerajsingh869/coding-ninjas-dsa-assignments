package optionalArrays;

import java.util.Scanner;

public class PairWithGivenSum {
	
	/*
	 * Given an array that is sorted and then rotated around 
	 * an unknown point. Find if the array has a pair with 
	 * a given sum ‘x’. It may be assumed that all elements 
	 * in the array are distinct.
	 * Expected Time Complexity: O(n)

	 * Input format:
	   The first line of input contains an integer that denotes the size of the array (n). The following line contains n space-separated integer elements of the array and the last line of input contains an integer that denotes the value of the given sum x.
	
	 * Output format:
	   The only line of the output contains either true (if the given array has a pair with a given sum 'x') or false(if the given array doesn't have a pair with a given sum 'x') 
	
	 * Constraints:
		1 <= n <= 10^6
		-1e9 <= x <= 1e9
	
	 * Sample Input 1 :
		6
		11 15 26 38 9 10
		45
		Sample Output 1 :
		false
	
	 * Sample Input 2 :
		6
		3 4 5 0 1 2
		7
		Sample Output 2 :
		true
	 */
	
	private static boolean isPairSum(int[] arr, int sum){
		int n = arr.length;
		int minIdx = findMinIdx(arr, 0, n-1);
		return isPairSum(arr, minIdx, sum);
	}

	private static boolean isPairSum(int[] arr, int i, int sum){
		int n = arr.length;
		int j = (i-1+n)%n;
		while(i!=j){
			if(arr[i] + arr[j] == sum){
				return true;
			}
			else if(arr[i] + arr[j] > sum){
				j = (j-1+n)%n;
			}
			else{
				i = (i+1)%n;
			}
		}
		return false;
	}

	private static int findMinIdx(int[] arr, int st, int end){
		int n = arr.length;
		while(st <= end){
			int mid = st + (end-st)/2;
			int next = (mid+1)%n;
			int prev = (mid-1+n)%n;
			if(arr[mid] < arr[next] && arr[mid] < arr[prev]){
				return mid;
			}
			else if(arr[mid] < arr[end]){
				end = prev;
			}
			else{
				st = next;
			}
		}
		return -1;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int sum = sc.nextInt();
		System.out.println(isPairSum(arr, sum));
	}

}
