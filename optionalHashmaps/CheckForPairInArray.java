package optionalHashmaps;

import java.util.Scanner;

public class CheckForPairInArray {
	
	/*
	 * You are given a N-sized array of integers and a value k. In the given array you have to find whether this array can be divided into pairs such that the sum of every pair is divisible by k.
Note:
Try to solve this problem in O(n) time complexity.
Input Format:
The first line of input contains the number of elements of the given array. The second line of input contains space-separated array elements and the last line of input contains the value of k.
Output Format:
The only line of output contains either true(if the array can be divided into pairs such that the sum of every pair is divisible by k) or false.
Constraints:
1<=Number of elements of array<=1000
Sample Input:
8 
1 5 0 4 4 3 7 0
8
Sample Output:
true
Explanation:
We can divide array into (1, 7), (5, 3), (4, 4) and (0,0). Sum of all of these pairs is a multiple of 8.
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static boolean ispairexist(int[] arr, int n, int k) {
		if(n % 2 != 0){
			return false;
		}
		int countPair = 0;
		boolean[] isVisited = new boolean[n];
		for(int i = 0; i<n-1; i++){
			int remToFind = k - (arr[i] % k);
			remToFind = remToFind % k;
			for(int j = i+1; j<n; j++){
				if(!isVisited[j] && !isVisited[i] && 
					(arr[j] % k == remToFind)){
					isVisited[j] = true;
					isVisited[i] = true;
					countPair++;
					break;
				}
			}
		}
		return (countPair == n/2) ? true : false;
	}
	
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];

		for (int i = 0; i < arr.length; i++) {
			arr[i] = scn.nextInt();
		}
		int k = scn.nextInt();
		if(ispairexist(arr, n, k)) {
			System.out.println(true);
		}else {
			System.out.println(false);
		}
	}

}
