package optionalRecursion;

import java.util.Scanner;

public class TraingleArray {
	
	/*
	 * Harshit gave an array to Aahad and asked to make a triangle and calculate the topmost element of this array. For each layer, the element is the sum of two number below them and last layer is the given array.
For Example, for the array {1, 2, 3, 4}, the triangle will be:
        20
      8   12
   3    5    7
1    2    3     4
The Last layer is an array and each element is the sum of two numbers below. Your task is to find the top element of the array. As the element is very large, print answer modulo 1000000007.
Input Format
The First line contains the size of array: N 
Next line contains n space separated integers: a[i]
Output Format
The output contains a single line the answer modulo 1000000007
Constraints
1 =< N <= 10^3 
1 <= Ai <= 10^3
Sample Input1:
5
1 2 3 4 5
Sample Output1:
48
Explaination
In the Sample case, the triangle formed will be:
      [48]
    [20, 28]
   [8, 12, 16]
  [3, 5, 7, 9]
 [1, 2, 3, 4, 5]
	 */

	// Time Complexity -> O(n*n), Space Complexity -> O(n*n)
	public static long traingleArrayTopElement(long[] arr){
		int n = arr.length;
		if(n == 1){
			return arr[n-1];
		}
		long[] newArr = new long[n-1];
		for(int i = 0; i<n-1; i++){
			newArr[i] =(arr[i] + arr[i+1])%1000000007;
		}
		return traingleArrayTopElement(newArr);
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		long[] arr = new long[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		long ans = traingleArrayTopElement(arr);
		System.out.println(ans);
	}

}
