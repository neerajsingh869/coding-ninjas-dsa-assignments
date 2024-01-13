package optionalPriorityQueues;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindTwoSortedArrays {
	
	/*
	 * You are given two sorted arrays with size M and N respectively, 
	 * you have to merge them into a sorted array.
	 * 
		Note: Try to merge them with O(1) space complexity.
		
		Input format:
		Line 1 : Size of first array i.e. M
		 Line 2 : M elements of first array separated by space
		 Line 3 : Size of second array i.e. N
		 Line 2 : N elements of second array separated by space
		 
		Output format:
		The output contains the two merged sorted arrays in different lines.
		
		Constraints:
		1<=M,N<=100000
		
		Sample Input:
		6
		1 5 9 10 15 20
		4
		2 3 8 13
		
		Sample Output:
		1 2 3 5 8 9
		10 13 15 20
	 */
	// Time complexity -> O(n + m), Space complexity -> O(n + m)
	public static void merge(int arr1[], int m, int arr2[], int n) {
		int[] ans = new int[m + n];
		int k = 0;
		int i = 0, j = 0;
		while (i < m && j < n) {
			if (arr1[i] < arr2[j]) {
				ans[k++] = arr1[i];
				i++;
			} else {
				ans[k++] = arr2[j];
				j++;
			}
		}
		
		while (i < m) {
			ans[k++] = arr1[i];
			i++;
		}
		
		while (j < n) {
			ans[k++] = arr2[j];
			j++;
		}
		
		k = 0;
		while (k < m) {
			arr1[k] = ans[k];
			k++;
		}
		while (k < m + n) {
			arr2[k - m] = ans[k];
			k++;
		}
	}

	static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
	public static int[] takeInput() throws IOException {
	    int size = Integer.parseInt(br.readLine().trim());
	    int[] input = new int[size];
	
	    if (size == 0) {
	        return input;
	    }
	    
		String[] strNums;
		strNums = br.readLine().trim().split(" ");
		
	    for (int i = 0; i < size; ++i) {
	        input[i] = Integer.parseInt(strNums[i]);
	    }
	
	    return input;
	}
	
	public static void printArray(int[] arr) {
	    for (int element : arr) {
	        System.out.print(element + " ");
	    }
	
	    System.out.println();
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
	    int[] arr1 = takeInput();
	    int m = arr1.length;
	    int[] arr2 = takeInput();
	    int n = arr2.length;
	    
	    merge(arr1, m, arr2, n);
	    
	    printArray(arr1);
	    printArray(arr2);
	
	}

}
