package optionalArrays;

import java.util.Arrays;
import java.util.Scanner;

public class DistributionProblem {
	
	/*
	 * Anuj is one of the finest instructors at Coding Ninjas. 
	 * He takes a batch of m students. He has been given n number 
	 * of chocolate cartons. Each carton can have a variable 
	 * number of chocolates. He has been given a task to 
	 * distribute the chocolates to his students on the occasion 
	 * of Holi. Now, here is the tricky part, he needs to distribute 
	 * the chocolates in such a way that:
	 
	 		1. Each student gets one carton of chocolate.
			2. The difference between the chocolate carton with the 
			maximum number of chocolates and the carton with the minimum 
			number of chocolates given to the students is minimum.

	 * Input format:
	   The first line of input contains number of chocolate cartons, 
	   n. The following line contains n space separated integers. 
	   The following line of input contains number of children to 
	   whom those n carton are to be distributed, m.  
	    
	 * Output format:
	   The first and only line of output contains the minimum difference 
	   possible between the student with maximum number of chocolates 
	   and the one with the minimum number of chocolates.
	   
	 * Constraints :
		1 <= n <= 100
		1 <= m <= n
		
	 * Sample Input 1 :
		7
		7 3 2 4 9 12 56
		3
		Sample Output 1 :
		2
		
	 * Sample Input 2 :
		6
		1 2 3 4 78 80
		3
		Sample Output 2 :
		2
	 */
	
	private static int distribution(int[] arr, int m){
		Arrays.sort(arr);
		int i = 0, j = m-1;
		int ans = Integer.MAX_VALUE;
		while(j < arr.length){
			ans = Math.min(ans, arr[j]-arr[i]);
			i++;
			j++;
		}
		return ans;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for(int i = 0; i<n; i++){
			arr[i] = sc.nextInt();
		}
		int m = sc.nextInt();
		System.out.println(distribution(arr, m));
	}

}