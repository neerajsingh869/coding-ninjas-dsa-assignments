package test2;

import java.util.ArrayList;
import java.util.Scanner;

public class LeadersInArray {
	
	/*
	 * Given an integer array A of size n. Find and print all the leaders present in the input array. An array element A[i] is called Leader, if all the elements following it (i.e. present at its right) are less than or equal to A[i].
Print all the leader elements separated by space and in the same order they are present in the input array.
Input Format :
Line 1 : Integer n, size of array
Line 2 : Array A elements (separated by space)
Output Format :
 leaders of array (separated by space)
Constraints :
1 <= n <= 10^6
Sample Input 1 :
6
3 12 34 2 0 -1
Sample Output 1 :
34 2 0 -1
Sample Input 2 :
5
13 17 5 4 6
Sample Output 2 :
17 6
	 */
	
	// Time complexity -> O(n*n), Space complexity -> O(1)
	public static void leaders1(int[] input) {
        int n = input.length;
        for(int i = 0; i<n-1; i++){
            int j = i+1;
            for(; j<n; j++){
                if(input[i] < input[j]){
                    break;
                }
            }
            if(j == n){
                System.out.print(input[i] + " ");
            }
        }
        System.out.print(input[n-1]);
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static void leaders2(int[] input) {
        int n = input.length;
        int max = Integer.MIN_VALUE;
        String ans = "";
        for(int i = n-1; i>=0; i--){
            if(input[i] >= max){
                ans = input[i] + " " + ans;
                max = Math.max(input[i], max);
            }
        }
        System.out.print(ans);
	}
	
	// Time complexity -> O(n), Space complexity -> O(n)
	public static void leaders3(int[] input) {
		int n = input.length;
		ArrayList<Integer> arr = new ArrayList<>();
		int maxNumTillNow = Integer.MIN_VALUE;
		for(int i = n-1; i>=0; i--){
			if(input[i] >= maxNumTillNow){
				maxNumTillNow = input[i];
				arr.add(input[i]);
			}
		}
		for(int i = arr.size() - 1; i>=0; i--){
			System.out.print(arr.get(i) + " " );
		}
	}

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
                int[] input = new int[n];  

		for(int i=0; i<n; i++) {  
                //reading array elements from the user   
                 input[i]=s.nextInt();  
                }  
		leaders3(input);

	}

}
