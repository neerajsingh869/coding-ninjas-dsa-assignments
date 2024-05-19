package arrays2;

import java.util.Arrays;
import java.util.Scanner;

public class SecondLargestInArray {
	
	/*
	 * You have been given a random integer array/list(ARR) 
	 * of size N. You are required to find and return the 
	 * second largest element present in the array/list.

		Detailed explanation ( Input/output format, Notes, Images )
		Input format :
		The first line contains an integer 'N' representing the 
		size of the array/list.
		
		The second line contains 'N' single space separated integers 
		representing the elements in the array/list.
		Output Format :
		Return the second largest element in the array/list.
		Constraints :
		0 <= N <= 10^2
		1<=arr[i]<=10^3
		
		Time Limit: 1 sec
		Sample Input 1:
		5
		4 3 10 9 2
		Sample Output 1:
		9
		Sample Input 2:
		7
		13 6 31 14 29 44 3
		Sample Output 2:
		31
	 */
	
	// Simple approach
	public static int secondLargestElement1(int[] arr) {
        int n = arr.length;
        
        Arrays.sort(arr);
        
        int ans = Integer.MIN_VALUE;
        for(int i = n-2; i>=0; i--){
            if(arr[i] < arr[n-1]){
                ans = arr[i];
                break;
            }
        }
        
        return ans;
    }
	
	// Better approach (Single scan)
	public static int secondLargestElement2(int[] arr) {
        int n = arr.length;
        
        int largest = Integer.MIN_VALUE, secondLargest = Integer.MIN_VALUE;
        for(int i = 0; i<n; i++){
            if(arr[i] > largest){
                secondLargest = largest;
                largest = arr[i];
            }
            else{
                if(arr[i] != largest && arr[i] > secondLargest){
                    secondLargest = arr[i];
                }
            }
        }
        
        return secondLargest;
    }
	
	// Better approach (Multiple scans)
	public static int secondLargestElement3(int[] arr, int n) {
    	int max = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            max = Math.max(max, arr[i]);
        }

        for (int i = 0; i < n; i++) {
            if (arr[i] != max) {
                secondMax = Math.max(secondMax, arr[i]);
            }
        }

        return secondMax;
    }

	public static void main(String[] args) 
	{
	    Scanner sr = new Scanner(System.in);
	    int n=sr.nextInt();
	    int ar[] = new int[n];
	    for(int i=0;i<n;i++)
	    {
	        ar[i]= sr.nextInt();
	    }
	    int ans = secondLargestElement3(ar,n);
	    System.out.println(ans);
	}

}
