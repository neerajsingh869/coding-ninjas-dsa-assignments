package arrays1;

import java.util.Scanner;

public class IntersectionOfTwoArrays {
	
	/*
	 * You have been given two integer arrays/list(ARR1 and ARR2) 
	 * of size N and M, respectively. You need to print their 
	 * intersection; An intersection for this problem can be 
	 * defined when both the arrays/lists contain a particular 
	 * value or to put it in other words, when there is a common 
	 * value that exists in both the arrays/lists.
	 */
	
	public static void intersections(int arr1[], int arr2[]) {
    	//Your code goes here
        int n = arr1.length, m = arr2.length;
        for(int i = 0; i<n; i++){
            for(int j = 0; j<m; j++){
                if(arr1[i] == arr2[j]){
                    System.out.print(arr1[i] + " ");
                    arr2[j] = Integer.MIN_VALUE;
                    break;
                }
            }
        }
    }

	public static void main(String[] args) {
		 Scanner sr = new Scanner(System.in);
		 int t = sr.nextInt();
		 while(t > 0) 
			{
			int n=sr.nextInt();
			int[] arr1=new int[n];
			for (int i =0 ; i<n;i++)
			{
				arr1[i]=sr.nextInt();
			}
			int m =sr.nextInt();
			int[] arr2=new int[m];
			for (int i =0 ; i<m;i++)
			{
				arr2[i]=sr.nextInt();
			}
			intersections(arr1, arr2);
			System.out .println();
			t -= 1;
		}   
	}

}
