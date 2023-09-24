package optionalArrays;

import java.util.Scanner;

public class SearchInArray {
	
	/*
	 * Aahad and Harshit always have fun by solving problems. 
	 * Harshit took a sorted array and rotated it clockwise by 
	 * unknown amount. For example, he took a sorted array = 
	 * [1, 2, 3, 4, 5] and if he rotates it by 2, then the array 
	 * becomes: [4, 5, 1, 2, 3].
	 * After rotating a sorted array, Harshit gave Aahad a number 
	 * which Harshit wanted him to search in the array. If he 
	 * founds it, he had to shout the index of the number, 
	 * otherwise he had to shout -1.
	 
	 * Expected Time complexity of the code: O (log n)
	
	 * Input format:
	   The first line of input contains size of the array: N
	   The second line contains N space separated integers: A[i]
	   The third line of input contains the key: the number which Harshit wants Aahad to search, k
	
	 * Output format:
	   The first and only of output contains a integer (as specified in the task).
	
	 * Constraints
		1 <= N <= 10^6
		-10^9 <= A[i] <= 10^9
		-10^9 <= k <= 10^9
	
	 * Sample Input 1:
		5
		4 5 1 2 3
		1
		Sample Output 1:
		2
	 */
	
	// Time Complexity -> O(n), Space Complexity -> O(1)
	private static int search1(int[] arr, int target){
		int n = arr.length;
		int minIdx = 0;
		// Time Complexity -> O(n)
		for(int i = 1; i<n; i++){
			if(arr[i] < arr[i-1]){
				minIdx = i;
				break;
			}
		}
		int ans1 = binarySearch(arr, 0, minIdx-1, target);
		if(ans1 != -1){
			return ans1;
		}
		else{
			return binarySearch(arr, minIdx, n-1, target);
		}

	}	
	
	private static int binarySearch(int[] arr, int st, int end, int target){
		while(st <= end){
			int mid = st + (end-st)/2;
			if(arr[mid] == target){
				return mid;
			}
			else if(arr[mid] > target){
				end = mid-1;
			}
			else{
				st = mid+1;
			}
		}
		return -1;
	}
	
	// Time Complexity -> O(log(n)), Space Complexity -> O(1) [BEST APPROACH]
	private static int search2(int[] arr, int target){
		int n = arr.length;
		int minIdx = findMinIdx(arr, 0, n-1);
		int ans1 = binarySearch(arr, 0, minIdx-1, target);
		if(ans1 != -1){
			return ans1;
		}
		else{
			return binarySearch(arr, minIdx, n-1, target);
		}

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
		int target = sc.nextInt();
		System.out.println(search2(arr, target));
	}

}
