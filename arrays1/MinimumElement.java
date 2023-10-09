package arrays1;

import java.util.Scanner;

public class MinimumElement {
	
	/*
	 * Write a program that returns minimum element in an array.
		Input Format:
		First line input contains and integer N
		Next line contains N integers separated by space.
		Output Format:
		First line of output prints the minimum element in the array.
		Constraints:
		1<=N<=10^5
		Note:
		It is advisable to declare an array with a size that can accommodate all 
		the elements, considering that N has a maximum value of 10^5.
		Input 1:
		5 
		6 4 3 8 9
		Output 1:
		3
		Input 2:
		4
		8 8 8 8
		Output 2:
		8
	 */
	
	public static int minimum_element(int[] arr){
		int min = Integer.MAX_VALUE;

        for (int i : arr) {
            if (i < min) {
                min = i;
            }
        }

        return min;
    }

	public static void main(String[] args)  {
        Scanner sr = new Scanner(System.in);
        
            int n=sr.nextInt();
            int[] arr=new int[n];
            for (int i =0 ; i<n;i++)
            {
                arr[i]=sr.nextInt();
            }
            System.out.println(minimum_element(arr));
           
    }

}
