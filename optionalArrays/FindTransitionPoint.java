package optionalArrays;

import java.util.Scanner;

public class FindTransitionPoint {
	
	/*
	 * You are given a sorted array of size n, containing only 
	 * numbers 0 and 1, you have to find the transition point 
	 * of the given input array. The transition point is a point 
	 * where “0” ends and “1” begins.
	 * If there are no 1's in the input array then print -1.
	 * Note: Expected time complexity is O(log n).
	
	 * Input Format :
	   The first line of input contains the size of the input array(n) and the following line of input contains n space-separated integer elements of the input array.
	
	 * Output format :
	   The only output line contains the index of transition point in the input array.
	
	 * Constraints :
	 	0 <= n <= 10^6
	
	 * Sample Input 1 :
		5
		0 0 0 1 1
		Sample Output 1 :
		3
	
	 * Sample Input 2 :
		2
		0 0
		Sample Output 2 :
		-1
	 */
	
	private static int transPoint(int[] arr){
		int n = arr.length;
		int transPoint = -1;
		int st = 0, end = n-1;
		while(st <= end){
			int mid = st + (end-st)/2;
			if(arr[mid] == 1){
				transPoint = mid;
				end = mid-1;
			}
			else{
				st = mid+1;
			}
		}
		return transPoint;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		System.out.println(transPoint(arr));
	}

}
